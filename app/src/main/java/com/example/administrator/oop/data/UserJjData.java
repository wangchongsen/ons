package com.example.administrator.oop.data;
import android.provider.BaseColumns;
/**
 * Created by Administrator on 2015/7/10.
 */
public class UserJjData {
    /** ���ݿ����� */
    public static final String DATABASE_NAME = "BigJJ.db";
    /** ���ݿ�汾 */
    public static final int DATABASE_VERSION = 1;

    /**
     * �û�������Ϣ�����
     */
    public static final class JJColumns implements BaseColumns
    {
        /** ���� */
        public static final String TABLE_NAME = "bigjj";
        /**
         * ���ݿ���ֶΣ���ʾ���¡����ݵ�ǰ��λ��ʾ��ݣ�����λ��ʾ�·ݡ�
         * <ul>
         * <li>���ͣ����͡�</li>
         * <li>���ƣ�����λ���ַ�Χ��1~12��</li>
         * <li>�������������ݣ�201411����ʾ2014��11�¡�</li>
         * </ul>
         */
        public static final String YEAR_MONTH = "year_month";
        /**
         * ���ݿ���ֶΣ���ʾһ�����е�ĳ�졣
         * <ul>
         * <li>���ͣ����͡�</li>
         * <li>���ƣ���Χ��1~31������ʵ�ʵ��·ݵ������������ơ�</li>
         * <li>�������������ݣ�20����ʾ20�š�</li>
         * </ul>
         */
        public static final String DAY_OF_MONTH = "day_of_month";
        /**
         * ���ݿ���ֶΣ���ʾһ���е�ĳ�롣
         * <ul>
         * <li>���ͣ����͡�</li>
         * <li>���ƣ���Χ��0~86400��</li>
         * <li>�������������ݣ�20����ʾ20�š�</li>
         * </ul>
         */
        public static final String SECOND_OF_DAY = "second_of_day";
        /**
         * ���ݿ���ֶΣ�ĳһ�������ֵܷķ�����
         * <ul>
         * <li>���ͣ����͡�</li>
         * <li>���ƣ���Χ��0~100��</li>
         * <li>�������������ݣ�20����ʾ����Ϊ20��</li>
         * </ul>
         */
        public static final String SCORE = "score";
       // public static final String ID = "id";
        public static final String PASSWORD = "password";

        /** ��Ĵ�����䡣 */
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
