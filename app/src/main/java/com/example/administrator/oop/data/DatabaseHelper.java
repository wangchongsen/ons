package com.example.administrator.oop.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.administrator.oop.util.Utils;

/**
 * JJ数据库管理类
 * <p>
 * Created by wcs on 2014/11/17 017.
 * </p>
 */
public class DatabaseHelper extends SQLiteOpenHelper
{

    public DatabaseHelper(Context context)
    {
        super(context,
              Utils.getDatabasePath(context),
              null,
                UserJjData.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(UserJjData.JJColumns.SQL_CREATE_TABLE);

        // 加入模拟数据
//        Random random = new Random();
//
//        StringBuilder sb = new StringBuilder();
//        for (int j = 0; j < 3; j++)
//        {
//            Calendar calendar = Calendar.getInstance();
//            for (int i = 0; i < 400; i++)
//            {
//                calendar.add(Calendar.DAY_OF_YEAR, -1);
//
//                int year = calendar.get(Calendar.YEAR);
//                int month = calendar.get(Calendar.MONTH) + 1;
//                int day = calendar.get(Calendar.DAY_OF_MONTH);
//                int second = 60000 + random.nextInt(10000);一天有86400秒
//                int score = 70 + random.nextInt(25);
//                sb.append("INSERT INTO heart(year_month,day_of_month,second_of_day,score) VALUES(")
//                  .append(year * 100 + month)
//                  .append(",")
//                  .append(day)
//                  .append(",")
//                  .append(second)
//                  .append(",")
//                  .append(score)
//                  .append(");");
//
//                db.execSQL(sb.toString());
//                sb.delete(0, sb.length());
//            }
//        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
//        db.execSQL("DROP TABLE IF EXISTS " + HeartProviderMetaData.HeartColumns.TABLE_NAME);
//        onCreate(db);
    }
}
