package com.example.android.persistence.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.persistence.R;
import com.example.android.persistence.databinding.ListFragmentBinding;
import com.example.android.persistence.db.entity.ProductEntity;
import com.example.android.persistence.model.Product;
import com.example.android.persistence.viewmodel.ProductListViewModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm19930215@163.com
 * @since 2018/10/15 下午7:27
 **/
public class ProductListFragment extends Fragment {

    public static final String TAG = "ProductListViewModel";

    private ProductAdapter mProductAdapter;

    private ListFragmentBinding mBinding;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater,R.layout.list_fragment,container,false);

        mProductAdapter = new ProductAdapter(mProductClickCallback);
        mBinding.productsList.setAdapter(mProductAdapter);

        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final ProductListViewModel viewModel = ViewModelProviders.of(this).get(ProductListViewModel.class);
        subscribeUi(viewModel);
    }


    private void subscribeUi(ProductListViewModel viewModel){
        viewModel.getProducts().observe(this, new Observer<List<ProductEntity>>() {
            @Override
            public void onChanged(@Nullable List<ProductEntity> productEntities) {
                if(productEntities != null){
                    mBinding.setIsLoading(false);
                    mProductAdapter.setProductList(productEntities);
                }else{
                    mBinding.setIsLoading(true);
                }
                mBinding.executePendingBindings();
            }
        });
    }

    private final ProductClickCallback mProductClickCallback = new ProductClickCallback() {
        @Override
        public void onClick(Product product) {
            if(getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)){
                ((MainActivity) getActivity()).show(product);
            }
        }
    };



}
