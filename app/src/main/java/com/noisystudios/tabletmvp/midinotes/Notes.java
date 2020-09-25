package com.noisystudios.tabletmvp.midinotes;

public enum Notes {
    A(-3),
    B(-1),
    C(0),
    D(2),
    E(4),
    F(5),
    G(7);

    private static final int SEMITONES_PER_OCTAVE = 12;
    private static final int MIDDLE_C = 0x3c;

    private int halfstepOffsetFromC;
    Notes(int offset) {
        this.halfstepOffsetFromC = offset;
    }
    int getHalfstepOffsetFromC() {
        return halfstepOffsetFromC;
    }

    public static int getPitch(Notes note, int octavesUpFromMiddleC, int halfstepsUp) {
        return MIDDLE_C + note.getHalfstepOffsetFromC() + SEMITONES_PER_OCTAVE * octavesUpFromMiddleC + halfstepsUp;
    }
}
