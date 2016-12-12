package com.example.jaume.modelexamen2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etEdad;
    EditText etNombre;
    EditText etSexe;
    EditText etAltura;
    EditText etPes;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       etEdad = (EditText) findViewById(R.id.editTextEdad);
        etAltura = (EditText) findViewById(R.id.editTextAltura);
        etNombre  = (EditText) findViewById(R.id.editTextNombre);
        etPes = (EditText) findViewById(R.id.editTextPes);
        etSexe = (EditText) findViewById(R.id.editTextSexe);
        Button guardarButton = (Button) findViewById(R.id.btnGuardar);
        Button exerciciButton = (Button) findViewById(R.id.btnExercici);
        Button tasaButton = (Button) findViewById(R.id.btnTasa);

        guardarButton.setOnClickListener(this);
        exerciciButton.setOnClickListener(this);
        tasaButton.setOnClickListener(this);

        settearTextos();
    }


@Override
    public void onClick(View v) {
    switch(v.getId()){

        case R.id.btnGuardar:
            try {
                OutputStreamWriter fout = new OutputStreamWriter(openFileOutput("prueba_int.txt", Context.MODE_PRIVATE));

                fout.write(etNombre.getText().toString());
                fout.write(etEdad.getText().toString());
                fout.write(etAltura.getText().toString());
                fout.write(etPes.getText().toString());
                fout.write(etSexe.getText().toString());
                fout.close();

                Log.i("Ficheros", "Fichero creado!");
            }
            catch (Exception ex) {
                Log.e("Ficheros", "Error al escribir fichero a memoria interna");
            }
            break;
        case R.id.btnExercici:
            Intent i = new Intent(this,xecici.class);
            i.putExtra("nom",etNombre.getText().toString());
            startActivity(i);
            break;

        case R.id.btnTasa:
            Intent intent = new Intent(this,tasaActivity.class);
            intent.putExtra("dades",etNombre.getText().toString());
            startActivity(intent);
            break;
    }


}

    public String leerFichero() {
        String texto = "";
        String todo = "";

        {
            BufferedReader fin =
                    null;
            try {
                fin = new BufferedReader(
                        new InputStreamReader(
                                openFileInput("prueba_int.txt")));

                String linea = fin.readLine();

                while (linea != null) {
                    todo = todo + linea + "\n";
                    linea = fin.readLine();
                }


                    fin.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

            Log.i("Ficheros", "Fichero leido!");
            Log.i("Ficheros", "Texto: " + texto);

        }

        return todo;
    }
    public void settearTextos() {
        etNombre.setText("");

    }

    }


