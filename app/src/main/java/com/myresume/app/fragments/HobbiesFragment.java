package com.myresume.app.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.myresume.app.R;
import com.myresume.app.life.LifeSurfaceView;

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
        View rowView = inflater.inflate(R.layout.fragment_hobbies, container, false);
        FrameLayout placeHolder = (FrameLayout) rowView.findViewById(R.id.surface);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        placeHolder.addView(new LifeSurfaceView(getActivity()), params);
        placeHolder.setDrawingCacheEnabled(false);
        return rowView;
    }

}
