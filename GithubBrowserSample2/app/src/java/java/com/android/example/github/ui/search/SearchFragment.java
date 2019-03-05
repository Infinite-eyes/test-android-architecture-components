package com.android.example.github.ui.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.example.github.AppExecutors;
import com.android.example.github.R;
import com.android.example.github.databinding.SearchFragmentBinding;
import com.android.example.github.di.Injectable;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2018/12/11 7:55 PM
 **/
public class SearchFragment extends Fragment implements Injectable {

    @Inject
    public ViewModelProvider viewModelProvider;

    @Inject
    public AppExecutors appExecutors;


    private SearchFragmentBinding searchFragmentBinding;



//    private DataBindingComponent dataBindingComponent = new FragmentDataBindingComponent(this);


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        searchFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.search_fragment, container, false);
        return searchFragmentBinding.getRoot();
    }
}
