package com.example.ygb.turismotepic;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ygb.turismotepic.rc.rc_pois;

import org.w3c.dom.Text;

public class DetalladoActivity extends Activity {
    private rc_pois poisdb;
    Cursor datos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detallado);

        ImageView iv1 = (ImageView)findViewById(R.id.iv1);
        Intent intent=getIntent();
        String idPlace=intent.getStringExtra("id");
        TextView nombre = (TextView)findViewById(R.id.lugar);
        TextView posicion= (TextView)findViewById(R.id.posicion);
        TextView horario =(TextView)findViewById(R.id.horario);
        TextView costo=(TextView)findViewById(R.id.costo);
        TextView descripcion=(TextView)findViewById(R.id.descripcion);
        //Obtención de los datos
        poisdb= new rc_pois(getApplicationContext());
        poisdb.open();
        datos=poisdb.getDatos(idPlace);
        datos.moveToFirst();
        nombre.setText(datos.getString(2));
        posicion.setText("("+datos.getString(5)+" "+datos.getString(6)+")");
        horario.setText("Horario: "+datos.getString(7));
        costo.setText("Costo: "+datos.getString(9));
        descripcion.setText(datos.getString(4));
        String image=datos.getString(11);
        System.out.println(image);
        int id = getResources().getIdentifier(image, "drawable", getPackageName());
        Drawable drawable = getResources().getDrawable(id);
        iv1.setImageDrawable(drawable);

    }
}
