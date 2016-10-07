package com.example.ygb.turismotepic;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ygb.turismotepic.db.db_acompanying;
import com.example.ygb.turismotepic.db.db_motivo;
import com.example.ygb.turismotepic.db.db_origen;


import java.util.ArrayList;

public abstract class Registro extends Activity implements NumberPicker.OnValueChangeListener {
    private RadioButton rbHombre, rbMujer;
    private RadioGroup rdgGrupo;
    private ImageButton btnPickEdad;
    EditText edad, usuario, contraseña, motivo, acompañantes, origen, sexo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        db_motivo dataMotivo = new db_motivo(this);
        db_origen dataOrigen = new db_origen(this);
        db_acompanying dataAcompañante = new db_acompanying(this);

        edad = (EditText) findViewById(R.id.etEdad);
        btnPickEdad = (ImageButton) findViewById(R.id.ibtnEdad);

        rbHombre = (RadioButton) findViewById(R.id.rbHombre);
        rbMujer = (RadioButton) findViewById(R.id.rbMujer);
        rdgGrupo = (RadioGroup) findViewById(R.id.RGB);
        ArrayList<String> listaOrigenes = dataOrigen.obtenerOrigenes();
        ArrayList<String> listaMotivos = dataMotivo.obtenerMotivo();
        ArrayList<String> listaAcompa = dataAcompañante.obtenerAcompañantes();
        Spinner spinnerMotivo = (Spinner) findViewById(R.id.spMotivo);
        Spinner spinnerCompañeros = (Spinner) findViewById(R.id.spCompaneros);
        Spinner spinnerOrigen = (Spinner) findViewById(R.id.spOrigen);


        Button btnGuardar = (Button) findViewById(R.id.btnGuardarReg);
        Button btnCancelar = (Button) findViewById(R.id.btnCancelarReg);

        ArrayAdapter<String> adaptadorMotivo = new ArrayAdapter<String>(this, R.layout.sp_motivo, R.id.tvTexto_spMotivo, listaMotivos);
        spinnerMotivo.setAdapter(adaptadorMotivo);

        ArrayAdapter<String> adaptadorAcomp = new ArrayAdapter<String>(this, R.layout.sp_acompa, R.id.tvTexto_spAcompa, listaAcompa);
        spinnerCompañeros.setAdapter(adaptadorAcomp);

        ArrayAdapter<String> adaptadorOrigenes = new ArrayAdapter<String>(this, R.layout.sp_origen, R.id.tvTexto_spOrigen, listaOrigenes);
        spinnerOrigen.setAdapter(adaptadorOrigenes);


        btnPickEdad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPickerDialog();
            }
        });

        rdgGrupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // find which radio button is selected
                if (checkedId == R.id.rbHombre) {
                    Toast.makeText(getApplicationContext(), "choice: Hombre", Toast.LENGTH_SHORT).show();
                    rbMujer.setChecked(false);
                } else if (checkedId == R.id.rbMujer) {
                    Toast.makeText(getApplicationContext(), "choice: Mujer", Toast.LENGTH_SHORT).show();
                    rbHombre.setChecked(false);
                }
            }
        });


        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });


        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });

    }

        public void numberPickerDialog(){
            NumberPicker npEdad = new NumberPicker(this);
            npEdad.setMaxValue(100);
            npEdad.setMinValue(12);
            NumberPicker.OnValueChangeListener miValor = new NumberPicker.OnValueChangeListener(){
                @Override
                public void onValueChange(NumberPicker picker, int oldVal, int newVal){
                    edad.setText(""+newVal);
                }
            };
            npEdad.setOnValueChangedListener(miValor);
            AlertDialog.Builder Dialogo = new AlertDialog.Builder(this).setView(npEdad);
            Dialogo.setTitle("Edad").setIcon(R.drawable.ic_menu_manage);

            Dialogo.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            Dialogo.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
                Dialogo.show();
        }

}
