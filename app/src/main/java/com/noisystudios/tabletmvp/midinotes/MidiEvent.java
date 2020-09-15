package com.noisystudios.tabletmvp.midinotes;

public class MidiEvent {

    private static final int SEMITONES_PER_OCTAVE = 12;
    private static final int MIDDLE_C = 0x3c;


    private byte[] event = new byte[3];

    public void setEventMessage(byte message) {
        event[0] = message;
    }
    public void setEventPitch(final byte pitch) {
        event[1] = pitch;
    }
    public void setEventVelocity(final byte velocity) {
        event[2] = velocity;
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

    public void setEventPitch(final Notes note, final int octave, final int halfsteps) {
        byte pitch = (byte)(MIDDLE_C + note.getHalfstepOffset() + octave*SEMITONES_PER_OCTAVE + halfsteps);
        event[1] = pitch;
    }

    public byte[] getEvent() {
        return event;
    }

}
