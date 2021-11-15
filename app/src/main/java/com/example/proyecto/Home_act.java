package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import objetos.Peliculas;

public class Home_act extends AppCompatActivity {

    private VideoView vw ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        vw = findViewById(R.id.video);

        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.video;

        Uri uri = Uri.parse(ruta);

        vw.setVideoURI(uri);

        vw.start();
        //controles

        /*MediaController media = new MediaController(this);
        vw.setMediaController(media);*/
    }

    public void Catelera(View view)
    {
        Peliculas peli = new Peliculas();
        Intent i = new Intent(this , Cartelera_act.class);

        Bundle bun = new Bundle();
        bun.putStringArray("Pelis", peli.getPeliculas());
        i.putExtras(bun);

        startActivity(i);
    }
    public void mediosDePagos(View view)
    {
        Intent i = new Intent(this , Medios_act.class);
        startActivity(i);
    }
}