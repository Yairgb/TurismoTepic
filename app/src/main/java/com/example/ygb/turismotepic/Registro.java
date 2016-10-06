package com.example.ygb.turismotepic;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;

import com.example.ygb.turismotepic.db.db_acompanying;
import com.example.ygb.turismotepic.db.db_motivo;
import com.example.ygb.turismotepic.db.db_origen;

import java.util.ArrayList;

public class Registro extends Activity {
    private  RadioButton rbHombre, rbMujer;
    private RadioGroup rdgGrupo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        db_motivo dataMotivo = new db_motivo(this);
        db_origen dataOrigen = new db_origen(this);
        db_acompanying dataAcompañante = new db_acompanying(this);

        rbHombre=(RadioButton)findViewById(R.id.rbHombre);
        rbMujer=(RadioButton)findViewById(R.id.rbMujer);
        rdgGrupo = (RadioGroup)findViewById(R.id.RGB);
        ArrayList<String> listaOrigenes= dataOrigen.obtenerOrigenes();
        ArrayList<String> listaMotivos= dataMotivo.obtenerMotivo();
        ArrayList<String> listaAcompa= dataAcompañante.obtenerAcompañantes();
        Spinner spinnerMotivo = (Spinner) findViewById(R.id.spMotivo);
        Spinner spinnerCompañeros = (Spinner) findViewById(R.id.spCompaneros);
        Spinner spinnerOrigen = (Spinner) findViewById(R.id.spOrigen);


        Button btnGuardar = (Button) findViewById(R.id.btnGuardarReg);
        Button btnCancelar = (Button) findViewById(R.id.btnCancelarReg);

        ArrayAdapter<String> adaptadorMotivo = new ArrayAdapter<String>(this, R.layout.sp_motivo,R.id.tvTexto_spMotivo,listaMotivos);
        spinnerMotivo.setAdapter(adaptadorMotivo);

        ArrayAdapter<String> adaptadorAcomp = new ArrayAdapter<String>(this, R.layout.sp_acompa,R.id.tvTexto_spAcompa,listaAcompa);
        spinnerCompañeros.setAdapter(adaptadorAcomp);

        ArrayAdapter<String> adaptadorOrigenes = new ArrayAdapter<String>(this, R.layout.sp_origen,R.id.tvTexto_spOrigen,listaOrigenes);
        spinnerOrigen.setAdapter(adaptadorOrigenes);


        btnGuardar.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent(v.getContext(), Login.class);
            startActivity(intent);
            finish();
        }
    });


        btnCancelar.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent(v.getContext(), Login.class);
            startActivity(intent);
            finish();
        }
    });
    }


}
