package profileModule;
import java.awt.*;

import javax.swing.*;

import loginModule.LoginController;
public class ProfilePanel extends JPanel{
	private ProfileController controller = new ProfileController();
	private JLabel label, label1, label2, label3, label4;
	private JComboBox cmbPlaylist, cmbSongs;
	private JButton btnAdd1, btnAdd2;
	
	public ProfilePanel()
	{
		setLayout(null);
		instantiate();
	}
	
	private void instantiate()
	{
				label = new JLabel("Profile");
		label.setBounds(300, 1, 200, 100);
		add(label);
		
		label1 = new JLabel("My Favorite Playlists");
		label1.setBounds(100, 60, 200, 100);
		add(label1);

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
		
		cmbSongs = new JComboBox();
		cmbSongs.setBounds(460, 65, 100, 25);
		add(cmbSongs);
		
		btnAdd2 = new JButton ("Add");
		btnAdd2.setBounds(565, 65, 70, 25);
		add(btnAdd2);
		
	}
}
