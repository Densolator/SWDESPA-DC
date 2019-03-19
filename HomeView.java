import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;

public class HomeView {
	private JFrame homeFrame;
	private JPanel songsListPanel, westPanel, logincardPanel, logincardcontainerPanel;
	private JTextField username, password;
	private JButton loginButton, playPauseButton, forwardButton, backButton, nextButton, prevButton;
	private JProgressBar musicBar;
	private JLabel usernameLabel, passwordLabel;
	private LoginPanel loginPanel;
	private ControlPanel controlPanel;
	private LogoutPanel logoutPanel;
	private CardLayout logincardLayout = new CardLayout();
	
	public HomeView()
	{
		Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
		westPanel = new JPanel(new CardLayout());
		westPanel.setBounds(0,0,1000,1000);
		westPanel.setBorder(blackBorder);
		
		homeFrame = new JFrame("Music Player");
		homeFrame.setPreferredSize(new Dimension(1000,1000));
		homeFrame.setBounds(0,0,1000,1000);
		homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		loginPanel = new LoginPanel();
		loginPanel.getLoginButton().addActionListener(new btnLogin_Pressed());
		logoutPanel = new LogoutPanel();
		logoutPanel.getLogoutButton().addActionListener(new btnLogout_Pressed());
	
		controlPanel = new ControlPanel();
		
		logincardPanel = new JPanel(logincardLayout);
		logincardPanel.setPreferredSize(new Dimension(300,100));
		logincardPanel.add(loginPanel, "Login");
		logincardPanel.add(logoutPanel, "Logout");
		logincardPanel.setBorder(blackBorder);
		logincardcontainerPanel = new JPanel();
		logincardcontainerPanel.add(logincardPanel);
		
		
		westPanel.add(logincardcontainerPanel, BorderLayout.NORTH);
		
		
		homeFrame.add(westPanel, BorderLayout.WEST);
		homeFrame.add(controlPanel, BorderLayout.PAGE_END);
		homeFrame.setVisible(true);
	}
	
	class btnLogin_Pressed implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			logincardLayout.show(logincardPanel, "Logout");
		}
		
	}
	
	class btnLogout_Pressed implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			logincardLayout.show(logincardPanel, "Login");
		}
		
	}
}
