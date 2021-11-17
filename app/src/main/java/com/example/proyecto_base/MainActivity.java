package com.example.proyecto_base;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import Objetos.Administrador;
import Objetos.Insumos;

public class MainActivity extends AppCompatActivity {

    private EditText user, pass;
    private TextView msj;
    private ProgressBar barra;
    private Button btn;
    private Administrador adm = new Administrador(); // instancia del Obj Administrador

    // Ciclo de vida
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = (EditText) findViewById(R.id.etuser);
        pass = (EditText) findViewById(R.id.etpass);
        msj = (TextView) findViewById(R.id.msj);
        barra = (ProgressBar) findViewById(R.id.pb);
        btn = (Button) findViewById(R.id.btn);

        msj.setVisibility(View.INVISIBLE); // hace invisible o visible un elemento.
        barra.setVisibility(View.INVISIBLE); // hago invisible la barra.

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Aquí corremos nuestra tarea.
                new Task().execute();
            }
        });
    }


    // Mi tarea asíncrona.

    class Task extends AsyncTask<String, Void, String> {
        // Es la configuración inicial de mi tarea asríncrona.
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            barra.setVisibility(View.VISIBLE); // hago visible la barra.
        }

        // Es quién se encarga de llevar el proceso en segundo plano
        @Override
        protected String doInBackground(String... strings) {

            try {
                for (int i = 0; i <= 10; i++) {
                    Thread.sleep(500); // dormimos un proceso por un lapso de 25000milis
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        // Es donde termina mi tarea asíncrona.
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            barra.setVisibility(View.INVISIBLE);

            // Variables del Objeto
            String userObj = adm.getUser().toString().trim();
            String pasObj = adm.getPass().toString().trim();

            // Variables EditText de la interfaz
            String usuario = user.getText().toString().trim();
            String contrasena = pass.getText().toString().trim();

            switch (usuario) {
                case "Maximiliano":
                    if (usuario.equals(userObj) && contrasena.equals(pasObj)) {
                        // inicio sesión ... explícito ..
                        Intent i = new Intent(getBaseContext(), Home_act.class);
                        startActivity(i); // inicia el act ...
                    }
                    break;
                case "":
                    if (usuario.equals("") && contrasena.equals("")) {
                        // Campos Vacíos
                        msj.setVisibility(View.VISIBLE);
                        msj.setText("Campos Vacíos porfavor intente nuevamente");
                    }
                    break;
                default:
                    if (!usuario.equals(userObj) && !contrasena.equals(pasObj)) {
                        // Campos Incorrectos ...
                        msj.setVisibility(View.VISIBLE);
                        msj.setText("Campos Incorrectos porfavor intente nuevamente");
                    }
                    break;
            }


        }
    }


    public void Info(View view) {
        // Intent Explícito ...
        Intent i = new Intent(this, Info_act.class);
        startActivity(i);
    }


    public void Facebook(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW); // Intent Implícito que abre un sitio.
        i.setData(Uri.parse("https://www.facebook.com/")); // Paso la dirección web.
        startActivity(i);  // inicio el activity
    }

    public void Youtube(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW); // Intent Implícito que abre un sitio.
        i.setData(Uri.parse("https://www.youtube.com/")); // Paso la dirección web.
        startActivity(i);  // inicio el activity
    }

    public void Twitter(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW); // Intent Implícito que abre un sitio.
        i.setData(Uri.parse("https://www.twitter.com/")); // Paso la dirección web.
        startActivity(i);  // inicio el activity
    }


    public void CloseApp(View view)
    {
        finish(); // cieras el act.
    }
}