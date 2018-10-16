package com.example.android.persistence.db.converter;



import java.util.Date;

import androidx.room.TypeConverter;

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm19930215@163.com
 * @since 2018/10/15 上午11:34
 **/
public class DateConverter {

    @TypeConverter
    public static Date toDate(Long timestamp){
        return timestamp == null ? null : new Date(timestamp);
    }


    @TypeConverter
    public static Long toTimestamp(Date date){
        return date == null ? null : date.getTime();
    }


}
