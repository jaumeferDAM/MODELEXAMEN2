package com.example.jaume.modelexamen2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by Jaume on 12/12/2016.
 */

public class xecici extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
public void onCreate(Bundle savedInstanceState) {
    onCreate(savedInstanceState);
    setContentView(R.layout.exercici);

    Spinner spinner = (Spinner) findViewById(R.id.spinner1);
    spinner.setOnItemSelectedListener(this);
}



    @Override
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        parent.getItemAtPosition(pos);
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }



}
