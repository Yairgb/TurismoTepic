package com.example.ygb.turismotepic;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetalladoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detallado);


        Intent intent=getIntent();
        String idPlace=intent.getStringExtra("id");

        TextView tvId = (TextView)findViewById(R.id.idPlace);
        tvId.setText(idPlace);

    }
}
