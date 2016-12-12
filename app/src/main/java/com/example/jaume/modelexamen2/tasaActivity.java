package com.example.jaume.modelexamen2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by ALUMNEDAM on 12/12/2016.
 */

public class tasaActivity extends AppCompatActivity  {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercici);

        TextView textView = (TextView) findViewById(R.id.textViewTasa);
        Intent i = new Intent(this,MainActivity.class);
        String nom;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                nom= null;
            } else {
                nom= extras.getString("dades");
            }
        } else {
            nom= (String) savedInstanceState.getSerializable("dades");
        }
        textView.setText(nom);
    }
}
