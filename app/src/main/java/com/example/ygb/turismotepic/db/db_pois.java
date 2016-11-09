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
    public static final String COLUMN_NAME_FOTO = "foto";


    //--------------------------------Insert Table Query
    public static final String SQL_INSERT_ENTRIES = "INSERT INTO `pois` (`id_poi`, `id_categoria`, `nombre`,`descripcion_larga`,`latitud`, `longitud`, `horario`, `calificacion`, `costo`, `foto`) " +
            "VALUES " +
            "(01,3,'Catedral ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.5105914','-104.8906753','8 a.m. a 8p.m.','1','499','f01_01'),"+
            "(02,1,'Hotel Fray Junípero Serra ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.5090809','-104.8919096','9 a.m. a 8p.m.','3','176','f02_01'),"+
            "(03,4,'Casa Museo de Juan Escutia ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.5095973','-104.8907031','10 a.m. a 8p.m.','3','368',''),"+
            "(04,4,'Casa Mueso de Amado Nervo ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.5105914','-104.8906753','11 a.m. a 8p.m.','5','133','f04_01'),"+
            "(05,3,'Pérgola (Plaza principal) ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.512184','-104.892335','12 a.m. a 8p.m.','3.5','273',''),"+
            "(06,3,'Fuente principal (Plaza principal) ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.512084','-104.892021','13 a.m. a 8p.m.','4','462','f06_01'),"+
            "(07,3,'Fuente de delfín (Plaza principal) ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.512256','-104.892497','14 a.m. a 8p.m.','5','51','f07_01'),"+
            "(08,4,'Escuela Superior de Música ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.5086155','-104.8904644','15 a.m. a 8p.m.','1.5','265','f08_01'),"+
            "(09,4,'Casa Fenelón ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.5095587','-104.8906283','16 a.m. a 8p.m.','2.5','271','f09_01'),"+
            "(10,3,'Busto de Carranza (Plaza antigua) ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.5095587','-104.8906283','17 a.m. a 8p.m.','3.5','260',''),"+
            "(11,4,'Museo Regional INAH','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.5099214','-104.892416','18 a.m. a 8p.m.','1.5','337','f11_01'),"+
            "(12,10,'Oficinas regionales del INAH ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.5086601','-104.8910246','19 a.m. a 8p.m.','2.5','221','f12_01'),"+
            "(13,10,'Centro Estatal de Culturas Populares e Indígenas (CECUPI) ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.5101323','-104.8923121','20 a.m. a 8p.m.','3','319','f13_01'),"+
            "(14,10,'Centro de Arte Contemporáneo del Bicentenario Emilia Ortíz ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.5107362','-104.8920432','21 a.m. a 8p.m.','4','281','f14_01'),"+
            "(15,9,'El cerro de la Cruz ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.533983','-104.883625','22 a.m. a 8p.m.','5','486',''),"+
            "(16,9,'Parque La Loma ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.4888419','-104.8944705','23 a.m. a 8p.m.','3','152',''),"+
            "(17,9,'La Alameda ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.5097163','-104.9017046','24 a.m. a 8p.m.','5','35',''),"+
            "(18,10,'Estadio Arena Cora ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.4923501','-104.8029556','25 a.m. a 8p.m.','4','145',''),"+
            "(19,10,'CICESE','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.484178','-104.848563','26 a.m. a 8p.m.','1','445',''),"+
            "(20,9,'Plaza Bicentenario ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.5081358','-104.891283','27 a.m. a 8p.m.','3','405',''),"+
            "(21,8,'Plaza Forum ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.4913098','-104.8666708','28 a.m. a 8p.m.','3','222',''),"+
            "(22,10,'Central de Autobuses de Tepic ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.4986792','-104.8867183','29 a.m. a 8p.m.','5','94',''),"+
            "(23,5,'Banco Santander Catedral ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.5118992','-104.8915184','30 a.m. a 8p.m.','3.5','360',''),"+
            "(24,5,'Banco BBVA Bancomer ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.5105152','-104.8925196','31 a.m. a 8p.m.','4','430',''),"+
            "(25,5,'Banco Banamex ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.5099322','-104.8943637','32 a.m. a 8p.m.','5','32',''),"+
            "(26,5,'Banco Banorte ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.512839','-104.8928428','33 a.m. a 8p.m.','1.5','337',''),"+
            "(27,5,'Banco HSBC ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.5124048','-104.8930735','34 a.m. a 8p.m.','2.5','434',''),"+
            "(28,5,'Scotiabank ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.5109467','-104.892335','35 a.m. a 8p.m.','3.5','178',''),"+
            "(29,7,'Liverpool ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.5102987','-104.8921414','36 a.m. a 8p.m.','1.5','451',''),"+
            "(30,7,'Oxxo ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.5114953','-104.8927524','37 a.m. a 8p.m.','2.5','210',''),"+
            "(31,7,'Salinas & Rocha ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.5114217','-104.8927966','38 a.m. a 8p.m.','3','12',''),"+
            "(32,7,'Modatelas ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.5111415','-104.893177','39 a.m. a 8p.m.','4','71',''),"+
            "(33,7,'Coppel Canada México ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.5108047','-104.8926759','40 a.m. a 8p.m.','5','71',''),"+
            "(34,6,'Farmacias Benavides ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.5108646','-104.8920871','41 a.m. a 8p.m.','3','455',''),"+
            "(35,6,'Farmacias El Fénix ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.5109383','-104.8919626','42 a.m. a 8p.m.','5','360',''),"+
            "(36,6,'Farmacias Sufacen ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.5097953','-104.8936898','43 a.m. a 8p.m.','4','430',''),"+
            "(37,2,'Tower Pizzas ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.5099182','-104.8922729','44 a.m. a 8p.m.','1','175',''),"+
            "(38,2,'KFC ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.5119189','-104.8935664','45 a.m. a 8p.m.','3','232',''),"+
            "(39,2,'Fresh Salads ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.511517','-104.8918196','46 a.m. a 8p.m.','3','229',''),"+
            "(40,2,'Casa Tigre ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.5108488','-104.8915351','47 a.m. a 8p.m.','5','298',''),"+
            "(41,10,'Sanitarios','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.51254','-104.893064','48 a.m. a 8p.m.','3.5','249',''),"+
            "(42,10,'Palacio de Gobierno ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.5081358','-104.891283','26 a.m. a 8p.m.','1','445','')";








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
            + " text, "
            + COLUMN_NAME_FOTO
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
