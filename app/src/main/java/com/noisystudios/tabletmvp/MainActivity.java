package com.noisystudios.tabletmvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSpinners();
    }

    public void setSpinners() {
        Spinner keySpinner = (Spinner) findViewById(R.id.key);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> keyAdapter = ArrayAdapter.createFromResource(this,
                R.array.keys_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        keyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        keySpinner.setAdapter(keyAdapter);

        Spinner tempoSpinner = (Spinner) findViewById(R.id.tempo);
        ArrayAdapter<CharSequence> tempoAdapter = ArrayAdapter.createFromResource(this,
                R.array.tempos_array, android.R.layout.simple_spinner_item);
        tempoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tempoSpinner.setAdapter(tempoAdapter);
    }
}