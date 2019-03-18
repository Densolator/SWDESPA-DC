import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;

public class LogoutPanel extends JPanel{
	private Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);

	private JButton logoutButton;
	private JLabel welcomeText;
	
	public LogoutPanel()
	{
		setBorder(blackBorder);
		setPreferredSize(new Dimension(300,100));
		setLayout(new BoxLayout(this, 1));
		setMaximumSize(new Dimension(300,100));
		
		initialize();
	}
	
	private void initialize()
	{
		logoutButton = new JButton();
		welcomeText = new JLabel("Welcome, User!");
		add(welcomeText);
		add(logoutButton);
	}
	
	public JButton getLogoutButton()
	{
		return logoutButton;
	}
}
