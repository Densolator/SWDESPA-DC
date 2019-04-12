package main.musicPlayer;

import main.SongBuilder;

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
	public File file, temp = new File("/Users/luismartinez/Downloads/src/main/musicPlayer/Sample 3.wav");
	public ArrayList<SongBuilder> songBuilders;
	public ArrayList<File> songs;
	public int songIndex = 0;
	public ByteArrayOutputStream bytearrayos = new ByteArrayOutputStream();
	public byte[] bytearray;

	public boolean playing = false, opened = false, playlist = true;
	Clip clip;

	public MusicPlayerController() {
		this.songBuilders = new ArrayList<>();
		this.songs = new ArrayList<>();
		try {
			clip = AudioSystem.getClip();
 		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}
	public void play()
	{
		if (playlist) {
			System.out.println(songs.size());
			System.out.println(songs.get(0).canRead());
			file = songs.get(songIndex);
			songIndex++;

			if (songIndex > songs.size())
				songIndex = 0;
		}
		try
		{
			if (!playing) {
				if (!opened)
					clip.open(AudioSystem.getAudioInputStream(file));

				clip.start();
				playing = true;
				opened = true;

				clip.addLineListener(event -> {
					if (event.getType() == LineEvent.Type.CLOSE) {
						opened = false;
						playing = false;
						clip.stop();

						if (playlist) {
							this.play();
						}
					}
				});
			} else {
				clip.stop();
				playing = false;
			}
//			Thread.sleep(clip.getMicrosecondLength()/1000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void playPlaylist() {
		playlist = true;
		for (int i = 0; i < songBuilders.size(); i++) {
			try {
				if (i < songBuilders.size() - 1) {
					this.songs.add(songBuilders.get(i).buildAsSong(false));
				} else {
					this.songs.add(songBuilders.get(i).buildAsSong(true));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		this.play();
	}
	
	public void loadPlaylist(ResultSet songs) throws SQLException, IOException
	{
		while(songs.next())
		{
			Blob blob = songs.getBlob("song");
			InputStream in = blob.getBinaryStream();
			File temp = File.createTempFile("temp", ".wav");
			System.out.println(temp.getAbsolutePath());
			OutputStream out =new FileOutputStream(temp);
//			AudioSystem.write(in, AudioFileFormat.Type.WAVE, temp);
			byte[] buff = new byte[1024];
			int len = 0;
			while((len = in.read(buff)) != -1)
			{
				bytearrayos.write(buff, 0, (int)blob.length());
			}
			bytearray = bytearrayos.toByteArray();
			
//			ByteArrayInputStream bis = new ByteArrayInputStream(bytearray);
//	        AudioFormat audioFormat = new AudioFormat(44100, 16, 2, true, false);
//	        AudioInputStream ais = new AudioInputStream(bis, audioFormat, 2048);
			this.songs.add(temp);
		}
	}
}
