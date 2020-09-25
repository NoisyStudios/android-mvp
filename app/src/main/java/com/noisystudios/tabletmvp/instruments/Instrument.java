package com.noisystudios.tabletmvp.instruments;

public enum Instrument {

    PIANO(0),
    SIDE_STICK(256 + 37);

    private int midiCode;
    Instrument(int midiCode) {
        this.midiCode = midiCode;
    }
    public int getMidiCode() {
        return midiCode;
    }

    public static int PERCUSSION_OFFSET = 256; // this needs to be hardcoded above because java is stupid

}
