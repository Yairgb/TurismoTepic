package com.example.ygb.turismotepic;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ygb.turismotepic.db.db_pois;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CategoriaActivity extends Activity implements ListView.OnItemClickListener{
    ArrayList<String> listaPoisid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);
        db_pois pois= new db_pois(this);
        Intent intent=getIntent();
        int idCat=intent.getIntExtra("idCat",0);

        ListView lvPois = (ListView)findViewById(R.id.lvPois);
        ImageView imageCat = (ImageView)findViewById(R.id.ivCategoria);
        TextView tvCat=(TextView)findViewById(R.id.tvCategoria);
        ArrayList<String> listaPois=pois.obtenerPois(idCat);
        listaPoisid=pois.obtenerPoisId(idCat);
        TextView acompa = (TextView) findViewById(R.id.tvTexto_spPoi);
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this,R.layout.sp_poi,R.id.tvTexto_spPoi,listaPois);
        lvPois.setOnItemClickListener(this);
        lvPois.setAdapter(adp);


        switch(idCat){
            case 1:
                imageCat.setImageResource(R.drawable.hoteles);
                tvCat.setText("Hoteles");
                break;
            case 2:
                imageCat.setImageResource(R.drawable.restaurantes);
                tvCat.setText("Restaurantes");
                break;
            case 3:
                imageCat.setImageResource(R.drawable.monumentos);
                tvCat.setText("Monumentos");
                break;
            case 4:
                imageCat.setImageResource(R.drawable.museos);
                tvCat.setText("Museos");
                break;
            case 5:
                imageCat.setImageResource(R.drawable.bancos);
                tvCat.setText("Bancos");
                break;
            case 6:
                imageCat.setImageResource(R.drawable.farmacias);
                tvCat.setText("Farmacias");
                break;
            case 7:
                imageCat.setImageResource(R.drawable.tiendas);
                tvCat.setText("Tiendas");
                break;
            case 8:
                imageCat.setImageResource(R.drawable.mall);
                tvCat.setText("Plazas comerciales");
                break;
            case 9:
                imageCat.setImageResource(R.drawable.parques);
                tvCat.setText("Parques");
                break;
            case 10:
                imageCat.setImageResource(R.drawable.otros);
                tvCat.setText("Otros lugares");
                break;
        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        System.out.println("Pressed" + position);
        String idPoi = listaPoisid.get(position);
        Intent intent = new Intent(getApplicationContext(),DetalladoActivity.class);
        intent.putExtra("id",idPoi);
        startActivity(intent);
    }
}
