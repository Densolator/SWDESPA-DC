package loginModule;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class LoginController {
	LoginPanel loginPanel;
	boolean isLoggedin = false;
	
	public LoginController(LoginPanel view)
	{
		loginPanel = view;
	}
	public boolean login(String username, String password)
	{
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "rootadmin");
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM user WHERE username='"+username+"' and password='"+password+"'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.first())
			{
				System.out.println(rs.isFirst());
				isLoggedin = true;
				JOptionPane.showMessageDialog(null, "Login Successful");
			}
			else
			{
				System.out.println(rs.isFirst());
				isLoggedin = false;
				JOptionPane.showMessageDialog(null, "Login Failed");
			}
			con.close();
			return isLoggedin;
		}
		catch(Exception e){
			e.printStackTrace();
			return isLoggedin;
		}
	}
}
