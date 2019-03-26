
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.Border;

public class LoginPanel extends JPanel{
	private JTextField username;
	private JPasswordField password;
	private JLabel usernameLabel, passwordLabel, signupLabel;
	private JButton loginButton, signupButton;
	private Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
	
	public LoginPanel() {
		setBorder(blackBorder);
		setPreferredSize(new Dimension(300,100));
		setMaximumSize(new Dimension(300,100));
		
		initialize();
	}
	
	private void initialize()
	{
		usernameLabel = new JLabel("Username: ");
		passwordLabel = new JLabel("Password: ");
		signupLabel = new JLabel("Don't have an account yet?");
		username = new JTextField();
		password = new JPasswordField();
		loginButton = new JButton("Log in");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "");
					Statement stmt = con.createStatement();
					String sql = "SELECT * FROM user WHERE username='"+username.getText()+"' and password='"+password.getText().toString()+"'";
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
		});
		signupButton = new JButton("Sign up");
		
		this.setLayout(new GridLayout(7,2));
		
		this.add(usernameLabel);
		
		this.add(username);
		
		this.add(passwordLabel);
		
		this.add(password);
		
		this.add(loginButton);
		
		this.add(signupLabel);
		this.add(signupButton);
		
		
	}
	
	public JButton getLoginButton()
	{
		return loginButton;
	}
	
	public JButton getSignupButton()
	{
		return signupButton;
	}
	
}
