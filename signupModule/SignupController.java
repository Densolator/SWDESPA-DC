package signupModule;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SignupController {
	
	int userid = 4;
	public void register(String username, String password)
	{
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "rootadmin");
			Statement stmt = con.createStatement();
			String sql = "INSERT INTO user (userid,username, password)" +  "VALUES ("+ userid +",'" + username + "','" + password + "')";
			stmt.executeUpdate(sql);
			userid++;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
