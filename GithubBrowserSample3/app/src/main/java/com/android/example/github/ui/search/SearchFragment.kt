package com.android.example.github.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.android.example.github.AppExecutors
import com.android.example.github.binding.FragmentDataBindingComponent
import com.android.example.github.databinding.SearchFragmentBinding
import com.android.example.github.di.Injectable
import com.android.example.github.util.autoCleared
import com.android.example.github.R
import javax.inject.Inject

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2019/3/5 10:24 AM
 **/
class SearchFragment : Fragment(), Injectable {

    @Inject
    lateinit var appExecutors: AppExecutors

    var binding by autoCleared<SearchFragmentBinding>();

    var dataBindingComponent: DataBindingComponent = FragmentDataBindingComponent(this)

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.search_fragment,
                container,
                false,
                dataBindingComponent)

        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        searchViewModel


        super.onViewCreated(view, savedInstanceState)
    }


}
