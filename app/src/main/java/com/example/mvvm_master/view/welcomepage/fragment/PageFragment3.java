package com.example.mvvm_master.view.welcomepage.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvvm_master.R;
import com.example.mvvm_master.databinding.FragmentPage3Binding;

public class PageFragment3 extends Fragment {
    private FragmentPage3Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_page3, container, false);
        return binding.getRoot();
    }
}
