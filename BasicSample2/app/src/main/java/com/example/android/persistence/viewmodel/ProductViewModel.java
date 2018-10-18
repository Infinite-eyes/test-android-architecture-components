package com.example.android.persistence.viewmodel;

import android.app.Application;

import com.example.android.persistence.BasicApp;
import com.example.android.persistence.DataRepository;
import com.example.android.persistence.db.entity.CommentEntity;
import com.example.android.persistence.db.entity.ProductEntity;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm19930215@163.com
 * @since 2018/10/17 上午9:32
 **/
public class ProductViewModel extends AndroidViewModel {

    private final LiveData<ProductEntity> mObservableProduct;

    public ObservableField<ProductEntity> product = new ObservableField<>();

    private final int mProductId;

    private final LiveData<List<CommentEntity>> mObservableComment;

    public ProductViewModel(@NonNull Application application, DataRepository repository, final int productId) {
        super(application);
        mProductId = productId;

        mObservableComment = repository.loadComments(mProductId);
        mObservableProduct = repository.loadProducts(mProductId);
    }

    public LiveData<List<CommentEntity>> getComments(){
        return mObservableComment;
    }

    public LiveData<ProductEntity> getObservableProduct(){
        return mObservableProduct;
    }

    public void setProduct(ProductEntity product){
        this.product.set(product);
    }


    public static class Factory extends ViewModelProvider.NewInstanceFactory{

        @NonNull
        private final Application mApplication;

        private final int mProductId;

        private final DataRepository mRepository;


        public Factory(@NonNull Application application,int productId){
            mApplication =  application;
            mProductId = productId;
            mRepository = ((BasicApp)application).getRepository();
        }


        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new ProductViewModel(mApplication,mRepository,mProductId);
        }
    }



}
