import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class LoginController {
	LoginPanel loginPanel;
	
	public void login(String username, String password)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "");
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM user WHERE username='"+username+"' and password='"+password+"'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
				JOptionPane.showMessageDialog(null, "Login Successful");
			else
				JOptionPane.showMessageDialog(null, "Login Failed");
			con.close();
		}
		catch(Exception e){
			System.out.print(e);
		}
	}
}
