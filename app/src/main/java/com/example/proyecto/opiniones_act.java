package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyecto.database.AdminSQLiteOpenHelper;

public class opiniones_act extends AppCompatActivity {
    private EditText code,opi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opiniones);

        code = findViewById(R.id.code2);
        opi = findViewById(R.id.Opi);

    }

    public void AnadirOpi(View view)
    {
        //obtener date base
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"CineFlix", null,1 );
        SQLiteDatabase db = admin.getWritableDatabase();//sobreescritura de base de datos

        String codigo = code.getText().toString();
        String opinion = opi.getText().toString();


        if(!codigo.isEmpty() && !opinion.isEmpty())
        {

            ContentValues cont = new ContentValues();
            cont.put("codigo",codigo);
            cont.put("opi", opinion);


            db.insert("opinion",null, cont);
            db.close();
            Clean();
            Toast.makeText(getBaseContext(), "Has agregado una opinion", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(getBaseContext(), "Tiene campos vacios, porfavor rellenar", Toast.LENGTH_SHORT).show();
        }

    }
    public void MostrarOpi(View view)
    {
        //obtener date base
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"CineFlix", null,1 );
        SQLiteDatabase db = admin.getWritableDatabase();//sobreescritura de base de datos

        String codigo = code.getText().toString();

        if (!codigo.isEmpty())
        {
            Cursor file = db.rawQuery( "SELECT opi FROM opinion WHERE codigo="+codigo, null);

            if (file.moveToFirst()){

                //mostrar campos
                opi.setText(file.getString(0));


            } else{
                Toast.makeText(getBaseContext(), "No hay nada asociado al codigo", Toast.LENGTH_SHORT).show();
            }

        }else {
            Toast.makeText(getBaseContext(), "El codigo esta vacio", Toast.LENGTH_SHORT).show();
        }

    }
    public void EliminarOpi(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"CineFlix", null,1 );
        SQLiteDatabase db = admin.getWritableDatabase();//sobreescritura de base de datos

        String codigo = code.getText().toString();

        if (!codigo.isEmpty())
        {
            db.delete("opinion", "codigo="+codigo, null);
            db.close();
            Clean();
            Toast.makeText(getBaseContext(), "Has eliminado el comentario", Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(getBaseContext(), "El codigo NO PUEDE venir vacio", Toast.LENGTH_SHORT).show();
        }

    }
    public void Clean()
    {
        code.setText("");
        opi.setText("");
    }
}