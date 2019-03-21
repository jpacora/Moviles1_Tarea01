package com.example.jpacora.practicacalificada;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProcesaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_procesa);

        List<String> Procesados = new ArrayList<String>();

        Intent intent = getIntent();
        String _Texto = intent.getStringExtra(MainActivity.EXTRA_MESSAGE+"_Texto");
        String[] _Splited = _Texto.split("\\s+");
        String _Mensaje = "Nro Palabras: "+_Splited.length;
        Random r = new Random();
        _Mensaje = _Mensaje+ "\nPalabras repetidas:\n";
        for(int i = 0; i <= _Splited.length - 1; i++) {
            System.out.println("The string is: " + _Splited[i]);
            int Ocurrencias = 0;
            //Chequeamos si ya lo procesamos en el contador de OCurrencias
            if(!Procesados.contains(_Splited[i])) {
                for(int v = 0; v <= _Splited.length - 1; v++) {
                    if(_Splited[i].equals(_Splited[v])) {
                        Ocurrencias++;
                    }
                }
                //Procesado
                _Mensaje = _Mensaje+"La palabra "+_Splited[i]+" se repite "+Ocurrencias +" veces ";
                Procesados.add(_Splited[i]);
            }
            //Chequeamos si es palindroma
            if(isPalindrome(_Splited[i])) {
                _Mensaje = _Mensaje+" y también es palindroma";
            };
            _Mensaje = _Mensaje+"\n";
        }
        _Mensaje = _Mensaje+"\n Texto Ingresado:"+_Texto;
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(_Mensaje);

        ViewGroup layout = (ViewGroup)findViewById(R.id.activity_Procesa);
        layout.addView(textView);
    }

    public static boolean isPalindrome(String s) {
        int N = s.length();
        for (int i = 0; i < N/2; i++)
            if (s.charAt(i) != s.charAt(N-1-i))
                return false;
        return true;
    }
}
