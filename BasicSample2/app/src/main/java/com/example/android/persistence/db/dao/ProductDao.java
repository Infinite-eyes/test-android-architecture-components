package com.example.android.persistence.db.dao;


import com.example.android.persistence.db.entity.ProductEntity;
import com.example.android.persistence.model.Product;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm19930215@163.com
 * @since 2018/10/15 下午1:50
 **/
@Dao
public interface ProductDao {

    @Query("SELECT * FROM products")
    LiveData<List<ProductEntity>> loadAllProducts();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<ProductEntity> productId);

    @Query("select * from products where id = :productId")
    LiveData<ProductEntity> loadProduct(int productId);

    @Query("select * from products where id = :productId")
    ProductEntity loadProductSync(int productId);


}
