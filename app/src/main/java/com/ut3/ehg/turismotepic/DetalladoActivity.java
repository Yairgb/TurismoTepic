package com.ut3.ehg.turismotepic;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.ut3.ehg.turismotepic.rc.rc_pois;

import static android.content.Context.MODE_PRIVATE;


public class DetalladoActivity extends Fragment {
    private rc_pois poisdb;
    Cursor datos;
    ViewGroup root;
    Context cntx;
    SharedPreferences poi;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final AppBarLayout appBarLayout;
        root = (ViewGroup) inflater.inflate(R.layout.activity_detallado, null);
        cntx = container.getContext();
        poi=this.getActivity().getSharedPreferences("poi",MODE_PRIVATE);


        ImageView iv1 = (ImageView)root.findViewById(R.id.iv1);
        String idPlace=poi.getString("idPoi","");
        TextView nombre = (TextView)root.findViewById(R.id.lugar);
        TextView posicion= (TextView)root.findViewById(R.id.posicion);
        TextView horario =(TextView)root.findViewById(R.id.horario);
        TextView costo=(TextView)root.findViewById(R.id.costo);
        TextView descripcion=(TextView)root.findViewById(R.id.descripcion);
        //Obtención de los datos
        poisdb= new rc_pois(root.getContext());
        poisdb.open();
        datos=poisdb.getDatos(idPlace);
        datos.moveToFirst();
        nombre.setText(datos.getString(2));
        posicion.setText("("+datos.getString(5)+" "+datos.getString(6)+")");
        horario.setText("Horario: "+datos.getString(7));
        costo.setText("Costo: "+datos.getString(9));
        descripcion.setText(datos.getString(4));


        //Cosas de la imagen
        String image=datos.getString(11);
        if(!image.equals("")) {
            int id = getResources().getIdentifier(image, "drawable", getActivity().getPackageName());
            Drawable drawable = getResources().getDrawable(id);
            iv1.setImageDrawable(drawable);
        }

        return root;
    }

}
