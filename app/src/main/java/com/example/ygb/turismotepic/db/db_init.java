package com.example.ygb.turismotepic.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by LAB-DES-05 on 26/09/2016.
 */

public class db_init extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "turismo.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TAG = "DB EXEC";

    public db_init(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}