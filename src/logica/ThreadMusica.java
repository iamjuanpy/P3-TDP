package logica;

import java.net.URL;
import java.io.IOException;
                                                        
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

public class ThreadMusica extends Thread {
	private Sequencer seq;
	
	public ThreadMusica(URL musica, boolean loop) {
		cargarMusica(musica, loop);
	}
	
	public void detenerMusica() {
		MidiChannel[] channels;
		try {
			channels = MidiSystem.getSynthesizer().getChannels();
			
			for( int c = 0; c < channels.length; c++ ) {
				channels[c].allNotesOff();
            }
		} catch (MidiUnavailableException ex) {
			ex.printStackTrace();
		}
	}
	
	public void cargarMusica(URL musica, boolean loop) {		
		try {
			seq = MidiSystem.getSequencer(true); // Get the default Sequencer
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
            
            seq.setSequence(sequence); // load it into sequencer
            setVolume(0.4);
            seq.start();
            
            
		} catch (MidiUnavailableException | InvalidMidiDataException | IOException e) {
			e.printStackTrace();
		}
	}
	
	
public void setVolume(double vol) {
		
	    System.out.println("Midi volume change request: " + vol);

	            MidiChannel[] channels;
				try {
					channels = MidiSystem.getSynthesizer().getChannels();
					
					for( int c = 0; c < channels.length; c++ ) {
		                if(channels[c] != null)   channels[c].controlChange( 7, (int)( vol*127) );
		            }
				} catch (MidiUnavailableException ex) {
					ex.printStackTrace();
				}

	            
	        }
	

}