package main;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;

public class MenuPanel extends JPanel{
	JButton songs, playlist, profile;
	Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);

	public MenuPanel() {
		setPreferredSize(new Dimension(300,900));
		this.setLayout(new GridLayout(3,1,5,5));
		initialize();
		setBorder(blackBorder);
	}
	
	public void initialize()
	{
		profile = new JButton("Profile");
		songs = new JButton("Songs");
		playlist = new JButton("Playlist");
		add(profile);
		add(songs);
		add(playlist);
	}
	
	public JButton getProfileButton()
	{
		return profile;
	}
	
	public JButton getSongsButton()
	{
		return songs;
	}
	
	public JButton getPlaylistButton()
	{
		return playlist;
	}
}
