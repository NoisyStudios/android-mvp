package com.noisystudios.tabletmvp.midi;

import java.util.HashMap;
import java.util.Map;

public class MidiEvent {

    private byte[] event = new byte[3];

    public void setEventMessage(final byte message) {
        event[0] = message;
    }
    public void setEventPitch(final byte pitch) {
        event[1] = pitch;
    }
    public void setEventVelocity(final byte velocity) {
        event[2] = velocity;
    }
    public MidiEvent withEventMessage(final byte message) {
        setEventMessage(message);
        return this;
    }
    public MidiEvent withEventPitch(final byte pitch) {
        setEventPitch(pitch);
        return this;
    }
    public MidiEvent withEventVelocity(final byte velocity) {
        setEventVelocity(velocity);
        return this;
    }

    public void setNoteOn() {
        event[0] = (byte)0x90;
    }
    public void setNoteOff() {
        event[0] = (byte)0x80;
    }
    public void setEventChannel(int channel) {
        /* channels are numbered 1-16 but 0-15 in the midi spec */
        event[0] |= (byte)(channel-1);
    }
    public MidiEvent withNoteOn() {
        setNoteOn();
        return this;
    }
    public MidiEvent withNoteOff() {
        setNoteOff();
        return this;
    }
    public MidiEvent withEventChannel(int channel) {
        setEventChannel(channel);
        return this;
    }

    public byte[] getEvent() {
        return event;
    }

}
