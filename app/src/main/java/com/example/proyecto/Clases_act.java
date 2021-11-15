package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto.database.AdminSQLiteOpenHelper;

public class Clases_act extends AppCompatActivity {

    private EditText code, movie,cash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clases);

        code = findViewById(R.id.code);
        movie = findViewById(R.id.movie);
        cash = findViewById(R.id.cash);

    }

    public void Anadirpeli(View view)
    {
        //obtener date base
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"CineFlix", null,1 );
        SQLiteDatabase db = admin.getWritableDatabase();//sobreescritura de base de datos

        String codigo = code.getText().toString();
        String pelicula = movie.getText().toString();
        String valor = cash.getText().toString();

        if(!codigo.isEmpty() && !pelicula.isEmpty() && !valor.isEmpty())
        {

            ContentValues cont = new ContentValues();
            cont.put("codigo",codigo);
            cont.put("pelicula", pelicula);
            cont.put("valor", valor);

            db.insert("peliculas",null, cont);
            db.close();
            Clean();
            Toast.makeText(getBaseContext(), "Has agregado una pelicula", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(getBaseContext(), "Tiene campos vacios, porfavor rellenar", Toast.LENGTH_SHORT).show();
        }

    }

    public void Mostrarpeli(View view)
    {
        //obtener date base
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"CineFlix", null,1 );
        SQLiteDatabase db = admin.getWritableDatabase();//sobreescritura de base de datos

        String codigo = code.getText().toString();

        if (!codigo.isEmpty())
        {
            Cursor file = db.rawQuery( "SELECT pelicula, valor FROM peliculas WHERE codigo="+codigo, null);

            if (file.moveToFirst()){

                //mostrar campos
                movie.setText(file.getString(0));
                cash.setText(file.getString(1));

            } else{
                Toast.makeText(getBaseContext(), "No hay nada asociado al codigo", Toast.LENGTH_SHORT).show();
            }

        }else {
            Toast.makeText(getBaseContext(), "El codigo esta vacio", Toast.LENGTH_SHORT).show();
        }

    }

    public void Eliminarpeli(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"CineFlix", null,1 );
        SQLiteDatabase db = admin.getWritableDatabase();//sobreescritura de base de datos

        String codigo = code.getText().toString();

        if (!codigo.isEmpty())
        {
            db.delete("peliculas", "codigo="+codigo, null);
            db.close();
            Clean();
            Toast.makeText(getBaseContext(), "Has eliminado la pelicula", Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(getBaseContext(), "El codigo NO PUEDE venir vacio", Toast.LENGTH_SHORT).show();
        }

    }

    public void Actualizarpeli(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"CineFlix", null,1 );
        SQLiteDatabase db = admin.getWritableDatabase();//sobreescritura de base de datos

        String codigo = code.getText().toString();
        String pelicula = movie.getText().toString();
        String valor = cash.getText().toString();

        if(!codigo.isEmpty() && !pelicula.isEmpty() && !valor.isEmpty())
        {

            ContentValues cont = new ContentValues();
            cont.put("pelicula", pelicula);
            cont.put("valor", valor);

            db.update("peliculas", cont, "codigo="+codigo, null);
            db.close();
            Clean();
            Toast.makeText(getBaseContext(), "Has Actualizado", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(getBaseContext(), "Tiene campos vacios, porfavor rellenar", Toast.LENGTH_SHORT).show();
        }

    }

    public void Clean()
    {
        code.setText("");
        movie.setText("");
        cash.setText("");
    }
}