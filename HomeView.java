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

import musicPlayer.ControlPanel;

public class HomeView {
	private JFrame homeFrame;
	private JPanel songsListPanel, westPanel, logincardPanel, logincardcontainerPanel, menupanelContainer, mainPanel;
	private JTextField username, password;
	private JButton loginButton, playPauseButton, forwardButton, backButton, nextButton, prevButton;
	private JProgressBar musicBar;
	private JLabel usernameLabel, passwordLabel;
	private LoginPanel loginPanel;
	private ControlPanel controlPanel;
	private LogoutPanel logoutPanel;
	private CardLayout logincardLayout = new CardLayout(), maincardlayout = new CardLayout();
	private SignupFrame signupframe;
	private MenuPanel menuPanel;
	private ProfilePanel profilePanel;
	private SongsPanel songsPanel;
	private PlaylistPanel playlistPanel;
	
	public HomeView()
	{
		Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
		westPanel = new JPanel(new GridLayout(2,0));
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
		logincardPanel.setPreferredSize(new Dimension(300,200));
		logincardPanel.add(loginPanel, "Login");
		logincardPanel.add(logoutPanel, "Logout");
		logincardcontainerPanel = new JPanel();
		logincardcontainerPanel.add(logincardPanel);
		
		signupframe = new SignupFrame();
		signupframe.showFrame();
		
		menuPanel = new MenuPanel();
		menupanelContainer = new JPanel(new GridLayout());
		menupanelContainer.add(menuPanel);
		menuPanel.getProfileButton().addActionListener(new btnProfile_Pressed());
		menuPanel.getSongsButton().addActionListener(new btnSongs_Pressed());
		menuPanel.getPlaylistButton().addActionListener(new btnPlaylist_Pressed());
		
		westPanel.add(logincardcontainerPanel, BorderLayout.NORTH);
		westPanel.add(menupanelContainer, BorderLayout.SOUTH);
		
		mainPanel = new JPanel(maincardlayout);
		mainPanel.setBorder(blackBorder);
		profilePanel = new ProfilePanel();
		songsPanel = new SongsPanel();
		playlistPanel = new PlaylistPanel();
		mainPanel.add(profilePanel, "Profile");
		mainPanel.add(songsPanel, "Songs");
		mainPanel.add(playlistPanel, "Playlist");
		
		
		
		homeFrame.add(westPanel, BorderLayout.WEST);
		homeFrame.add(controlPanel, BorderLayout.PAGE_END);
		homeFrame.add(mainPanel, BorderLayout.CENTER);
		homeFrame.setVisible(true);
	}
	
	class btnLogin_Pressed implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(loginPanel.login())
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
	
	class btnProfile_Pressed implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			maincardlayout.show(mainPanel, "Profile");;
		}
		
	} 
	
	class btnSongs_Pressed implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			maincardlayout.show(mainPanel, "Songs");;
		}
		
	}
	
	class btnPlaylist_Pressed implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			maincardlayout.show(mainPanel, "Playlist");;
		}
		
	} 
	
}
