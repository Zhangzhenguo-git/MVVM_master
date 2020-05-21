package com.example.mvvm_master.welcomepage.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvvm_master.R;
import com.example.mvvm_master.databinding.FragmentPage1Binding;

public class PageFragment1 extends Fragment {

    private FragmentPage1Binding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        通过DataBinding工具类实例化布局view
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_page1, container, false);
        return binding.getRoot();
    }
}
