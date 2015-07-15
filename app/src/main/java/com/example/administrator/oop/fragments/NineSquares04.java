package com.example.administrator.oop.fragments;

/**
 * Created by Administrator on 2015/7/1.
 */
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

import com.example.administrator.oop.R;

public class NineSquares04 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view1 = inflater.inflate(R.layout.td001, container, false);
        View view2 = inflater.inflate(R.layout.tab1view, container, false);
        //�õ�TabHost����ʵ��
        TabHost  tabhost =(TabHost)view1.findViewById(R.id.tabHost);
        //���� TabHost.setup()
        tabhost.setup();
        //����Tab��ǩ
        tabhost.addTab(tabhost.newTabSpec("one").setIndicator("��ɫ").setContent(R.id.listView2));
        tabhost.addTab(tabhost.newTabSpec("two").setIndicator("��ɫ").setContent(R.id.listView2));
        tabhost.addTab(tabhost.newTabSpec("3").setIndicator("lanɫ").setContent(R.id.listView2));
       // tabhost.setOnClickListener();

        return view1;
    }
}
