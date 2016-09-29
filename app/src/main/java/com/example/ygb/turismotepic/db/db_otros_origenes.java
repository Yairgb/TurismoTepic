package com.example.ygb.turismotepic.db;

/**
 * Created by LAB-DES-05 on 28/09/2016.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class db_otros_origenes extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="turismo.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "otro_origen";
    public static final String COLUMN_NAME_IDPK = "id_otro_origen";
    public static final String COLUMN_NAME_COUNTRY = "pais";





    //--------------------------------Delete Table Query
    public static final String SQL_DELETE_ENTRIES = " DROP TABLE IF EXIST " + TABLE_NAME;
    //--------------------------------Create Table Query
    public static final String CREATE_TABLE = " create table "
            + TABLE_NAME + " ( "
            + COLUMN_NAME_IDPK
            + " integer primary key, "
            + COLUMN_NAME_COUNTRY
            + " text )";


    public db_otros_origenes(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(db_otros_origenes.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
}
