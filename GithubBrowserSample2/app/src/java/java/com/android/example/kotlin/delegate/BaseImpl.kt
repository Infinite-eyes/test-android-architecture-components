package com.android.example.kotlin.delegate

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2019/1/18 5:13 PM
 **/
class BaseImpl(val x: Int) : Base{
    override fun print() {
        print(x);
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}