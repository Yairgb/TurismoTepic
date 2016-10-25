package com.example.ygb.turismotepic;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ygb.turismotepic.rc.rc_usuarios;

public class Login extends Activity {

    private rc_usuarios rcUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView tx = (TextView)findViewById(R.id.tvTitleLogin);
        Typeface roboto = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Bold.ttf");
        //Typeface beba = Typeface.createFromAsset(getAssets(), "fonts/BebasKai-Regular.otf");
        Typeface maven = Typeface.createFromAsset(getAssets(), "fonts/MavenPro-Regular.ttf");




        final EditText etUsuarioL = (EditText) findViewById(R.id.etUsuarioLog);
        final EditText etPassL = (EditText) findViewById(R.id.etPassLog);
        final TextView tvLogin = (TextView) findViewById(R.id.tvTitleLogin);
        final CheckBox cbR = (CheckBox) findViewById(R.id.cbRemenberme);


        tx.setTypeface(roboto);
        etUsuarioL.setTypeface(maven);
        etPassL.setTypeface(maven);
        cbR.setTypeface(maven);
        tvLogin.setTypeface(roboto);


        TextView btnRegistro =(TextView) findViewById(R.id.tvRegistro);
        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (etUsuarioL.getText().length()==0){
                    etUsuarioL.setError("Correo Vacio");
                }
                if (etPassL.getText().length()==0){
                    etPassL.setError("Password vacio");
                }
                String id =null;
                rcUsuarios = new rc_usuarios(getApplicationContext());
                rcUsuarios.open();
                id = rcUsuarios.checarUsuario(etUsuarioL.getText().toString(),etPassL.getText().toString());
                rcUsuarios.close();
                if(id == null){
                    Toast.makeText(Login.this, "El usuario o password es incorrecto", Toast.LENGTH_SHORT).show();
                }else{

                    Intent intent = new Intent(v.getContext(), MainActivity.class);
                    startActivity(intent);
                    Login.this.finish();
                }
            }
            
        });

        btnRegistro.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), Registro.class);
                startActivity(intent);
            }
        });


    }
}
