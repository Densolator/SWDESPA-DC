package main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector{
	Connection con;
	String query;
	ResultSet results;

	public DBConnector()
	{
		try {
			con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "rootadmin");
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public ResultSet getAllSongs() throws SQLException
	{
		Statement statement;
		statement = con.createStatement();
		query = "SELECT * FROM song";
		results = statement.executeQuery(query);
		return results;
	}
	
	public ResultSet getSongsWithName(String songname) throws SQLException
	{
		Statement statement;
		statement = con.createStatement();
		query = "SELECT * FROM song WHERE songname = '" + songname + "'";
		results = statement.executeQuery(query);
		return results;
	}
	
	public ResultSet getSongWithID(int songid) throws SQLException
	{
		Statement statement;
		statement = con.createStatement();
		query = "SELECT * FROM song WHERE songid =" + songid;
		results = statement.executeQuery(query);
		return results;
	}
	
	public ResultSet getPlaylistForUser(int userid) throws SQLException
	{
		Statement statement;
		statement = con.createStatement();
		query = "SELECT * FROM playlist WHERE playlistuser = "+userid;
		results = statement.executeQuery(query);
		return results;
	}
	
	public ResultSet getPlaylistWithID(int playlistid) throws SQLException
	{
		Statement statement;
		statement = con.createStatement();
		query = "SELECT * FROM playlist WHERE playlistid =" + playlistid;
		results = statement.executeQuery(query);
		return results;
	}
	
	public ResultSet getSongsforGenre(int genreid) throws SQLException
	{
		Statement statement;
		statement = con.createStatement();
		query = "SELECT * FROM genresongs WHERE genreid =" + genreid;
		results = statement.executeQuery(query);
		return results;
	}
	
	public ResultSet getGenreWithID(int genreid) throws SQLException
	{
		Statement statement;
		statement = con.createStatement();
		query = "SELECT * FROM genre WHERE genreid =" + genreid;
		results = statement.executeQuery(query);
		return results;
	}
	
	public ResultSet getAlbumWithID(int albumid) throws SQLException
	{
		Statement statement;
		statement = con.createStatement();
		query = "SELECT * FROM album WHERE albumid =" + albumid;
		results = statement.executeQuery(query);
		return results;
	}
	
	public ResultSet getSongsForAlbum(int albumid) throws SQLException
	{
		Statement statement;
		statement = con.createStatement();
		query = "SELECT * FROM albumsongs WHERE albumid =" + albumid;
		results = statement.executeQuery(query);
		return results;
	}
	
	public ResultSet getSongsInPlaylist(int playlistid) throws SQLException
	{
		Statement statement;
		statement = con.createStatement();
		query = "SELECT * FROM playlist_songs WHERE playlistid =" + playlistid;
		results = statement.executeQuery(query);
		return results;
	}
	
	public ResultSet getPlaylistOfSong(int songid) throws SQLException
	{
		Statement statement;
		statement = con.createStatement();
		query = "SELECT * FROM playlist_songs WHERE songid =" +songid;
		results = statement.executeQuery(query);
		return results;
	}
}
