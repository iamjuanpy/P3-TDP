package logica;
import java.lang.Runnable;
import java.io.File;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class MusicaRunnable implements Runnable {
	private Sequencer seq;
	
	public MusicaRunnable(File musica, boolean loop) {
		
		try {
			seq = MidiSystem.getSequencer(); // Get the default Sequencer
            if (seq == null) {
                System.err.println("Sequencer device not supported");
                return;
            } 
            seq.open(); // Open device
            
            // Create sequence, the File must contain MIDI file data.
            Sequence sequence = MidiSystem.getSequence(musica);
            if (loop) {
            	seq.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
            }
            
            
            // Tratar de enviar un mensaje a todos los canales para reducir su volumen a [vol]
            int vol = 30;
            for (Track t : sequence.getTracks()) {
            	for (int i = 0; i < 15; i++) {
            		t.add(new MidiEvent( new ShortMessage(ShortMessage.CONTROL_CHANGE, i, 7, vol), 0));
            		
            	}
            	
            	
            }
            seq.setSequence(sequence); // load it into sequencer
		} catch (MidiUnavailableException | InvalidMidiDataException | IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		seq.start();  // start the playback
	}
}