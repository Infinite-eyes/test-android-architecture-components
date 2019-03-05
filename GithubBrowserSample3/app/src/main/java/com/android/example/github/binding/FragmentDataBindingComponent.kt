package com.android.example.github.binding

import androidx.databinding.DataBindingComponent
import androidx.fragment.app.Fragment

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2019/3/5 3:43 PM
 **/
class FragmentDataBindingComponent(fragment: Fragment) : DataBindingComponent {

    private val adapter = FragmentBindingAdapters(fragment)

    override fun getFragmentBindingAdapters() = adapter

}