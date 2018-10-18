package com.example.android.contentprovidersample.data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm19930215@163.com
 * @since 2018/10/17 下午6:29
 **/
@Database(entities = {Cheese.class}, version = 1)
public abstract class SampleDatabase extends RoomDatabase {

    public abstract CheeseDao cheese();

    private static SampleDatabase sInstance;

    public static synchronized SampleDatabase getInstance(Context context){
        if(sInstance == null){
            sInstance = Room
                    .databaseBuilder(context.getApplicationContext(),SampleDatabase.class,"ex")
                    .build();
            sInstance.populateInitialData();
        }
        return  sInstance;
    }

    @VisibleForTesting
    public static void switchToInMemory(Context context){
        sInstance = Room.inMemoryDatabaseBuilder(context.getApplicationContext(),
                SampleDatabase.class).build();
    }

    private void populateInitialData(){
        if(cheese().count() == 0){
            Cheese cheese = new Cheese();
            beginTransaction();
            try{
                for(int i=0; i< Cheese.CHEESES.length; i++){
                    cheese.name = Cheese.CHEESES[i];
                    cheese().insert(cheese);
                }
                setTransactionSuccessful();

            }finally {
                endTransaction();
            }
        }
    }


    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {

    }
}
