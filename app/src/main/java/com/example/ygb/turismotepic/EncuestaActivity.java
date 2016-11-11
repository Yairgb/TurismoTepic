package com.example.ygb.turismotepic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ygb.turismotepic.rc.rc_encuesta;
import com.example.ygb.turismotepic.rc.rc_usuarios;

import org.w3c.dom.Text;

public class EncuestaActivity extends Activity {

    RatingBar rb1,rb2,rb3,rb4,rb5;
    ImageButton btnEnviar;
    rc_encuesta rcEncuesta;
    SharedPreferences user,loginPreferences;
    float r1,r2,r3,r4,r5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta);
        rb1 = (RatingBar) findViewById(R.id.ratingb1);
        rb2 = (RatingBar) findViewById(R.id.ratingb2);
        rb3 = (RatingBar) findViewById(R.id.ratingb3);
        rb4 = (RatingBar) findViewById(R.id.ratingb4);
        rb5 = (RatingBar) findViewById(R.id.ratingb5);
        btnEnviar = (ImageButton)findViewById(R.id.btnEnviar);
        user=getSharedPreferences("user", MODE_PRIVATE);
        loginPreferences = getSharedPreferences("loginPrefs",MODE_PRIVATE);
        btnEnviar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                    /*rcUsuarios = new rc_usuarios(getApplicationContext());
                    rcUsuarios.open();
                    rcUsuarios.insertarUsuarios(Usuario,Pass,Sexo,Motivo,Acompañantes,Origen,Edad);
                    rcUsuarios.close();
                    Toast.makeText(getApplicationContext(), "Registro Realizado", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(v.getContext(), Login.class);
                    startActivity(intent);
                    finish();*/
                int idUser=user.getInt("idUser",0);
                System.out.println("id: "+idUser);
                System.out.println("nombre: "+loginPreferences.getString("username",""));

                r1=rb1.getRating();
                r2=rb2.getRating();
                r3=rb3.getRating();
                r4=rb4.getRating();
                r5=rb5.getRating();
                rcEncuesta= new rc_encuesta(getApplicationContext());
                rcEncuesta.open();
                rcEncuesta.enviarEncuesta(idUser,r1,r2,r3,r4,r5);

            }
        });

    }


}