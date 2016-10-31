package com.example.ygb.turismotepic.db;

/**
 * Created by LAB-DES-05 on 27/09/2016.
 */

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class db_pois extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="turismo.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "pois";
    public static final String COLUMN_NAME_ID = "id_poi";
    public static final String COLUMN_NAME_ID_CATEGORIA = "id_categoria";
    public static final String COLUMN_NAME_POI = "nombre";
    public static final String COLUMN_NAME_SHORT_DESCRIPCION = "descripcion_corta";
    public static final String COLUMN_NAME_LONG_DESCRIPCION = "descripcion_larga";
    public static final String COLUMN_NAME_LAT = "latitud";
    public static final String COLUMN_NAME_LON = "longitud";
    public static final String COLUMN_NAME_HORARIO = "horario";
    public static final String COLUMN_NAME_CALF = "calificacion";
    public static final String COLUMN_NAME_COSTO = "costo";
    public static final String COLUMN_NAME_COSTOAPROX = "costo_aprox";


    //--------------------------------Insert Table Query
    public static final String SQL_INSERT_ENTRIES = "INSERT INTO `pois` (`id_poi`, `id_categoria`, `nombre`,`descripcion_larga`,`latitud`, `longitud`, `horario`, `calificacion`, `costo`) " +
            "VALUES " +
            "(1,3,'Catedral ,'En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, " +
            "un templo católico correspondiente a la diócesis de la zona. Considerada como la Iglesia Madre; preside las celebraciones litúrgicas, " +
            "brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.5105914','-104.8906753')" +

            "(1,3,'Catedral ,'En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.5105914','-104.8906753'),"+
            "(2,1,'Hotel Fray Junípero Serra ,'','21.5090809','-104.8919096'),"+
            "(3,4,'Casa Museo de Juan Escutia ,'','21.5095973','-104.8907031'),"+
            "(4,4,'Casa Mueso de Amado Nervo ,'','21.5105914','-104.8906753'),"+
            "(5,3,'Pérgola (Plaza principal) ,'','21.512184','-104.892335'),"+
            "(6,3,'Fuente principal (Plaza principal) ,'','21.512084','-104.892021'),"+
            "(7,3,'Fuente de delfín (Plaza principal) ,'','21.512256','-104.892497'),"+
            "(8,4,'Escuela Superior de Música ,'','21.5086155','-104.8904644'),"+
            "(9,4,'Casa Fenelón ,'','21.5095587','-104.8906283'),"+
            "(10,3,'Busto de Carranza (Plaza antigua) ,'','21.5095587','-104.8906283'),"+
            "(11,4,'Museo Regional INAH,'','21.5099214','-104.892416'),"+
            "(12,10,'Oficinas regionales del INAH ,'','21.5086601','-104.8910246'),"+
            "(13,10,'Centro Estatal de Culturas Populares e Indígenas (CECUPI) ,'','21.5101323','-104.8923121'),"+
            "(14,10,'Centro de Arte Contemporáneo del Bicentenario Emilia Ortíz ,'','21.5107362','-104.8920432'),"+
            "(15,9,'El cerro de la Cruz ,'','21.533983','-104.883625'),"+
            "(16,9,'Parque La Loma ,'','21.4888419','-104.8944705'),"+
            "(17,9,'La Alameda ,'','21.5097163','-104.9017046'),"+
            "(18,10,'Estadio Arena Cora ,'','21.4923501','-104.8029556'),"+
            "(19,10,'Palacio de Gobierno ,'','21.5081358','-104.891283'),"+
            "(20,9,'Plaza Bicentenario ,'','21.5081358','-104.891283'),"+
            "(21,8,'Plaza Forum ,'','21.4913098','-104.8666708'),"+
            "(22,10,'Central de Autobuses de Tepic ,'','21.4986792','-104.8867183'),"+
            "(23,5,'Banco Santander Catedral ,'','21.5118992','-104.8915184'),"+
            "(24,5,'Banco BBVA Bancomer ,'','21.5105152','-104.8925196'),"+
            "(25,5,'Banco Banamex ,'','21.5099322','-104.8943637'),"+
            "(26,5,'Banco Banorte ,'','21.512839','-104.8928428'),"+
            "(27,5,'Banco HSBC ,'','21.5124048','-104.8930735'),"+
            "(28,5,'Scotiabank ,'','21.5109467','-104.892335'),"+
            "(29,7,'Liverpool ,'','21.5102987','-104.8921414'),"+
            "(30,7,'Oxxo ,'','21.5114953','-104.8927524'),"+
            "(31,7,'Salinas & Rocha ,'','21.5114217','-104.8927966'),"+
            "(32,7,'Modatelas ,'','21.5111415','-104.893177'),"+
            "(33,7,'Coppel Canada México ,'','21.5108047','-104.8926759'),"+
            "(34,6,'Farmacias Benavides ,'','21.5108646','-104.8920871'),"+
            "(35,6,'Farmacias El Fénix ,'','21.5109383','-104.8919626'),"+
            "(36,6,'Farmacias Sufacen ,'','21.5097953','-104.8936898'),"+
            "(37,2,'Tower Pizzas ,'','21.5099182','-104.8922729'),"+
            "(38,2,'KFC ,'','21.5119189','-104.8935664'),"+
            "(39,2,'Fresh Salads ,'','21.511517','-104.8918196'),"+
            "(40,2,'Casa Tigre ,'','21.5108488','-104.8915351'),"+
            "(41,,'Sanitarios,'','21.51254','-104.893064')";





    //--------------------------------Delete Table Query
    public static final String SQL_DELETE_ENTRIES = " DROP TABLE IF EXIST " + TABLE_NAME;
    //--------------------------------Create Table Query
    public static final String CREATE_TABLE = " create table "
            + TABLE_NAME + " ( "
            + COLUMN_NAME_ID
            + " integer primary key, "
            + COLUMN_NAME_ID_CATEGORIA
            + " integer, "
            + COLUMN_NAME_POI
            + " text, "
            + COLUMN_NAME_SHORT_DESCRIPCION
            + " text, "
            + COLUMN_NAME_LONG_DESCRIPCION
            + " text, "
            + COLUMN_NAME_LAT
            + " text, "
            + COLUMN_NAME_LON
            + " text, "
            + COLUMN_NAME_HORARIO
            + " text, "
            + COLUMN_NAME_CALF
            + " text, "
            + COLUMN_NAME_COSTO
            + " text, "
            + COLUMN_NAME_COSTOAPROX
            + " text )";


    public db_pois(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(db_pois.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public ArrayList<String> obtenerPois(int cat){
        ArrayList<String> lista=new ArrayList<>();
        SQLiteDatabase db= this.getReadableDatabase();
        db.beginTransaction();
        try {
            String selectQuery = "SELECT * FROM "+TABLE_NAME+" WHERE id_categoria="+cat;
            Cursor cursor = db.rawQuery(selectQuery, null);
            if (cursor.getCount() > 0) {
                while (cursor.moveToNext()) {
                    String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME_POI));
                    int id = cursor.getInt(cursor.getColumnIndex(COLUMN_NAME_ID));
                    lista.add(name);
                }
            }
            db.setTransactionSuccessful();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            db.endTransaction();
            db.close();
        }
        return lista;
    }
    public ArrayList<String> obtenerPoisId(int cat){
        ArrayList<String> lista=new ArrayList<>();
        SQLiteDatabase db= this.getReadableDatabase();
        db.beginTransaction();
        try {
            String selectQuery = "SELECT * FROM "+TABLE_NAME+" WHERE id_categoria="+cat;
            Cursor cursor = db.rawQuery(selectQuery, null);
            if (cursor.getCount() > 0) {
                while (cursor.moveToNext()) {
                    String id = Integer.toString(cursor.getInt(cursor.getColumnIndex(COLUMN_NAME_ID)));
                    lista.add(id);
                }
            }
            db.setTransactionSuccessful();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            db.endTransaction();
            db.close();
        }
        return lista;
    }

}
