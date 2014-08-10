package com.myresume.app.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myresume.app.R;

public class EducationFragment extends BaseFragment {

    public static EducationFragment newInstance() {
        return  new EducationFragment();
    }

    public EducationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_education, container, false);
    }

}
