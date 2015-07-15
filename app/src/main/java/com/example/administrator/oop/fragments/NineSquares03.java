package com.example.administrator.oop.fragments;

/**
 * Created by Administrator on 2015/7/1.
 */
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.oop.R;

public class NineSquares03 extends Fragment {
    private boolean isChoosing;

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

//       Window window = getWindow();//得到窗口
//        requestWindowFeature(Window.FEATURE_NO_TITLE);//没有标题
        //window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏
//        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);//设置高亮
      //  至此，我们将窗口的显示方式规定死了，然后才能设置窗口上显示的组件(顺序非常重要)
       // setContentView(R.layout.main);
        View view = inflater.inflate(R.layout.ns03, container, false);
        SurfaceView surfaceView = (SurfaceView) view.findViewById(R.id.surfaceView);
        surfaceView.getHolder().setFixedSize(600, 480);
        surfaceView.getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
//        surfaceView.getHolder().addCallback(new SurfaceCallback());




//        TextView presonalInfor =(TextView)view.findViewById(R.id.textView4);
//        TextView introduction =(TextView)view.findViewById(R.id.textView5);
//        EditText introductionIndex =(EditText)view.findViewById(R.id.editText5);
//        EditText ID =(EditText)view.findViewById(R.id.editText5);
//        Editable personID = ID.getEditableText();
//        String text="005447";
//        personID.append(text);
//        String sss ="这是一个 机器人";
//        introduction.setText(sss);
//        presonalInfor.setText("姓名:安卓 \n年龄：110");

        return view;
    }


}
