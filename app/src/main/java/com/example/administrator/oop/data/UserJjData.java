package com.example.administrator.oop.data;
import android.provider.BaseColumns;
/**
 * Created by Administrator on 2015/7/10.
 */
public class UserJjData {
    /** 数据库名称 */
    public static final String DATABASE_NAME = "BigJJ.db";
    /** 数据库版本 */
    public static final int DATABASE_VERSION = 1;

    /**
     * 用户基础信息分类后
     */
    public static final class JJColumns implements BaseColumns
    {
        /** 表名 */
        public static final String TABLE_NAME = "bigjj";
        /**
         * 数据库表字段，表示年月。数据的前四位表示年份，后两位表示月份。
         * <ul>
         * <li>类型：整型。</li>
         * <li>限制：后两位数字范围：1~12。</li>
         * <li>范例：数据内容：201411，表示2014年11月。</li>
         * </ul>
         */
        public static final String YEAR_MONTH = "year_month";
        /**
         * 数据库表字段，表示一个月中的某天。
         * <ul>
         * <li>类型：整型。</li>
         * <li>限制：范围：1~31。根据实际的月份的天数进行限制。</li>
         * <li>范例：数据内容：20，表示20号。</li>
         * </ul>
         */
        public static final String DAY_OF_MONTH = "day_of_month";
        /**
         * 数据库表字段，表示一天中的某秒。
         * <ul>
         * <li>类型：整型。</li>
         * <li>限制：范围：0~86400。</li>
         * <li>范例：数据内容：20，表示20号。</li>
         * </ul>
         */
        public static final String SECOND_OF_DAY = "second_of_day";
        /**
         * 数据库表字段，某一次心跳跑分的分数。
         * <ul>
         * <li>类型：整型。</li>
         * <li>限制：范围：0~100。</li>
         * <li>范例：数据内容：20，表示分数为20。</li>
         * </ul>
         */
        public static final String SCORE = "score";
       // public static final String ID = "id";
        public static final String PASSWORD = "password";

        /** 表的创建语句。 */
        public static final String SQL_CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
                + _ID + " INTEGER PRIMARY KEY,"
                + YEAR_MONTH + " INTEGER,"
                + DAY_OF_MONTH + " INTEGER,"
                + SECOND_OF_DAY + " INTEGER,"
                + SCORE + " INTEGER"
                +PASSWORD+"STRING"
                + ");";
    }








}
