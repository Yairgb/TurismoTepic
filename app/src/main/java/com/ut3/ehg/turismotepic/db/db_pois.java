package com.ut3.ehg.turismotepic.db;

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
            "(01,3,'Catedral ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.512026','-104.891528','7:00 a 21:00 hrs','0','Entrada libre','f01_01'),"+
            "(02,1,'Hotel Fray Junípero Serra ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.511643','-104.89183','10:00-14:00 hrs, 16:00-19:00hrs','0','Variable','f02_01'),"+
            "(03,4,'Casa Museo de Juan Escutia ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.510455','-104.890799','10:00-14:00 hrs, 16:00-19:00hrs','0','Entrada libre','f03_01'),"+
            "(04,4,'Casa Mueso de Amado Nervo ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.512446','-104.890477','10:00-14:00 hrs, 16:00-19:00hrs','0','Entrada libre','f04_01'),"+
            "(05,3,'Pérgola (Plaza principal) ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.512184','-104.892335','Libre acceso','0','Libre acceso','f05_01'),"+
            "(06,3,'Fuente principal (Plaza principal) ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.512084','-104.892021','Libre acceso','0','Libre acceso','f06_01'),"+
            "(07,3,'Fuente de delfín (Plaza principal) ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.512256','-104.892497','Libre acceso','0','Libre acceso','f07_01'),"+
            "(08,4,'Escuela Superior de Música ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.510975','-104.890382','16:00-19:00','0','Variable','f08_01'),"+
            "(09,4,'Casa Fenelón ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.511076','-104.890595','Sin acceso','0','Sin acceso','f09_01'),"+
            "(10,3,'Busto de Carranza (Plaza antigua) ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.510718','-104.891028','Libre acceso','0','Libre acceso','f10_01'),"+
            "(11,4,'Museo Regional INAH','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.509988','-104.892426','9:00 - 18:00','0','50','f11_01'),"+
            "(12,10,'Oficinas regionales del INAH ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.510878','-104.890568','9:00 - 18:00','0','Entrada libre','f12_01'),"+
            "(13,10,'Centro Estatal de Culturas Populares e Indígenas (CECUPI) ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.510285','-104.892396','10:00-14:00 hrs, 16:00-19:00hrs','0','Entrada libre','f13_01'),"+
            "(14,10,'Centro de Arte Contemporáneo del Bicentenario Emilia Ortíz ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.510912','-104.891872','10:00-14:00 hrs, 16:00-19:00hrs','0','Entrada libre','f14_01'),"+
            "(15,9,'El cerro de la Cruz ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.533983','-104.883625','6:00-20:00 hrs','0','Entrada libre','f15_01'),"+
            "(16,9,'Parque La Loma ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.504015','-104.899448','Todo el día','0','Entrada libre','f16_01'),"+
            "(17,9,'La Alameda ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.510335','-104.900737','Todo el día','0','Entrada libre','f17_01'),"+
            "(18,10,'Estadio Arena Cora ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.492419','-104.801467','Por evento','0','Variable','f18_01'),"+
            "(19,10,'Palacio de Gobierno ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.507507','-104.893879','9:00 - 15:00 hrs','0','Entrada libre','f19_01'),"+
            "(20,9,'Plaza Bicentenario ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.507188','-104.893074','Todo el día','0','Entrada libre','f20_01'),"+
            "(21,8,'Plaza Forum ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.491959','-104.865983','11:00 - 21:00 hrs','0','Entrada libre','f21_01'),"+
            "(22,10,'Central de Autobuses de Tepic ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.498444','-104.88677','Todo el día','0','Variable','f22_01'),"+
            "(23,5,'Banco Santander Catedral ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.512399','-104.891343','8:30 - 16:00 hrs','0','Entrada libre','f23_01'),"+
            "(24,5,'Banco BBVA Bancomer ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.510618','-104.892312','8:30 - 16:00 hrs','0','Entrada libre','f24_01'),"+
            "(25,5,'Banco Banamex ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.509944','-104.892264','9:00 - 16:00 hrs','0','Entrada libre','f25_01'),"+
            "(26,5,'Banco Banorte ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.512819','-104.892119','8:30 - 16:00 hrs','0','Entrada libre','f26_01'),"+
            "(27,5,'Banco HSBC ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.512194','-104.892861','8:30 - 16:00 hrs','0','Entrada libre','f27_01'),"+
            "(28,5,'Scotiabank ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.511046','-104.892325','8:30 - 16:00 hrs','0','Entrada libre','f28_01'),"+
            "(29,7,'Liverpool ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.491712','-104.865276','11:00 - 21:00 hrs','0','Entrada libre','f29_01'),"+
            "(30,7,'Oxxo ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.511403','-104.892637','Todo el día','0','Entrada libre','f30_01'),"+
            "(31,7,'Salinas & Rocha ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.511058','-104.892761','9:00 - 21:00 hrs','0','Entrada libre','f31_01'),"+
            "(32,7,'Modatelas ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.511106','-104.892974','8:00 - 21:00 hrs','0','Entrada libre','f32_01'),"+
            "(33,7,'Coppel Canada México ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.510821','-104.892217','8:00 - 21:00 hrs','0','Entrada libre','f33_01'),"+
            "(34,6,'Farmacias Benavides ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.510982','-104.892138','8:00 - 21:00 hrs','0','Entrada libre','f34_01'),"+
            "(35,6,'Farmacias El Fénix ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.511281','-104.89175','8:00 - 21:00 hrs','0','Entrada libre','f35_01'),"+
            "(36,6,'Farmacias Sufacen ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.512074','-104.895249','8:00 - 21:00 hrs','0','Entrada libre','f36_01'),"+
            "(37,2,'Tower Pizzas ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.509889','-104.892024','11:00 - 21:00 hrs','0','Entrada libre','f37_01'),"+
            "(38,2,'KFC ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.511975','-104.892988','11:00 - 21:00 hrs','0','Entrada libre','f38_01'),"+
            "(39,2,'Fresh Salads ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.511718','-104.892119','11:00 - 21:00 hrs','0','Entrada libre','f39_01'),"+
            "(40,2,'Casa Tigre ','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.510665','-104.890114','8:00 - 13:00','0','115','f40_01'),"+
            "(41,10,'Sanitarios','En el centro de la ciudad de Tepic, precisamente frente a la plaza principal, se localiza la hermosa Catedral de Tepic, un templo católico correspondiente a la diócesis de la zona.Considerada como la Iglesia Madre preside las celebraciones litúrgicas, brinda justicia y ofrece los Sacramentos al rebaño encomendado.','21.512484','-104.893123','9:00 - 16:30 hrs','0','Entrada libre','f41_01'),"+
            "(42,10,'CICESE','Centro de Investigación Científica y de Educación Superior de Ensenada','21.484181','-104.848551','8:00 - 16:30 hrs','0','Sin acceso','f42_01')";















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
