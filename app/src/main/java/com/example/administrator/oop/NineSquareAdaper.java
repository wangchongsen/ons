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
            //九宫格图片的设置
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
            //九宫格图片下方文字的设置
            "人力资源",
            "记录收入",
            "账本管理",
            "类别管理",
            "查看图表",
            "收支对照",
            "记录心得",
            "新闻公告",
            "系统设置",
    };
    @Override
    // 1  当系统开始绘制ListView的时候，首先调用getCount()方法。得到它的返回值，即ListView的长度
    public int getCount() {
        return images.length;
    }
//getItem()和getItemId()则在需要处理和取得Adapter中的数据时调用。
    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    // 2 根据getCount()返回长度逐一绘制ListView的每一行
    public View getView(int position, View convertView, ViewGroup parent) {
        ImgTextWrapper wrapper;
        if(convertView==null) {
            wrapper = new ImgTextWrapper();
//            在实际开发中LayoutInflater这个类还是非常有用的，它的作用类似于findViewById()。不同点是LayoutInflater是用来找res/layout/下的xml布局文件，并且实例化；而findViewById()是找xml布局文件下的具体widget控件(如Button、TextView等)。
//            具体作用：
//            1、对于一个没有被载入或者想要动态载入的界面，都需要使用LayoutInflater.inflate()来载入；
//            2、对于一个已经载入的界面，就可以使用Activiyt.findViewById()方法来获得其中的界面元素
            //http://www.cnblogs.com/top5/archive/2012/05/04/2482328.html
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.squares, null);
            convertView.setTag(wrapper);
            convertView.setPadding(15, 15, 15, 15);  //每格的间距
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