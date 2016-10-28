package com.example.ygb.turismotepic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import com.example.ygb.turismotepic.rc.rc_init;

public class PoiMenu extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poi_menu);

        /*rc_init mINit = new rc_init(getApplicationContext());
        mINit.open(); // abre db
        mINit.addRegistros (lista);
        mINit.close();*/
        ImageButton bhotel = (ImageButton) findViewById(R.id.hoteles);
        ImageButton brestaurant = (ImageButton) findViewById(R.id.restaurantes);
        ImageButton bmonumento = (ImageButton) findViewById(R.id.monumentos);
        ImageButton bmuseos = (ImageButton) findViewById(R.id.museo);
        ImageButton bbanco = (ImageButton) findViewById(R.id.bancos);
        ImageButton bfarmacia = (ImageButton) findViewById(R.id.farmacias);
        ImageButton btienda = (ImageButton) findViewById(R.id.tiendas);
        ImageButton bplaza = (ImageButton) findViewById(R.id.plazas);
        ImageButton bparque= (ImageButton) findViewById(R.id.parques);
        ImageButton botro = (ImageButton) findViewById(R.id.otros);

        bhotel.setOnClickListener(this);
        brestaurant.setOnClickListener(this);
        bmonumento.setOnClickListener(this);
        bmuseos.setOnClickListener(this);
        bbanco.setOnClickListener(this);
        bfarmacia.setOnClickListener(this);
        btienda.setOnClickListener(this);
        bplaza.setOnClickListener(this);
        bparque.setOnClickListener(this);
        botro.setOnClickListener(this);



    }
        @Override
        public void onClick(View v){
            int idCat;
            switch(v.getId()){
                case R.id.hoteles:
                    idCat =1;
                    break;
                case R.id.restaurantes:
                    idCat =2;
                    break;
                case R.id.monumentos:
                    idCat =3;
                    break;
                case R.id.museo:
                    idCat =4;
                    break;
                case R.id.bancos:
                    idCat =5;
                    break;
                case R.id.farmacias:
                    idCat =6;
                    break;
                case R.id.tiendas:
                    idCat =7;
                    break;
                case R.id.plazas:
                    idCat =8;
                    break;
                case R.id.parques:
                    idCat =9;
                    break;
                case R.id.otros:
                    idCat =10;
                    break;
                default:
                    idCat=0;
            }
            Intent intent = new Intent(getApplicationContext(),CategoriaActivity.class);
            intent.putExtra("idCat",idCat);
            startActivity(intent);

        }

}

