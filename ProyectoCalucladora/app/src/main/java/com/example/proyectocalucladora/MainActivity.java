package com.example.proyectocalucladora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.faendir.rhino_android.AndroidContextFactory;
import com.google.android.material.button.MaterialButton;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    TextView tvSalida;
    TextView tvResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btReset,btnBorrar;
        Button bt0,bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,btnpunto;
        Button sum,res,mul,div,raiz,igual;
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
        numero(bt0);
        bt1 = findViewById(R.id.btn_1);
        numero(bt1);
        bt2 = findViewById(R.id.btn_2);
        numero(bt2);
        bt3 = findViewById(R.id.btn_3);
        numero(bt3);
        bt4 = findViewById(R.id.btn_4);
        numero(bt4);
        bt5 = findViewById(R.id.btn_5);
        numero(bt5);
        bt6 = findViewById(R.id.btn_6);
        numero(bt6);
        bt7 = findViewById(R.id.btn_7);
        numero(bt7);
        bt8 = findViewById(R.id.btn_8);
        numero(bt8);
        bt9 = findViewById(R.id.btn_9);
        numero(bt9);
        btnpunto = findViewById(R.id.btn_punto);
        numero(btnpunto);
        sum = findViewById(R.id.btn_suma);
        numero(sum);
        res = findViewById(R.id.btn_resta);
        numero(res);
        mul = findViewById(R.id.btn_multiplicacion);
        numero(mul);
        div = findViewById(R.id.btn_division);
        numero(div);
        raiz = findViewById(R.id.btn_raiz);
        numero(raiz);
        btnBorrar = findViewById(R.id.btn_borrar_ultimo);
        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regresar();
            }
        });

        igual = findViewById(R.id.btn_igual);
        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                igualSig();
            }
        });
    }
    private void boton(Button btn){

        String ant = tvSalida.getText().toString();
        String num = btn.getText().toString();
        String concat = ant+num;
        tvSalida.setText(concat);
    }

    private void numero(Button btn){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boton(btn);
            }
        });
    }

    private void regresar(){
        String texto = (tvSalida.getText().toString());
        int lenght = texto.length();
        if(lenght>0){
            String a = texto.subSequence(0,lenght-1).toString();
            tvSalida.setText(a);
        }
    }

    public void dataCalculator(View view){
        Intent siguiente = new Intent(this, parteDatos.class);
        startActivity(siguiente);
    }

    private void igualSig(){
        String expresion = tvSalida.getText().toString();
        tvResultado.setText(operacion(expresion));
    }

    private String operacion(String expresion){
        if(expresion.contains(Character.toString('^'))){
            String[] partes = expresion.split("\\^");
            double base = Double.parseDouble(partes[0]);
            double expo = Double.parseDouble(partes[1]);

            double resultado = Math.pow(base,expo);
            return String.valueOf(resultado);
        }else{
            Context rhino = Context.enter();
            rhino.setOptimizationLevel(-1);
            try{

                Scriptable scope = rhino.initStandardObjects();
                Object result = rhino.evaluateString(scope, expresion, "JavaScript", 1, null);
                return String.valueOf(result);

            }catch (Exception e){

            }
        }

        return null;
    }









}