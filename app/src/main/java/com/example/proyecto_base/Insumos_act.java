package com.example.proyecto_base;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import Objetos.Insumos;

public class Insumos_act extends AppCompatActivity {

    private Spinner insumos;
    private TextView result;
    private RatingBar calificar;
    private Insumos in = new Insumos(); // instancia del obj insumos.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insumos);

        insumos = findViewById(R.id.spnInsumos);
        result = findViewById(R.id.result);
        calificar = findViewById(R.id.rt);

        // Recibir los valores.
        Bundle bun = getIntent().getExtras();  // Obtengo los extras (valores)
        String[] listado = bun.getStringArray("insumos"); // Los guardo en un arreglo según su referencia.

        ArrayAdapter adaptInsumos = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listado);
        insumos.setAdapter(adaptInsumos);

    }

    // Método para calcular Insumos  ..

    public void Calcular(View view)
    {
        String opcion = insumos.getSelectedItem().toString(); // Obtengo la selección del spinner.
        int resultado = 0;

        for(int i = 0;  i < opcion.length(); i++) {
            if (opcion.equals(in.getInsumos()[i])) // pregunto por el insumo.
            {
                resultado = in.anadirAdicional(in.getPrecios()[i], 2500); // obtengo el valor + adicional
                calificar.setRating(i); // califica por posición
                break;
            }
        }

        result.setText("La opción es: " + opcion + " \nEl precio es: " + resultado);

    }

}







