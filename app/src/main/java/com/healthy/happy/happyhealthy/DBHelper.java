package com.healthy.happy.happyhealthy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DBNAME = "happyusers.db";
    private static final int DBVER = 1;
    public static final String DBTABLENAME = "users";

    public static final String KEY_ROWID = "_id";
    public static final String KEY_FNAME = "fullname";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_BIRTHDAY = "birthday";
    public static final String KEY_GENDER = "gender";

    public DBHelper(Context context) {
        super(context, DBNAME, null, DBVER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE users (ID INTEGER PRIMARY KEY AUTOINCREMENT, fullname TEXT NOT NULL, email TEXT NOT NULL, password TEXT NOT NULL, birthday TEXT NOT NULL, gender TEXT NOT NULL);";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(String pfullname, String pemail, String ppassword, String pbirthday, String pgender){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("fullname", pfullname);
        values.put("email", pemail);
        values.put("password", ppassword);
        values.put("birthday", pbirthday);
        values.put("gender", pgender);
        db.insert(DBTABLENAME, null, values);
    }

    public Cursor getDetails(String text) throws SQLException
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor mCursor =
                db.query(true, DBTABLENAME,
                        new String[]{KEY_ROWID, KEY_FNAME, KEY_EMAIL, KEY_PASSWORD, KEY_BIRTHDAY, KEY_GENDER},
                        KEY_FNAME + "=" + text,
                        null, null, null, null, null);
        if (mCursor != null)
        {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
}