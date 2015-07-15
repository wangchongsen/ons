package com.example.administrator.oop.util;

import android.content.Context;
import android.graphics.Color;
import android.os.Environment;
import android.util.Log;

import com.example.administrator.oop.R;
import com.example.administrator.oop.data.UserJjData;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 工具类<br/>
 * <br/>
 * Created by yanglw on 2014/9/16.
 */
public class Utils
{
    public static final String TAG = "heart_";
    private static final String FILE_ASSETS = "file:///android_assets/";

    /** 关闭流 */
    public static void close(Closeable closeable)
    {
        if (closeable != null)
        {
            try
            {
                closeable.close();
            }
            catch (IOException ignored)
            {
            }
        }
    }


    /**
     * 获取从颜色1过渡到颜色2的中间颜色
     *
     * @param color1
     *         颜色1
     * @param color2
     *         颜色2
     * @param p
     *         过渡百分比
     *
     * @return 过渡的颜色值
     */
    public static int gradient(int color1, int color2, float p)
    {
        int r1 = (color1 & 0xff0000) >> 16;
        int g1 = (color1 & 0xff00) >> 8;
        int b1 = color1 & 0xff;
        int r2 = (color2 & 0xff0000) >> 16;
        int g2 = (color2 & 0xff00) >> 8;
        int b2 = color2 & 0xff;
        int newr = (int) (r2 * p + r1 * (1 - p));
        int newg = (int) (g2 * p + g1 * (1 - p));
        int newb = (int) (b2 * p + b1 * (1 - p));
        return Color.argb(255, newr, newg, newb);
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static float dp2px(Context context, float dpValue)
    {
        float scale = context.getResources().getDisplayMetrics().density;
        return dpValue * scale + 0.5f;
    }

    public static File getEcgDir(Context context)
    {
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()))
        {
            return context.getExternalFilesDir(context.getString(R.string.directory_name));
        }

        return null;
    }

    public static String getDatabasePath(Context context)
    {
        return new File(context.getExternalFilesDir("database"),
                        UserJjData.DATABASE_NAME)
                .getAbsolutePath();
    }

    public static BufferedReader getReader(String path, Context context)
    {
        //获取数据输入流
        InputStream inputStream;
        try
        {
            // 从assets文件夹中获取数据
            if (context != null && path.startsWith(FILE_ASSETS))
            {
                inputStream = context.getAssets()
                                     .open(path.substring(FILE_ASSETS.length(),
                                                          path.length()
                                                         )
                                          );
            }
            else
            {
                inputStream = new FileInputStream(new File(path));
            }
        }
        catch (IOException e)
        {
            Log.e(Utils.TAG, path + "读取失败", e);
            return null;
        }

        //获取数据输入流
        return new BufferedReader(new InputStreamReader(inputStream));
    }

    public static long[] getLineData(String lineStr)
    {
        //读取一行内容，通过正则表达式获取指定数据
        Pattern p = Pattern.compile("(\\d+\\.?\\d*):\\s*(-?\\d+)\\s*(\\d+)\\s*(\\d+)");
        Matcher mat = p.matcher(lineStr);
        boolean rs = mat.find();
        if (rs)
        {
            //时间
            String timeStr = mat.group(1);
            //ADC
            int adc = Integer.valueOf(mat.group(2));
            //HeartRate4sAverage
            int a4 = Integer.valueOf(mat.group(3));
            //HeartRate30sAverage
            int a30 = Integer.valueOf(mat.group(4));

            //计算数据源中的时间所对应的毫秒数
            int year = Integer.valueOf(timeStr.subSequence(0, 2).toString());
            int month = Integer.valueOf(timeStr.subSequence(2, 4).toString());
            int day = Integer.valueOf(timeStr.subSequence(4, 6).toString());
            String second = timeStr.subSequence(6, timeStr.length()).toString();
            String[] s = second.split("\\.");

            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month - 1, day);
            calendar.set(Calendar.SECOND, Integer.valueOf(s[0]));
            calendar.set(Calendar.MILLISECOND, Integer.valueOf(s[1]));
            //获取毫秒数
            long time = calendar.getTimeInMillis();

            return new long[]{time, adc, a4, a30};
        }
        return null;
    }
}
