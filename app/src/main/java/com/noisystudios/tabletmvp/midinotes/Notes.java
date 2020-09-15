package com.noisystudios.tabletmvp.midinotes;

public enum Notes {
    A(-3),
    B(-1),
    C(0),
    D(2),
    E(4),
    F(5),
    G(7);

    private int halfstepOffset;
    Notes(int offset) {
        this.halfstepOffset = offset;
    }
    int getHalfstepOffset() {
        return halfstepOffset;
    }
}
