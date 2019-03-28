package musicPlayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MusicPlayerController {
	public File file;
	
	public void play(File file)
	{
		try
		{
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(file));
			clip.start();
			
//			Thread.sleep(clip.getMicrosecondLength()/1000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
