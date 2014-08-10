package com.myresume.app.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myresume.app.R;

public class HobbiesFragment extends BaseFragment {

    public static HobbiesFragment newInstance() {
        return new HobbiesFragment();
    }

    public HobbiesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hobbies, container, false);
    }

}
