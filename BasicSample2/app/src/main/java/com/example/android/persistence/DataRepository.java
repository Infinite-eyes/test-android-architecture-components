package com.example.android.persistence;

import com.example.android.persistence.db.AppDatabase;
import com.example.android.persistence.db.entity.CommentEntity;
import com.example.android.persistence.db.entity.ProductEntity;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm19930215@163.com
 * @since 2018/10/15 下午5:43
 **/
public class DataRepository {

    private static DataRepository sInstance;

    private final AppDatabase mDatabase;
    private MediatorLiveData<List<ProductEntity>> mObservableProducts;


    private DataRepository(final AppDatabase database) {
        mDatabase = database;
        mObservableProducts = new MediatorLiveData<>();

        mObservableProducts.addSource(mDatabase.productDao().loadAllProducts(),
                productEntities -> {
                    if (mDatabase.getDatabaseCreated().getValue() != null) {
                        mObservableProducts.postValue(productEntities);
                    }
                });
    }

    public static DataRepository getInstance(final AppDatabase database) {
        if (sInstance == null) {
            synchronized (DataRepository.class) {
                if (sInstance == null) {
                    sInstance = new DataRepository(database);
                }
            }
        }
        return sInstance;
    }

    public LiveData<List<ProductEntity>> getProducts() {
        return mObservableProducts;
    }

    public LiveData<ProductEntity> loadProducts(final int productId) {
        return mDatabase.productDao().loadProduct(productId);
    }

    public LiveData<List<CommentEntity>> loadComments(final int productId) {
        return mDatabase.commentDao().loadComments(productId);
    }


}
