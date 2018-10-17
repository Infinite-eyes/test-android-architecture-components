package com.example.android.persistence.viewmodel;

import android.app.Application;

import com.example.android.persistence.BasicApp;
import com.example.android.persistence.db.entity.ProductEntity;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm19930215@163.com
 * @since 2018/10/16 上午10:25
 **/
public class ProductListViewModel extends AndroidViewModel {

    private final MediatorLiveData<List<ProductEntity>> mObservableProducts;


    public ProductListViewModel(Application application) {
        super(application);
        mObservableProducts = new MediatorLiveData<>();
        mObservableProducts.setValue(null);

        LiveData<List<ProductEntity>> products = ((BasicApp)application).getRepository().getProducts();

        mObservableProducts.addSource(products,mObservableProducts::setValue);

    }

    public LiveData<List<ProductEntity>> getProducts(){
        return mObservableProducts;
    }

}
