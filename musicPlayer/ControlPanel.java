package musicPlayer;
import java.awt.*;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
public class ControlPanel extends JPanel{
	private Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
	private JButton playPauseButton, forwardButton, backButton, nextButton, prevButton;
	private JProgressBar musicBar;
	private Image img, scaledimg;
	
	public ControlPanel()
	{
		setBorder(blackBorder);
		setPreferredSize(new Dimension(1000,100));
		
		initialize();
	}
	
	private void initialize()
	{
		try
		{
			this.setLayout(new FlowLayout());
			
			musicBar = new JProgressBar();
			
			playPauseButton = new JButton();
			img = ImageIO.read(getClass().getResource("Play_pause_icon.png"));
			scaledimg = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		    playPauseButton.setIcon(new ImageIcon(scaledimg));
		    playPauseButton.setBorderPainted(false);
		    playPauseButton.setContentAreaFilled(false);
		    
		    img = ImageIO.read(getClass().getResource("Forward_icon.png"));
		    scaledimg = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
			forwardButton = new JButton();
			forwardButton.setIcon(new ImageIcon(scaledimg));
			forwardButton.setBorderPainted(false);
			forwardButton.setContentAreaFilled(false);
			
			img = ImageIO.read(getClass().getResource("Back_button.png"));
			scaledimg = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
			backButton = new JButton();
			backButton.setIcon(new ImageIcon(scaledimg));
			backButton.setBorderPainted(false);
			backButton.setContentAreaFilled(false);
			
			img = ImageIO.read(getClass().getResource("Next_icon.png"));
			scaledimg = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
			nextButton = new JButton();
			nextButton.setIcon(new ImageIcon(scaledimg));
			nextButton.setBorderPainted(false);
			nextButton.setContentAreaFilled(false);
			
			img = ImageIO.read(getClass().getResource("Back_button.png"));
			scaledimg = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
			prevButton = new JButton();
			prevButton.setIcon(new ImageIcon(scaledimg));
			prevButton.setBorderPainted(false);
			prevButton.setContentAreaFilled(false);
			
			
			add(prevButton);
			add(backButton);
			add(playPauseButton);
			add(forwardButton);
			add(nextButton);
			add(musicBar);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
