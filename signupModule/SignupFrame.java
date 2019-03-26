package signupModule;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SignupFrame extends JFrame{
	private JPanel mainPanel;
	private JLabel usernameLabel, passwordLabel;
	private JTextField username;
	private JPasswordField password;
	private JButton registerButton;
	SignupController controller = new SignupController();
	
	public SignupFrame()
	{
		initialize();
		setVisible(false);
		setPreferredSize(new Dimension(500,500));
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	
	private void initialize()
	{
		mainPanel = new JPanel(new GridLayout(0,2));
//		mainPanel.setBounds(0,0,500,500);
//		mainPanel.setPreferredSize(new Dimension(500,500));

		usernameLabel = new JLabel("Username:");
		passwordLabel = new JLabel("Password:");
		username = new JTextField();
		password = new JPasswordField();
		registerButton = new JButton("Register");
		registerButton.addActionListener(new btnRegister_Pressed());
		mainPanel.add(usernameLabel);
		mainPanel.add(username);
		mainPanel.add(passwordLabel);
		mainPanel.add(password);
		mainPanel.add(registerButton);
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
	
	class btnRegister_Pressed implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			controller.register(username.getText(), String.valueOf(password.getPassword()));
		}
		
	}
}
