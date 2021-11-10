package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ViewFlipper;

import objetos.Peliculas;


public class Cartelera_act extends AppCompatActivity {

    private int [] image = {R.drawable.hallowen,R.drawable.venom, R.drawable.godzilla, R.drawable.fast, R.drawable.shan};
    private Spinner Peli ;
    private TextView resultado;
    private ViewFlipper vf;
    private RatingBar rating ;
    private Peliculas pe = new Peliculas();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartelera);

        Peli = findViewById(R.id.tortas_sp);
        resultado = findViewById(R.id.result);
        vf = (ViewFlipper)findViewById(R.id.slider);
        rating = findViewById(R.id.rt);

        Peliculas pelis = new Peliculas();

        Bundle bun = getIntent().getExtras();
        String [] listado = bun.getStringArray( "Pelis");


        ArrayAdapter adaptPelis = new ArrayAdapter( this, android.R.layout.simple_list_item_1, listado);


        Peli.setAdapter(adaptPelis);

        for (int i = 0; i<image.length; i++)
        {
            Flip_image(image[i]);
        }

        Peli.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (Peli.getSelectedItemPosition())
                {
                    case 0:
                        if (Peli.getSelectedItem().toString().equals("Hallowen"))
                        {
                            resultado.setText("El precio es: " + pelis.getPrecios()[0]+" mas un adicional de $500"+"\nel stock es de 400 personas.");

                        }
                        break;

                    case 1:
                        if (Peli.getSelectedItem().toString().equals("Venom 2"))
                        {
                            resultado.setText("El precio es: " + pelis.getPrecios()[1]+" mas un adicional de $500"+"\nel stock es de 400 personas.");
                        }
                        break;

                    case 2:
                        if (Peli.getSelectedItem().toString().equals("Gvsk"))
                        {
                            resultado.setText("El precio es: " + pelis.getPrecios()[2]+" mas un adicional de $500"+"\nel stock es de 400 personas.");
                        }
                        break;
                    case 3:
                        if (Peli.getSelectedItem().toString().equals("F9"))
                        {
                            resultado.setText("El precio es: " + pelis.getPrecios()[3]+" mas un adicional de $500"+"\nel stock es de 400 personas.");
                        }
                        break;
                    case 4:
                        if (Peli.getSelectedItem().toString().equals("Shang-chi"))
                        {
                            resultado.setText("El precio es: " + pelis.getPrecios()[4]+" mas un adicional de $500"+"\nel stock es de 400 personas.");
                        }
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void Calcular (View v)
    {

        String opcion = Peli.getSelectedItem().toString();
        int result = 0;
        int rasulta = 0;

        for (int i = 0; i < opcion.length(); i++)
        {
            if (opcion.equals(pe.getPeliculas()[i])) {

                result = pe.Adicional(pe.getPrecios()[i] , 500);
                rating.setRating(i);
                rasulta = pe.Disponible(pe.getStock());
                break;


            }
        }

        resultado.setText("La Película es: " + opcion +" \nEl precio final es: "+ result+"\nEl Stock es: "+rasulta);
    }

    public void Flip_image (int i)
    {
        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);
        vf.addView(view);
        vf.setFlipInterval(2800);
        vf.setAutoStart(true);

        vf.setInAnimation(this, android.R.anim.slide_in_left);
        vf.setOutAnimation(this, android.R.anim.slide_out_right);
    }
}