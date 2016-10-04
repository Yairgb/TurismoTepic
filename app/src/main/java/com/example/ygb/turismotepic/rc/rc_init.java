package com.example.ygb.turismotepic.rc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import com.example.ygb.turismotepic.db.db_init;

/**
 * Created by LAB-DES-05 on 03/10/2016.
 */

public class rc_init {
    private final db_init dbInit;
    private SQLiteDatabase database;
    private final String TAG = this.getClass().getName();

    public rc_init(Context context) { dbInit = new db_init(context); }
    public void open() throws SQLiteException { database = dbInit.getWritableDatabase(); }
    public void close() { database.close(); }
    public void read(){ database = dbInit.getReadableDatabase(); }
    /*------------------------------- Public Methods for RC_USER----------------------------------*/

}
