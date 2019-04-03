package profileModule;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class ProfileController {
	public enum Type{
		PLAYLIST, SONG
	}
	
	public HashMap<Integer, String> fave(int userid, Type type) {
		
		PreparedStatement preparedStatement = null;
		
		String sql;

		if (type == Type.PLAYLIST){
			sql = "SELECT * FROM playlist P INNER JOIN favoriteplaylists FP ON P.playlistid = FP.playlistid WHERE FP.userid = ?";
		} else {
			sql = "SELECT * FROM song S INNER JOIN favoritesongs FS ON S.songid = FS.songid WHERE FS.userid = ?";
		}

		HashMap<Integer, String> playlists = new HashMap<>();
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, 1);
			
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				if (type == Type.PLAYLIST) {
					playlists.put(rs.getInt("playlistid"), rs.getString("playlistname"));
				} else {
					playlists.put(rs.getInt("songid"), rs.getString("songname"));
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		} finally {
			return playlists;
		}
	}
}
