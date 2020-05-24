package com.example.mvvm_master.view.welcomepage.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvvm_master.R;
import com.example.mvvm_master.databinding.FragmentPage2Binding;

public class PageFragment2 extends Fragment {

    private FragmentPage2Binding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_page2, container, false);
        return binding.getRoot();
    }
}
