package com.example.proyecto;

import androidx.activity.result.contract.ActivityResultContracts;
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

    public void Marcar (View v)
    {
        Intent i = new Intent(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel:"+ "56971675168"));
        startActivity(i);
    }

    public void maps (View v)
    {
        Intent i = new Intent(this, MapsActivity.class);
        startActivity(i);
    }
}