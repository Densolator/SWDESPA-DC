package songsModule;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import main.DBConnector;

public class SongsPanel extends JPanel{
	private JLabel label;
	private JTable tblSongs;
	private JButton btnAdd;
	private DBConnector dbcon = new DBConnector();
//	private MusicPlayerController = new MusicPlayerController();
	private ResultSet songs;
	private SongsController sc = new SongsController();
	
	public SongsPanel()
	{
		try {
			songs = dbcon.getAllSongs();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setLayout(new FlowLayout(50, 50, 50));
		instantiate();
	}
	
	private void instantiate()
	{
		label = new JLabel("My Songs");
		//label.setBounds(300, 1, 200,100);
		add(label);
		int i = 0;
		//sample output
		String[] columns = {"Title", "Album", "Genre", "Year"};
		ArrayList<Object[]> results = new ArrayList<Object[]>();
		
		try {
			while(songs.next())
			{
				String title = songs.getString(2);

				
				ResultSet albumresult = dbcon.getAlbumWithID(songs.getInt(5));
				albumresult.first();
				String album = albumresult.getString(2);
	
				
				ResultSet genreresult = dbcon.getGenreWithID(songs.getInt(4));
				genreresult.first();
				String genre = genreresult.getString(2);

				
				int year = songs.getInt(7);

				Object[] result = {title, album, genre, year};
//				System.out.println("For iteration number " + i + ": " + title + album + genre + year);
				results.add(result);
				i++;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(results.get(2)[0]);
//		System.out.println(results.size());
		Object[][] data = new Object[results.size()][];
		
		for(int ctr = 0; ctr < results.size(); ctr++)
		{
			data[ctr] = results.get(ctr);
//			System.out.println(data[ctr][3]);
		}
//		System.out.println(data[0][0]);
//		System.out.println(data[1][0]);
		tblSongs = new JTable (data, columns);
//		tblSongs = new JTable ();
		tblSongs.setPreferredScrollableViewportSize(new Dimension(500,250));
		tblSongs.setFillsViewportHeight(true);
		JScrollPane scrollpane = new JScrollPane(tblSongs);
		add(scrollpane);
		
		btnAdd = new JButton ("Add Songs");
		add(btnAdd);
		
		tblSongs.getSelectionModel().addListSelectionListener(new tableRow_Selected());
	}
	
	public void refresh()
	{
		String[] columns = {"Title", "Album", "Genre", "Year"};
		int i = 0;

		ArrayList<Object[]> results = new ArrayList<Object[]>();
		
		try {
			while(songs.next())
			{
				String title = songs.getString(2);

				
				ResultSet albumresult = dbcon.getAlbumWithID(songs.getInt(5));
				albumresult.first();
				String album = albumresult.getString(2);
	
				
				ResultSet genreresult = dbcon.getGenreWithID(songs.getInt(4));
				genreresult.first();
				String genre = genreresult.getString(2);

				
				int year = songs.getInt(7);

				Object[] result = {title, album, genre, year};
//				System.out.println("For iteration number " + i + ": " + title + album + genre + year);
				results.add(result);
				i++;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(results.size());
		Object[][] data = new Object[results.size()][];
		
		for(int ctr = 0; ctr < results.size(); ctr++)
		{
			data[ctr] = results.get(ctr);
		}
		tblSongs = new JTable (data, columns);
	}
	
//	jTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
	class tableRow_Selected implements ListSelectionListener {
	    @Override
	    public void valueChanged(ListSelectionEvent arg0) {
	        if (tblSongs.getSelectedRow() > -1) {
	            // print first column value from selected row
	            sc.play(tblSongs.getValueAt(tblSongs.getSelectedRow(), 0).toString());
	        }
	    }

		
	}
}
