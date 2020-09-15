package com.noisystudios.tabletmvp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.noisystudios.tabletmvp.midinotes.MidiEvent;
import com.noisystudios.tabletmvp.midinotes.Notes;

import org.billthefarmer.mididriver.MidiDriver;

public class MainActivity extends AppCompatActivity implements MidiDriver.OnMidiStartListener, View.OnTouchListener {

    Button bt;
    MidiDriver midiDriver = new MidiDriver();

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSpinners();
    }

    @SuppressLint("ClickableViewAccessibility")
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

        midiDriver.setOnMidiStartListener(this);
        midiDriver.start();

        bt = (Button) findViewById(R.id.button);
        bt.setOnTouchListener(this);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.d(this.getClass().getName(), "Motion event: " + event);

        if (v.getId() == R.id.button) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    Log.d(this.getClass().getName(), "MotionEvent.ACTION_DOWN");
                    playNote();
                    break;
                case MotionEvent.ACTION_UP:
                    Log.d(this.getClass().getName(), "MotionEvent.ACTION_UP");
                    stopNote();
            }
        }

        return false;
    }

    @Override
    public void onMidiStart() {
        MidiEvent event = new MidiEvent();
        event.setEventMessage((byte)0xc0);
        event.setEventPitch((byte)0x00);

        midiDriver.write(event.getEvent());
    }

    private void playNote() {
        MidiEvent event = new MidiEvent();
        event.setNoteOn();
        event.setEventChannel(1); // out of 1-16
        event.setEventPitch(Notes.C, 0, 0);
        event.setEventVelocity((byte)0x40);

        midiDriver.write(event.getEvent());
    }

    private void stopNote() {
        MidiEvent event = new MidiEvent();
        event.setNoteOff();
        event.setEventChannel(1); // out of 1-16
        event.setEventPitch(Notes.C, 0, 0);
        event.setEventVelocity((byte)0x00);

        midiDriver.write(event.getEvent());
    }
}



// TODO remove linting suppression and create a custom view https://stackoverflow.com/questions/47107105/android-button-has-setontouchlistener-called-on-it-but-does-not-override-perform