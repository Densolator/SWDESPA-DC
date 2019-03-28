import java.awt.*;

import javax.swing.*;
public class SongsPanel extends JPanel{
	private JLabel label;
	private JTable tblSongs;
	private JButton btnAdd;
	
	public SongsPanel()
	{
		setLayout(new FlowLayout(50, 50, 50));
		instantiate();
	}
	
	private void instantiate()
	{
		label = new JLabel("My Songs");
		//label.setBounds(300, 1, 200,100);
		add(label);
		
		//sample output
		String[] columns = {"Title", "Album", "Genre", "Year"};
		Object[][] data = {{"Hello", "Adele", "Pop", "2010"}};
		
		tblSongs = new JTable (data, columns);
		tblSongs.setPreferredScrollableViewportSize(new Dimension(500,250));
		tblSongs.setFillsViewportHeight(true);
		JScrollPane scrollpane = new JScrollPane(tblSongs);
		add(scrollpane);
		
		btnAdd = new JButton ("Add Songs");
		add(btnAdd);
	}
}
