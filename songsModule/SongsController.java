package songsModule;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import musicPlayer.*;

public class SongsController {
	public MusicPlayerController mpController = new MusicPlayerController();
	
	public void play(String songname)
	{
		try {
			mpController.play(songname);
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
