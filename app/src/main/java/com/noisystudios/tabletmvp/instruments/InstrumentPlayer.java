package com.noisystudios.tabletmvp.instruments;

import com.noisystudios.tabletmvp.midinotes.MidiEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.noisystudios.tabletmvp.instruments.Instrument.PERCUSSION_OFFSET;

// this event generates midi events from instrument events
public class InstrumentPlayer {

    private static Map<Instrument, Integer> instrumentChannels = new HashMap<Instrument, Integer>() {{
        put(Instrument.PIANO, Instrument.PIANO.getMidiCode());
    }};
    private static Map<Instrument, Integer> percussionPitches = new HashMap<Instrument, Integer>() {{
        put(Instrument.SIDE_STICK, Instrument.SIDE_STICK.getMidiCode() - PERCUSSION_OFFSET);

        // TODO make this iterative over all percussive instruments
    }};

    public List<MidiEvent> getMidiEvents(InstrumentEvent event) {
        // TODO basic logic for getting an optional channel switch event and then on/off event

        return null;
    }

}
