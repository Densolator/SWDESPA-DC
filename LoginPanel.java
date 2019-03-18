
import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;

public class LoginPanel extends JPanel{
	private JTextField username, password;
	private JLabel usernameLabel, passwordLabel;
	private JButton loginButton;
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
		username = new JTextField();
		password = new JTextField();
		loginButton = new JButton("Log in");
		this.setLayout(new GridLayout(5,2));
		this.add(usernameLabel);
		this.add(username);
		this.add(passwordLabel);
		this.add(password);
		this.add(loginButton);
		
	}
	
	public JButton getLoginButton()
	{
		return loginButton;
	}
}
