package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize component
        initComponent();

        // Load spinner data
        loadData(new String[]{"Data 1", "Data 2", "Data 3"});

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // Show a message on the screen
                Toast toast = Toast.makeText(getApplicationContext(), "Spinner 1 value "+spinner1.getSelectedItem().toString(), Toast.LENGTH_SHORT);
                toast.show();
                // Show message on logcat
                Log.i("TEST",spinner1.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void initComponent() {
        spinner1 = (Spinner) findViewById(R.id.spinner1);
    }

    private void loadData(String[] doses) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, doses);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
    }
}