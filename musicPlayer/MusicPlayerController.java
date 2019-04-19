package musicPlayer;
import main.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.sound.sampled.*;

public class MusicPlayerController {
//	public File file, temp = new File("C:\\Users\\Rafael\\eclipse-workspace\\SWDESPA-DC2\\src\\musicPlayer\\Sample 3.wav"), temp2 = new File("C:\\Users\\Rafael\\eclipse-workspace\\SWDESPA-DC2\\src\\musicPlayer\\Sample 2.wav");
	public File file = new File("placeholder.wav");

	public ArrayList<File> songs;
	public int songIndex = 0;
	public ByteArrayOutputStream bytearrayos = new ByteArrayOutputStream();
	public byte[] bytearray;
	private DBConnector dbcon = new DBConnector();
	public String nowplaying;
	
	public boolean playing = false, opened = false, playlist = true;
	Clip clip;

	public MusicPlayerController() {
		this.songs = new ArrayList<>();
		try {
			clip = AudioSystem.getClip();
 		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		
		
	}
	public void play(String songname) throws LineUnavailableException, IOException, UnsupportedAudioFileException, InterruptedException
	{
		nowplaying = songname;
		loadSong(nowplaying);
		
//		clip.open(AudioSystem.getAudioInputStream(songs.get(i)));
		clip.open(AudioSystem.getAudioInputStream(file));
		clip.start();
//		AudioInputStream ais = AudioSystem.getAudioInputStream(songs.get(i));
//		AudioFormat format = ais.getFormat();
//		long duration = ais.getFrameLength();
//		long durationInSeconds = (long) ((duration+0.0) / format.getFrameRate());
//		System.out.println(durationInSeconds);
		Thread.sleep(5000);
		clip.close();
	}
	
	public void loadSong(String songname)
	{
		nowplaying = songname;
		try {
			ResultSet songsList = dbcon.getSongsWithName(nowplaying);
			FileOutputStream fos = new FileOutputStream(file);
			while(songsList.next())
			{
				InputStream is = songsList.getBinaryStream("song");
				byte[] buffer = new byte[1024];
                while (is.read(buffer) > 0) {
                    fos.write(buffer);
                }
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
