package com.example.android.persistence.ui;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.android.persistence.R;
import com.example.android.persistence.databinding.ProductItemBinding;
import com.example.android.persistence.model.Product;

import java.util.List;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm19930215@163.com
 * @since 2018/10/15 下午7:29
 **/
public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    List<? extends Product> mProductList;

    @Nullable
    private final ProductClickCallback mProductClickCallback;

    public ProductAdapter(@Nullable ProductClickCallback mProductClickCallback) {
        this.mProductClickCallback = mProductClickCallback;
    }


    public void setProductList(final List<? extends Product> productList){
        if(mProductList == null){
            mProductList = productList;
            notifyItemRangeInserted(0,productList.size());
        }else{
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return mProductList.size();
                }

                @Override
                public int getNewListSize() {
                    return productList.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    return mProductList.get(oldItemPosition).getId() ==
                            productList.get(newItemPosition).getId();
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    Product newProduct = productList.get(newItemPosition);
                    Product oldProduct = mProductList.get(oldItemPosition);
                    return newProduct.getId() == oldProduct.getId()
                            && Objects.equals(newProduct.getDescription(),oldProduct.getDescription())
                            && Objects.equals(newProduct.getName(),oldProduct.getName())
                            && newProduct.getPrice() == oldProduct.getPrice();
                }
            });

            mProductList = productList;
            result.dispatchUpdatesTo(this);


        }
    }


    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ProductItemBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()),R.layout.product_item,parent,false);
        binding.setCallback(mProductClickCallback);

        return new ProductViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.binding.setProduct(mProductList.get(position));
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mProductList == null ? 0 : mProductList.size();
    }

    static class ProductViewHolder  extends RecyclerView.ViewHolder{

        ProductItemBinding binding;

        public ProductViewHolder(ProductItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
