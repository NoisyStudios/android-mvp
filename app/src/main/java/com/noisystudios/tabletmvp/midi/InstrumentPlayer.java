package com.noisystudios.tabletmvp.midi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import static com.noisystudios.tabletmvp.midi.MidiConstants.PERCUSSION_CHANNEL;
import static com.noisystudios.tabletmvp.midi.MidiConstants.PERCUSSION_OFFSET;
import static com.noisystudios.tabletmvp.midi.MidiConstants.PERCUSSION_PITCHES;
import static com.noisystudios.tabletmvp.midi.MidiConstants.PROGRAM_CHANGE;
import static com.noisystudios.tabletmvp.midi.MidiConstants.TOTAL_CHANNELS;

// this event generates midi events from instrument events
public class InstrumentPlayer {

    private static Map<Instrument, Integer> instrumentChannels = new HashMap<Instrument, Integer>() {{
        for (Instrument instrument : Instrument.values()) {
            if (instrument.getMidiCode() >= PERCUSSION_OFFSET) {
                put(instrument, PERCUSSION_CHANNEL);
            }
        }
    }};

    private static Queue<Instrument> lastInstrumentUse = new LinkedList<>();

    public List<MidiEvent> getMidiEvents(InstrumentEvent event) {
        // TODO basic logic for getting an optional channel switch event and then on/off event
        List<MidiEvent> events = new ArrayList<>();

        if (PERCUSSION_PITCHES.containsKey(event.getInstrument())) {
            events.add(event.toMidiEvent(PERCUSSION_CHANNEL));
        }

        if (!instrumentChannels.containsKey(event.getInstrument())) {
            if (instrumentChannels.size() < TOTAL_CHANNELS) {

            }

            events.add(new MidiEvent().withEventMessage(PROGRAM_CHANGE).withEventPitch(freeChannel));
        }

        events.add(event.toMidiEvent(instrumentChannels.get(event.getInstrument())));

        return null;
    }

}
