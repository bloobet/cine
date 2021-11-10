package com.example.proyecto;

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
import objetos.Admin;
import objetos.Peliculas;

public class MainActivity extends AppCompatActivity {

    private EditText user, pass;
    private TextView msj;
    private Button btnI;
    private ProgressBar pbc;
    private Admin adm = new Admin();
    private Peliculas peli = new Peliculas();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.txt_user);
        pass = findViewById(R.id.txt_pass);
        msj = findViewById(R.id.text_error);
        btnI = findViewById(R.id.btn);
        pbc = findViewById(R.id.pb);

        msj.setVisibility(View.INVISIBLE);
        pbc.setVisibility(View.INVISIBLE);

        btnI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Task().execute();
            }
        });

    }
    class Task extends AsyncTask<String, Void , String>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pbc.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings) {

            try {
                for (int i = 0; i<=10; i++)
                {
                    Thread.sleep(850);
                }
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            pbc.setVisibility(View.INVISIBLE);
            String usuario = user.getText().toString().trim();
            String clave = pass.getText().toString().trim();

            String userObj = adm.getUser().trim();
            String passObj = adm.getPass().trim();

            switch (usuario)
            {
                case "Admin":
                    if (usuario.equals(userObj) && clave.equals(passObj))
                    {
                        msj.setVisibility( View.INVISIBLE);
                        Intent i = new Intent(getBaseContext() , Home_act.class);

                        Bundle bun = new Bundle();
                        bun.putStringArray("Pelis", peli.getPeliculas());
                        i.putExtras(bun);
                        startActivity(i);
                    }
                    break;

                case"":
                    if (usuario.equals("") && clave.equals(""))
                    {
                        msj.setVisibility( View.VISIBLE);
                        msj.setText("los campos estan vacios");
                    }
                    break;
                case "albert":
                    if (!usuario.equals(userObj) && clave.equals(passObj))
                {
                    msj.setVisibility( View.VISIBLE);
                    msj.setText("Credenciales incorrectas");
                }
                    break;
                case "12345":
                   if  (usuario.equals(userObj) && !clave.equals(passObj))
                {
                    msj.setVisibility( View.VISIBLE);
                    msj.setText("Credenciales incorrectas");
                }
                    break;
                default:
                    if (!usuario.equals(userObj) && !clave.equals(passObj))
                    {
                        msj.setVisibility( View.VISIBLE);
                        msj.setText("Credenciales incorrectas");
                    }
                    break;
            }
        }
    }




    public void  Facebook (View v)
    {
        Intent i = new Intent(Intent.ACTION_VIEW); //abre sitio web
        i.setData(Uri.parse("http://www.facebook.com/"));
        startActivity(i);
    }
    public void  Youtube (View v)
    {
        Intent i = new Intent(Intent.ACTION_VIEW); //abre sitio web
        i.setData(Uri.parse("http://www.youtube.com/"));
        startActivity(i);
    }
    public void  twitter (View v)
    {
        Intent i = new Intent(Intent.ACTION_VIEW); //abre sitio web
        i.setData(Uri.parse("http://www.twitter.com/"));
        startActivity(i);
    }
    public void  informacion (View v)
    {
        Intent i = new Intent(this, Info_act.class);
        startActivity(i);
    }

}