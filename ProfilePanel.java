import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.*;

import loginModule.LoginController;
import profileModule.ProfileController;

public class ProfilePanel extends JPanel{
	private ProfileController controller = new ProfileController();
	private JLabel label, label1, label2, label3, label4;
	private JComboBox cmbPlaylist, cmbSongs;
	private JButton btnAdd1, btnAdd2;

	JList<PlaylistItem> favList = new JList<>();
	JList<SongItem> favSongs = new JList<>();
	public ProfilePanel()
	{
		setLayout(null);
		instantiate();
	}

	public void load(int userid) {
		DefaultListModel<PlaylistItem> playlists = new DefaultListModel<>();
		HashMap<Integer, String> val = controller.fave(userid, ProfileController.Type.PLAYLIST);

		for (Map.Entry<Integer, String> entry : val.entrySet()) {
			playlists.addElement(new PlaylistItem(entry.getKey(), entry.getValue()));
		}

		favList.setModel(playlists);

		DefaultListModel<SongItem> songs = new DefaultListModel<>();
		HashMap<Integer, String> vals = controller.fave(userid, ProfileController.Type.SONG);

		for (Map.Entry<Integer, String> entry : vals.entrySet()) {
			songs.addElement(new SongItem(entry.getKey(), entry.getValue()));
		}

		favSongs.setModel(songs);
	}

	private void instantiate()
	{
				label = new JLabel("Profile");
		label.setBounds(300, 1, 200, 100);
		add(label);
		
		label1 = new JLabel("My Favorite Playlists");
		label1.setBounds(100, 60, 200, 100);
		add(label1);

		favList.setBounds(50, 125, 200, 500);
		add(favList);

		label3 = new JLabel ("Add favorite playlist: ");
		label3.setBounds(20, 25, 200, 100);
		add(label3);
		
		cmbPlaylist = new JComboBox();
		cmbPlaylist.setBounds(140, 65, 100, 25);
		add(cmbPlaylist);
		
		btnAdd1 = new JButton ("Add");
		btnAdd1.setBounds(245, 65, 70, 25);
		add(btnAdd1);
		
		//
		
		label2 = new JLabel ("My Favorite Songs");
		label2.setBounds(450, 60, 200, 100);
		add(label2);
		
		label4 = new JLabel ("Add favorite songs: ");
		label4.setBounds(345, 25, 200, 100);
		add(label4);
		
		//array of favorite songs
		favSongs.setBounds(400, 125, 200, 500);
		add(favSongs);
		
		cmbSongs = new JComboBox();
		cmbSongs.setBounds(460, 65, 100, 25);
		add(cmbSongs);
		
		btnAdd2 = new JButton ("Add");
		btnAdd2.setBounds(565, 65, 70, 25);
		add(btnAdd2);
		
	}

	class PlaylistItem {
		public int id;
		public String name;

		public PlaylistItem(int id, String name) {
			this.id = id;
			this.name = name;
		}

		@Override
		public String toString() {
			return this.name;
		}
	}

	class SongItem {
		public int id;
		public String name;

		public SongItem(int id, String name) {
			this.id = id;
			this.name = name;
		}

		@Override
		public String toString() {
			return this.name;
		}
	}
}
