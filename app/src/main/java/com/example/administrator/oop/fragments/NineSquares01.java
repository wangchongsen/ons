package com.example.administrator.oop.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.oop.R;

/**
 * Created by Administrator on 2015/6/25.
 */
public class NineSquares01 extends Fragment {

    @Override
public void onAttach(Activity activity){
    super.onAttach(activity);
}



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

//        View view = inflater.inflate(R.layout.f_heart, container, false);
//        mHeartView = (HeartView) view.findViewById(R.id.heartview);
//        mProgress = (MyProgress) view.findViewById(R.id.progress);
//        mBar = (RatingBar) view.findViewById(R.id.star);
        return  inflater.inflate(R.layout.activefragment1, container, false);

    }



}
