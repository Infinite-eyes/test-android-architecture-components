package com.android.example.github.binding;

import android.widget.ImageView;


import javax.inject.Inject;

import androidx.fragment.app.Fragment;

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2019/1/4 7:39 PM
 **/
public class FragmentBindingAdapters {

    private final Fragment fragment;

    @Inject
    public FragmentBindingAdapters(Fragment fragment){
        this.fragment = fragment;
    }

    public Fragment getFragment() {
        return this.fragment;
    }


    public void bindImage(ImageView imageView,String url){

    }



}
