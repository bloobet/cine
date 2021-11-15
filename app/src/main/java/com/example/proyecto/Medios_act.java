package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import objetos.Pagos;

public class Medios_act extends AppCompatActivity {

    private Spinner Pago ;
    private TextView resul4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medios);

        Pago = findViewById(R.id.SpPago);
        resul4 = findViewById(R.id.txtResult4);

        Pagos pago = new Pagos();

        String[] medios = pago.getPago();

        ArrayAdapter adaptPagos = new ArrayAdapter(this, android.R.layout.simple_list_item_1, medios);

        Pago.setAdapter(adaptPagos);
        Pago.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (Pago.getSelectedItemPosition())
                {
                    case 0 : if (Pago.getSelectedItem().toString().equals("Debito"))
                    {
                       resul4.setText(" La subcripcion por este medio es de: "+ pago.getPrecioSub()[0]);
                    }
                    break;
                    case 1 : if (Pago.getSelectedItem().toString().equals("Credito"))
                    {
                        resul4.setText(" La subcripcion por este medio es de: "+ pago.getPrecioSub()[1]);
                    }
                        break;
                    case 2 : if (Pago.getSelectedItem().toString().equals("Trasferencias"))
                    {
                        resul4.setText(" La subcripcion por este medio es de: "+ pago.getPrecioSub()[2]);
                    }
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}