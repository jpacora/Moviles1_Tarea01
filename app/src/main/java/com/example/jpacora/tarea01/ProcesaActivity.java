package com.example.jpacora.tarea01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;

public class ProcesaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_procesa);

        Intent intent = getIntent();
        String _Texto = intent.getStringExtra(MainActivity.EXTRA_MESSAGE+"_Texto");
        Integer _Numero = Integer.parseInt(intent.getStringExtra(MainActivity.EXTRA_MESSAGE+"_Numero"));
        String[] _Splited = _Texto.split("\\s+");
        String _Mensaje = "Nro Palabras: "+_Splited.length;
        Random r = new Random();
        if(_Numero >_Splited.length) {
            _Mensaje = _Mensaje+"\n El numero ingresado es mayor a la cantidad de palabras";
        } else {
            _Mensaje = _Mensaje+"\n Al Azar("+_Numero+"): ";

            for(int l=1; l<=_Numero; l++) {
                int i = r.nextInt((_Splited.length-1) - 0 + 1) + 0;
                _Mensaje = _Mensaje+_Splited[i]+" ";
            }
        }
        _Mensaje = _Mensaje+"\n Texto Ingresado:"+_Texto;
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(_Mensaje);

        ViewGroup layout = (ViewGroup)findViewById(R.id.activity_Procesa);
        layout.addView(textView);
    }
}
