package com.example.android.persistence.db;

import android.content.Context;

import com.example.android.persistence.AppExecutors;
import com.example.android.persistence.db.converter.DateConverter;
import com.example.android.persistence.db.dao.CommentDao;
import com.example.android.persistence.db.dao.ProductDao;
import com.example.android.persistence.db.entity.CommentEntity;
import com.example.android.persistence.db.entity.ProductEntity;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm19930215@163.com
 * @since 2018/10/10 下午5:02
 **/
@Database(entities = {ProductEntity.class, CommentEntity.class},version = 1)
@TypeConverters(DateConverter.class)
public abstract class AppDatabase extends RoomDatabase {

    private volatile static AppDatabase sInstance;

    @VisibleForTesting
    public static final String DATABASE_NAME = "basic-sample-db";

    public abstract ProductDao productDao();

    public abstract CommentDao commentDao();

    private final MutableLiveData<Boolean> mIsDatabaseCreated = new MutableLiveData<>();

    public static AppDatabase getInstance(final Context context, final AppExecutors executors){
        if(sInstance == null){
           synchronized(AppDatabase.class){
            if(sInstance == null){
                sInstance = buildDatabase(context.getApplicationContext(),executors);
                sInstance.updateDatabaseCreated(context.getApplicationContext());
            }
           }
        }
        return sInstance;
    }



    private static AppDatabase buildDatabase(final Context appContext,
                                             final AppExecutors executors){
        return Room.databaseBuilder(appContext,AppDatabase.class,DATABASE_NAME)
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        executors.diskIO().execute(()->{
                            addDelay();

                            AppDatabase database = AppDatabase.getInstance(appContext,executors);
                            List<ProductEntity> products = DataGenerator.generateProducts();
                            List<CommentEntity> comments = DataGenerator.generateCommentsForProducts(products);

                            insertData(database,products,comments);

                            database.setDatabaseCreated();

                        });
                    }
                }).build();
    }


    private static void addDelay(){
        try{
            Thread.sleep(4000);
        }catch (InterruptedException ignored){

        }
    }

    private void updateDatabaseCreated(final Context context){
        if(context.getDatabasePath(DATABASE_NAME).exists()){
            setDatabaseCreated();
        }
    }

    private void setDatabaseCreated(){
        mIsDatabaseCreated.postValue(true);
    }


    private static void insertData(final AppDatabase database, final List<ProductEntity> products, final List<CommentEntity> comments){
        database.runInTransaction(()->{
            database.productDao().insertAll(products);
            database.commentDao().insertAll(comments);
        });
    }


    public LiveData<Boolean> getDatabaseCreated(){
        return mIsDatabaseCreated;
    }



}
