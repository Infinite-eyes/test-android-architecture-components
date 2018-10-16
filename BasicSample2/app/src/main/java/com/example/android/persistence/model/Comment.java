package com.example.android.persistence.model;

import java.util.Date;

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm19930215@163.com
 * @since 2018/10/15 下午2:29
 **/
public interface Comment {
    int getId();
    int getProductId();
    String getText();
    Date getPostedAt();
}
