package com.noisystudios.tabletmvp.instruments;

// This is a POJO which might get some complex population code
public class InstrumentEvent {

    private Instrument instrument;
    private int pitch;
    private int velocity;
    private boolean turnOn;

    public Instrument getInstrument() {
        return instrument;
    }
    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public int getPitch() {
        return pitch;
    }
    public void setPitch(int pitch) {
        this.pitch = pitch;
    }

    public int getVelocity() {
        return velocity;
    }
    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public boolean isTurnOn() {
        return turnOn;
    }
    public void setTurnOn(boolean turnOn) {
        this.turnOn = turnOn;
    }

}
