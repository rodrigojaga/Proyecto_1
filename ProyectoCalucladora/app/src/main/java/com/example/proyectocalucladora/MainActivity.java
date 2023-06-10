package com.example.proyectocalucladora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    TextView tvSalida;
    TextView tvResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btReset,btnBorrar;
        Button bt0,bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,btnpunto;
        Button sum,res,mul,div,raiz;
        tvSalida = findViewById(R.id.salidaNumeros);
        tvResultado = findViewById(R.id.salidaResultado);
        btReset = findViewById(R.id.btn_borrar_todo);
        btReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvSalida.setText("");
                tvResultado.setText("");
            }
        });
        bt0 = findViewById(R.id.btn_0);
        bt0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boton(bt0);
            }
        });
        bt1 = findViewById(R.id.btn_1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boton(bt1);
            }
        });


    }
    public void boton(Button btn){

        String ant = tvSalida.getText().toString();
        String num = btn.getText().toString();
        String concat = ant+num;
        tvSalida.setText(concat);
    }














}