package com.example.administrator.oop;

import android.app.Activity;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.media.session.MediaControllerCompat;
import android.view.Menu;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2015/7/10.
 */
public class PhotoActivity extends Activity implements SurfaceHolder.Callback, View.OnClickListener {

    SurfaceView surfaceView;
    SurfaceHolder surfaceHolder;
    boolean isPreview = false;         //显示是否摄像头是否打开
    Button startButton;
    Button stopButton;
    Camera myCamera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ns03);
        surfaceView = (SurfaceView) findViewById(R.id.sv);
        startButton = (Button) findViewById(R.id.button6);
        stopButton = (Button) findViewById(R.id.button8);
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(this);
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        startButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);


    }

    void initCamera(){
        myCamera = Camera.open();
        try {
            myCamera.setPreviewDisplay(surfaceHolder);
            myCamera.setDisplayOrientation(90);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button6:
                if(myCamera==null&&!isPreview){
                    initCamera();
                    myCamera.startPreview();		//开启预览
                    isPreview = true;
                }
                else if(myCamera!=null&&!isPreview){
                    myCamera.startPreview();
                    isPreview = true;
                }
                else{
                    myCamera.stopPreview();				//结束预览
                    isPreview = false;
                }
                break;
            case R.id.button2:
                if(isPreview){
                    myCamera.stopPreview();  //关闭摄像头预览
                    myCamera.release();		//放开摄像头
                    myCamera=null;
                    isPreview = false;
                }

                break;

            default:
                break;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
        // TODO Auto-generated method stub

    }

    @Override
    public void surfaceCreated(SurfaceHolder arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder arg0) {
        // TODO Auto-generated method stub

    }

}
