import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PlaylistPanel extends JPanel{
	private JPanel panelCreate;
	private JLabel label, label1, label2;
	private JTable tblList;
	private JButton btnCreate, btnDone;
	private JFrame frmCreate;
	private JTextField txtName;
	
	public PlaylistPanel()
	{
		setLayout(null);
		instantiate();
	}
	
	private void instantiate()
	{
		label = new JLabel("My Playlist");
		label.setBounds(300, 1, 200, 100);
		add(label);
		
		//array of playlist names
		DefaultListModel<String> names = new DefaultListModel<>();  
	     names.addElement("Playlist1");  
	     names.addElement("Playlist2");  
	     names.addElement("Playlist3");   
       
       JList<String> playlist = new JList<>(names);  
		playlist.setBounds(100, 75, 200, 600);
		add(playlist);
		
		
		btnCreate = new JButton ("Create Playlist");
		btnCreate.setBounds(350, 150, 150, 75);
		btnCreate.addActionListener(new btnCreate_Pressed());
		add(btnCreate);
		
	}
	
		class btnCreate_Pressed implements ActionListener {
		@Override
		public void actionPerformed (ActionEvent arg0)
		{
			frmCreate = new JFrame ("Create Playlist");
			frmCreate.setSize(500, 500);
			Container pane = frmCreate.getContentPane();
	        pane.setLayout(null);
			frmCreate.setVisible(true);
			
			//playlist details
			
			label1 = new JLabel ("Playlist name: ");
			label1.setBounds(50, 25, 200, 100);
			frmCreate.add(label1);
			
			txtName = new JTextField();
			txtName.setBounds(140, 60, 150, 25);
			frmCreate.add(txtName);
			
			label2 = new JLabel ("Select songs: ");
			label2.setBounds(50, 75, 200, 100);
			frmCreate.add(label2);
			
			//how list looks like - array of strings
		     DefaultListModel<String> songs = new DefaultListModel<>();  
		     songs.addElement("Song1");  
		     songs.addElement("Song2");  
		     songs.addElement("Song3");   
	        
	        JList<String> list = new JList<>(songs);  
			list.setBounds(135, 110, 200, 300);
			frmCreate.add(list);
			
			btnDone = new JButton ("Create");
			btnDone.setBounds(375, 400, 75, 50);
			frmCreate.add(btnDone);
			
		}
	}

	

}
