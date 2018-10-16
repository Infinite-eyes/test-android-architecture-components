package com.example.android.persistence.db.dao;



import com.example.android.persistence.db.entity.CommentEntity;

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
 * @since 2018/10/15 下午1:53
 **/
@Dao
public interface CommentDao {

    @Query("SELECT * FROM comments where productId = :productId")
    LiveData<List<CommentEntity>> loadComments(int productId);

    @Query("SELECT * FROM comments where productId =:productId")
    List<CommentEntity> loadCommentsSync(int productId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<CommentEntity> commens);

}
