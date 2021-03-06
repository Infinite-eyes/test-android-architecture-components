package com.example.android.persistence.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.persistence.R;
import com.example.android.persistence.databinding.ProductFragmentBinding;
import com.example.android.persistence.db.entity.CommentEntity;
import com.example.android.persistence.db.entity.ProductEntity;
import com.example.android.persistence.model.Comment;
import com.example.android.persistence.viewmodel.ProductViewModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm19930215@163.com
 * @since 2018/10/16 下午8:07
 **/
public class ProductFragment extends Fragment {

    private static final String KEY_PRODUCT_ID = "product_id";

    private ProductFragmentBinding mBinding;

    private CommentAdapter mCommentAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.product_fragment,container,false);

        mCommentAdapter = new CommentAdapter(mCommentClickCallback);
        mBinding.commentList.setAdapter(mCommentAdapter);


        return mBinding.getRoot();
    }


    private final CommentClickCallback mCommentClickCallback = new CommentClickCallback(){
        @Override
        public void onClick(Comment comment) {

        }
    };

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ProductViewModel.Factory factory = new ProductViewModel.Factory(
                getActivity().getApplication(),getArguments().getInt(KEY_PRODUCT_ID));

                final ProductViewModel model = ViewModelProviders.of(this,factory)
                        .get(ProductViewModel.class);

                mBinding.setProductViewModel(model);

                subscribeToModel(model);

    }

    private void subscribeToModel(final ProductViewModel model){

        model.getObservableProduct().observe(this, new Observer<ProductEntity>() {
            @Override
            public void onChanged(ProductEntity productEntity) {
                model.setProduct(productEntity);
            }
        });

        model.getComments().observe(this,new Observer<List<CommentEntity>>(){

            @Override
            public void onChanged(List<CommentEntity> commentEntities) {
                if(commentEntities!=null){
                    mBinding.setIsLoading(false);
                    mCommentAdapter.setCommentList(commentEntities);
                }else{
                    mBinding.setIsLoading(true);
                }
            }
        });
    }

    public static ProductFragment forProduct(int productId){
        ProductFragment fragment = new ProductFragment();
        Bundle args= new Bundle();
        args.putInt(KEY_PRODUCT_ID,productId);
        fragment.setArguments(args);
        return fragment;
    }












}
