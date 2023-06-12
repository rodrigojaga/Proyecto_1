package com.example.proyectocalucladora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class parteDatos extends AppCompatActivity {

    public static final int decimalPlaces = 10;
    public static final int decimalPlaces2 = 15;
    TextView ed,sd;
    Spinner spinner1, spinnerD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_parte_datos);
        spinner1 = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.opciones, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);

        spinnerD = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.opciones, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerD.setAdapter(adapter);

        ed = findViewById(R.id.entradaData);
        sd = findViewById(R.id.salidaData);
        Button limpiar,deletear;
        Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9;
        Button bpunto, biguasl;
        limpiar = findViewById(R.id.clear);
        limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regresarData();
            }
        });

        deletear = findViewById(R.id.borrarTodo);
        deletear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed.setText(""); sd.setText("");
            }
        });

        b0 = findViewById(R.id.button0);
        numeroData(b0);
        b1 = findViewById(R.id.button1);
        numeroData(b1);
        b2 = findViewById(R.id.button2);
        numeroData(b2);
        b3 = findViewById(R.id.button3);
        numeroData(b3);
        b4 = findViewById(R.id.button4);
        numeroData(b4);
        b5 = findViewById(R.id.button5);
        numeroData(b5);
        b6 = findViewById(R.id.button6);
        numeroData(b6);
        b7 = findViewById(R.id.button7);
        numeroData(b7);
        b8 = findViewById(R.id.button8);
        numeroData(b8);
        b9 = findViewById(R.id.button9);
        numeroData(b9);
        bpunto = findViewById(R.id.buttonPunto);
        numeroData(bpunto);
        biguasl = findViewById(R.id.buttonIguaal);
        biguasl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botonIgual();
            }
        });


    }

    private void botonData(Button btn){

        String ant = ed.getText().toString();
        String num = btn.getText().toString();
        String concat = ant+num;
        ed.setText(concat);
    }

    private void numeroData(Button btn){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botonData(btn);
            }
        });
    }

    private void botonIgual(){
        //DecimalFormat dc = new DecimalFormat("#." + "0".repeat(decimalPlaces));
        //DecimalFormat df = new DecimalFormat("#." + "0".repeat(decimalPlaces));
        String auxS  = spinner1.getSelectedItem().toString();
        String auxS2 = spinnerD.getSelectedItem().toString();
        String ax = ed.getText().toString();
        switch (auxS){
            case "Megabytes":
                switch (auxS2){
                    case "Megabytes":
                        sd.setText(ed.getText().toString());
                        break;

                    case "Gigabytes":
                        double a = Double.parseDouble(ax);
                        double result = a/1024;
                        String b = String.valueOf(result);
                        sd.setText(b);
                        break;

                    case "Terabytes":
                        double a1 = Double.parseDouble(ax);
                        double result1 = a1/1048576;
                        String b1 = String.valueOf(result1);
                        sd.setText(b1);
                }
                break;

            case "Gigabytes":
                switch (auxS2){
                    case "Megabytes":
                        double a = Double.parseDouble(ax);
                        double result = a*1024;
                        String b = String.valueOf(result);
                        sd.setText(b);
                        break;

                    case "Gigabytes":
                        sd.setText(ed.getText().toString());
                        break;

                    case "Terabytes":
                        double a1 = Double.parseDouble(ax);
                        double result1 = a1/1024;
                        String b1 = String.valueOf(result1);
                        sd.setText(b1);
                        break;
                }
                break;

            case "Terabytes":
                switch (auxS2){
                    case "Megabytes":
                        double a = Double.parseDouble(ax);
                        double result = a*1048576;
                        String b = String.valueOf(result);
                        sd.setText(b);
                        break;

                    case "Gigabytes":
                        double a1 = Double.parseDouble(ax);
                        double result1 = a1*1024;
                        String b1 = String.valueOf(result1);
                        sd.setText(b1);
                        break;

                    case "Terabytes":
                        sd.setText(ed.getText().toString());
                        break;
                }
                break;
        }
    }


    public void commonCalculator(View view){
        Intent siguiente = new Intent(this, MainActivity.class);
        startActivity(siguiente);
    }

    private void regresarData(){
        String texto = (ed.getText().toString());
        int lenght = texto.length();
        if(lenght>0){
            String a = texto.subSequence(0,lenght-1).toString();
            ed.setText(a);
        }
    }

}
