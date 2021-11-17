package com.example.proyecto_base;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Info_act extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
    }

    // Intent Implícito
    public void Marcado(View view)
    {
        Intent i = new Intent(Intent.ACTION_DIAL); // Acción para marcado teléfonico
        i.setData(Uri.parse("tel:"+"(2) 2558 4969\n"));
        startActivity(i);
    }

    // Intent Explícito
    public void Maps(View view)
    {
        Intent i = new Intent(this, MapsActivity.class);
        startActivity(i);
    }
}






