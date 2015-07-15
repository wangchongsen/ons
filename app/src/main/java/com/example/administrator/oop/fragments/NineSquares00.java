package com.example.administrator.oop.fragments;

/**
 * Created by Administrator on 2015/7/1.
 */
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.oop.R;

public class NineSquares00 extends Fragment {
    private boolean isChoosing;

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
         View view = inflater.inflate(R.layout.temp, container, false);
        ImageView preson = (ImageView )view.findViewById(R.id.imageView2);

        TextView presonalInfor =(TextView)view.findViewById(R.id.textView4);
        TextView introduction =(TextView)view.findViewById(R.id.textView5);
        EditText introductionIndex =(EditText)view.findViewById(R.id.editText5);
        EditText ID =(EditText)view.findViewById(R.id.editText5);
          Editable personID = ID.getEditableText();
        String text="005447";
        personID.append(text);
        String sss ="这是一个 机器人";
        introduction.setText(sss);
        presonalInfor.setText("姓名:安卓 \n年龄：110");

        return view;
    }





    }

