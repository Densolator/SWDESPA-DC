package playlistModule;

import java.sql.*;

public class playlistController {
	
	public void playlist (int playlistid)
	{
		
		PreparedStatement preparedStatement = null;
		
		String sql = "SELECT * FROM playlist WHERE userid = ?";
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "");
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, 1);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {

				String playlistname = rs.getString("playlistname");

				System.out.println("Playlist Name: " + playlistname);
			}
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
