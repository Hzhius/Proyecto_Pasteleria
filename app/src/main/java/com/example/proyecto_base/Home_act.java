package com.example.proyecto_base;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import Objetos.Insumos;

public class Home_act extends AppCompatActivity {

    private VideoView video;
    private Insumos in = new Insumos(); // Instancia del Obj Insumos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        video = findViewById(R.id.vw); // llamo el elemento por id.

        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.video; // Obtengo la ruta del vídeo.
        Uri uri = Uri.parse(ruta); // parsear la ruta.
        video.setVideoURI(uri); // le pasamos el vídeo al VideoView.

        video.start(); // reproduce el video al comenzar.

        // Controles para el vídeo.
        // MediaController media = new MediaController(this);
        // video.setMediaController(media);
    }







    public void Insumos(View view)
    {
        Intent i = new Intent(this, Insumos_act.class);

        // Preparar mis valores ..
        Bundle bun = new Bundle(); // necesario para intercambiar arreglos.
        bun.putStringArray("insumos", in.getInsumos()); // relleno mi bundle
        i.putExtras(bun); // le paso mi bundle al intent
        startActivity(i); // inicia el act ...

    }

    public void Clases(View view) {
        // Intent Explícito ...
        Intent i = new Intent(this, Clases_act.class);
        startActivity(i);
    }

}

