package com.example.jpacora.tarea01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE="com.example.jpacora.tarea01";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Procesar(View view) {
        Intent intent = new Intent(this, ProcesaActivity.class);
        EditText editTextNumero = (EditText)findViewById(R.id.Numero);
        EditText editTextTexto = (EditText)findViewById(R.id.Texto);
        intent.putExtra(EXTRA_MESSAGE+"_Numero", editTextNumero.getText().toString());
        intent.putExtra(EXTRA_MESSAGE+"_Texto", editTextTexto.getText().toString());
        startActivity(intent);
    }
}
