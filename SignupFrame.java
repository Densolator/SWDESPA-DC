import java.awt.*;

import javax.swing.*;

public class SignupFrame extends JFrame{
	private JPanel mainPanel;
	private JLabel usernameLabel, passwordLabel;
	private JTextField username, password;
	private JButton registerButton;
	
	public SignupFrame()
	{
		initialize();
		setVisible(false);
		setPreferredSize(new Dimension(500,500));
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	
	private void initialize()
	{
		mainPanel = new JPanel(new GridLayout());
//		mainPanel.setBounds(0,0,500,500);
//		mainPanel.setPreferredSize(new Dimension(500,500));

		usernameLabel = new JLabel("Username:");
		passwordLabel = new JLabel("Password:");
		username = new JTextField();
		password = new JTextField();
		registerButton = new JButton("Register");
		mainPanel.add(usernameLabel);
		mainPanel.add(username);
		mainPanel.add(passwordLabel);
		mainPanel.add(password);
		this.add(mainPanel);
		
	}
	
	private GridBagConstraints createGridBagConstraint(int x, int y)
	{
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.gridx = x;
		constraint.gridy = y;
		return constraint;
	}
	
	public void showFrame()
	{
		setVisible(true);
	}
	
	public void hideFrame()
	{
		setVisible(false);
	}
}
