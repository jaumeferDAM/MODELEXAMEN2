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
    EditText etNombre = (EditText) findViewById(R.id.editTextNombre);
    EditText etSexe = (EditText) findViewById(R.id.editTextSexe);
    EditText etAltura = (EditText) findViewById(R.id.editTextAltura);
    EditText etPes = (EditText) findViewById(R.id.editTextPes);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       etEdad = (EditText) findViewById(R.id.editTextEdad);

        Button guardarButton = (Button) findViewById(R.id.btnGuardar);
        Button exerciciButton = (Button) findViewById(R.id.btnExercici);
        Button tasaButton = (Button) findViewById(R.id.btnTasa);

        guardarButton.setOnClickListener(this);
    }
@Override
    public void onClick(View v) {
    if(v.equals(R.id.btnGuardar)) {

        try
        {
            OutputStreamWriter fout =
                    new OutputStreamWriter(
                            openFileOutput("prueba_int.txt", Context.MODE_PRIVATE));

            fout.write(etNombre.getText().toString());
            fout.close();

            Log.i("Ficheros", "Fichero creado!");
        }
        catch (Exception ex)
        {
            Log.e("Ficheros", "Error al escribir fichero a memoria interna");
        }
    } else if (v.equals(R.id.btnExercici)) {
        Intent i = new Intent(this,xecici.class);
        i.putExtra("nom",leerFichero());
}


}

    public String leerFichero() {
        String texto = "";
        {
            BufferedReader fin =
                    null;
            try {
                fin = new BufferedReader(
                        new InputStreamReader(
                                openFileInput("prueba_int.txt")));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


            try {
                texto = fin.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Log.i("Ficheros", "Fichero leido!");
            Log.i("Ficheros", "Texto: " + texto);

        }

        return texto;
    }



    }


