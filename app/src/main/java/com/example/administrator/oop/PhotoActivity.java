//package com.example.administrator.oop;
//
//import android.app.Activity;
//import android.hardware.Camera;
//import android.os.Bundle;
//import android.support.v4.app.FragmentActivity;
//import android.view.SurfaceHolder;
//import android.view.SurfaceView;
//import android.view.View;
//import android.view.Window;
//import android.widget.AdapterView;
//import android.widget.Button;
//import android.widget.GridView;
//
//import java.io.FileOutputStream;
//import java.io.IOException;
//
///**
// * Created by Administrator on 2015/7/10.
// */
//public class PhotoActivity extends Activity {
//    private SurfaceView previewSV;
//    private Camera camera;
//    //回调程序，外观控件对象一加载，创建、销毁、改变时对应执行各个回调函数
//    private Callback callback=new Callback() {
//        //一摧毁时：
//        @Override
//        public void surfaceDestroyed(SurfaceHolder holder) {
//            if(camera!=null){}
//            //停止预览、释放资源、垃圾回收
//            camera.stopPreview();
//            camera.release();
//            camera=null;
//        }
//        //一创建时：
//        @Override
//        public void surfaceCreated(SurfaceHolder holder) {
//            try {
//                //打开摄像头
//                camera=Camera.open();
//
//
//                /*
//    　　　　　　如果想改变摄像头的参数，可以进行自定义设置，打印一下看摄像头有哪些参数，都是可改的
//                Parameters params=camera.getParameters();
//                //打印所有参数的方法：System.out.println(params.flatten());
//                                           设置图片尺寸
//                params.setPictureSize(width, height);
//                                           设置预览尺寸
//                params.setPreviewSize(width, height);
//                设置图片质量
//                params.setJpegQuality(quality);
//                设置好了，执行一下设置
//                camera.setParameters(params);
//                */
//
//
//                //摄像头把预览结果交给外观控件SurfaceView的控制者 ，显示在外观控件上
//                camera.setPreviewDisplay(previewSV.getHolder());
//                //开始预览，抓取预览交给外观控件
//                camera.startPreview();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        //一改变时：
//        @Override
//        public void surfaceChanged(SurfaceHolder holder, int format, int width,
//                                   int height) {
//
//        }
//    };
//    /** Called when the activity is first created. */
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.ns03);
//        previewSV = (SurfaceView) findViewById(R.id.surfaceView);
//        //设置外观的类型
//        previewSV.getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
//        //设置回调，创建好了外观控件才打开摄像头
//        previewSV.getHolder().addCallback(callback);
//
//    }
//    public void take(View view){
//        //拍照时手机先自动对焦，对好了才自动拍照，自动对焦回调程序里，设置对焦完成后执行拍照方法
//        camera.autoFocus(new MyAutoFocusCallback());
//    }
//
//    private class MyAutoFocusCallback implements AutoFocusCallback{
//        @Override
//        public void onAutoFocus(boolean success, Camera camera) {
//         //拍照函数需要三个callback，一个是快门按下时怎么样、一个是获取到了原始的预览时怎么样，
//           //　一个是当已经拍了获得了压缩好的图片时怎么样
//            camera.takePicture(null, null, new MyPictureCallback());
//        }
//    }
//    private class MyPictureCallback implements PictureCallback{
//        @Override
//        public void onPictureTaken(byte[] data, Camera camera) {
//            try {
//                FileOutputStream fos=new FileOutputStream("/mnt/sdcard/"+System.currentTimeMillis()+".jpg");
//                fos.write(data);
//                fos.close();
//                //拍完照后继续预览，准备下次拍照
//                camera.startPreview();
//            } catch (Exception e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
//    }
//
//
//
//
//
//}
