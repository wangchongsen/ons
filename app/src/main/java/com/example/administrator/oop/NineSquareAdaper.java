package com.example.administrator.oop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/6/25.
 */
public class NineSquareAdaper extends BaseAdapter {
    private Context context;

    public NineSquareAdaper(Context context) {
        this.context=context;
    }

    private Integer[] images = {
            //�Ź���ͼƬ������
            R.drawable.icon01,
            R.drawable.icon02,
            R.drawable.icon03,
            R.drawable.icon04,
            R.drawable.icon05,
            R.drawable.icon06,
            R.drawable.icon07,
            R.drawable.icon08,
            R.drawable.icon09,
    };
    private String[] texts = {
            //�Ź���ͼƬ�·����ֵ�����
            "������Դ",
            "��¼����",
            "�˱�����",
            "������",
            "�鿴ͼ��",
            "��֧����",
            "��¼�ĵ�",
            "���Ź���",
            "ϵͳ����",
    };
    @Override
    // 1  ��ϵͳ��ʼ����ListView��ʱ�����ȵ���getCount()�������õ����ķ���ֵ����ListView�ĳ���
    public int getCount() {
        return images.length;
    }
//getItem()��getItemId()������Ҫ�����ȡ��Adapter�е�����ʱ���á�
    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    // 2 ����getCount()���س�����һ����ListView��ÿһ��
    public View getView(int position, View convertView, ViewGroup parent) {
        ImgTextWrapper wrapper;
        if(convertView==null) {
            wrapper = new ImgTextWrapper();
//            ��ʵ�ʿ�����LayoutInflater����໹�Ƿǳ����õģ���������������findViewById()����ͬ����LayoutInflater��������res/layout/�µ�xml�����ļ�������ʵ��������findViewById()����xml�����ļ��µľ���widget�ؼ�(��Button��TextView��)��
//            �������ã�
//            1������һ��û�б����������Ҫ��̬����Ľ��棬����Ҫʹ��LayoutInflater.inflate()�����룻
//            2������һ���Ѿ�����Ľ��棬�Ϳ���ʹ��Activiyt.findViewById()������������еĽ���Ԫ��
            //http://www.cnblogs.com/top5/archive/2012/05/04/2482328.html
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.squares, null);
            convertView.setTag(wrapper);
            convertView.setPadding(15, 15, 15, 15);  //ÿ��ļ��
        } else {
            wrapper = (ImgTextWrapper)convertView.getTag();
        }

        wrapper.imageView = (ImageView)convertView.findViewById(R.id.ItemImage);
        wrapper.imageView.setBackgroundResource(images[position]);
        wrapper.textView = (TextView)convertView.findViewById(R.id.ItemText);
        wrapper.textView.setText(texts[position]);

        return convertView;
    }
}

class ImgTextWrapper {
    ImageView imageView;
    TextView textView;

}