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
//    //�ص�������ۿؼ�����һ���أ����������١��ı�ʱ��Ӧִ�и����ص�����
//    private Callback callback=new Callback() {
//        //һ�ݻ�ʱ��
//        @Override
//        public void surfaceDestroyed(SurfaceHolder holder) {
//            if(camera!=null){}
//            //ֹͣԤ�����ͷ���Դ����������
//            camera.stopPreview();
//            camera.release();
//            camera=null;
//        }
//        //һ����ʱ��
//        @Override
//        public void surfaceCreated(SurfaceHolder holder) {
//            try {
//                //������ͷ
//                camera=Camera.open();
//
//
//                /*
//    �����������������ı�����ͷ�Ĳ��������Խ����Զ������ã���ӡһ�¿�����ͷ����Щ���������ǿɸĵ�
//                Parameters params=camera.getParameters();
//                //��ӡ���в����ķ�����System.out.println(params.flatten());
//                                           ����ͼƬ�ߴ�
//                params.setPictureSize(width, height);
//                                           ����Ԥ���ߴ�
//                params.setPreviewSize(width, height);
//                ����ͼƬ����
//                params.setJpegQuality(quality);
//                ���ú��ˣ�ִ��һ������
//                camera.setParameters(params);
//                */
//
//
//                //����ͷ��Ԥ�����������ۿؼ�SurfaceView�Ŀ����� ����ʾ����ۿؼ���
//                camera.setPreviewDisplay(previewSV.getHolder());
//                //��ʼԤ����ץȡԤ��������ۿؼ�
//                camera.startPreview();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        //һ�ı�ʱ��
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
//        //������۵�����
//        previewSV.getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
//        //���ûص�������������ۿؼ��Ŵ�����ͷ
//        previewSV.getHolder().addCallback(callback);
//
//    }
//    public void take(View view){
//        //����ʱ�ֻ����Զ��Խ����Ժ��˲��Զ����գ��Զ��Խ��ص���������öԽ���ɺ�ִ�����շ���
//        camera.autoFocus(new MyAutoFocusCallback());
//    }
//
//    private class MyAutoFocusCallback implements AutoFocusCallback{
//        @Override
//        public void onAutoFocus(boolean success, Camera camera) {
//         //���պ�����Ҫ����callback��һ���ǿ��Ű���ʱ��ô����һ���ǻ�ȡ����ԭʼ��Ԥ��ʱ��ô����
//           //��һ���ǵ��Ѿ����˻����ѹ���õ�ͼƬʱ��ô��
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
//                //�����պ����Ԥ����׼���´�����
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
