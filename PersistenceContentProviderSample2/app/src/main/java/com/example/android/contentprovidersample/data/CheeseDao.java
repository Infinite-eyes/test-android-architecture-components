package com.example.android.contentprovidersample.data;

import android.database.Cursor;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm19930215@163.com
 * @since 2018/10/17 下午6:16
 **/
@Dao
public interface CheeseDao {

    @Query("SELECT COUNT(*) FROM " + Cheese.TABLE_NAME)
    int count();

    @Insert
    long insert(Cheese cHeese);

    @Insert
    long[] insertAll(Cheese[] cheeses);


    @Query("SELECT * FROM " + Cheese.TABLE_NAME)
    Cursor selectAll();

    @Query("SELECT * FROM " + Cheese.TABLE_NAME + " WHERE " + Cheese.COLUMN_ID + "= :id")
    Cursor selectById(long id);

    @Query("DELETE FROM " + Cheese.TABLE_NAME + " WHERE " + Cheese.COLUMN_ID + " = :id")
    int deleteById(long id);

    @Update
    int update(Cheese cheese);




}
