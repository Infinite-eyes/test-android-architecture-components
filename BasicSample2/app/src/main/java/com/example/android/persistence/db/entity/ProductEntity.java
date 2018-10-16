package com.example.android.persistence.db.entity;

import com.example.android.persistence.model.Product;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm19930215@163.com
 * @since 2018/10/15 下午2:19
 **/
@Entity(tableName = "products")
public class ProductEntity implements Product {

    @PrimaryKey
    private int id;
    private String name;
    private String description;
    private int price;

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ProductEntity() {
    }

    @Ignore
    public ProductEntity(int id, String name, String description, int price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public ProductEntity(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
    }
}
