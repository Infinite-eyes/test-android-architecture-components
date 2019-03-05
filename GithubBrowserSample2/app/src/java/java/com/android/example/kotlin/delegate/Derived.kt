package com.android.example.kotlin.delegate

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2019/1/18 5:14 PM
 **/
class Derived(b: Base): Base by b{

    fun main(args: Array<String>){
        val b = BaseImpl(10)
        Derived(b).print()
    }
}

