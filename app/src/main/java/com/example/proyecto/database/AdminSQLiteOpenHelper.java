package com.example.proyecto.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    // Constructor para la iniciacion de base de datos
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // es donde creo mis tablas y campos (modelo relacional)
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE peliculas ( codigo int primary key, pelicula text, valor int)");
        db.execSQL("CREATE TABLE opinion ( codigo int primary key, opi text)");

    }

    // se ocupa para los cambios esquemales en la base de datos
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { }
}
