package musicPlayer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.border.Border;
public class ControlPanel extends JPanel{
	private Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
	private JButton playPauseButton, forwardButton, backButton, nextButton, prevButton;
	private JProgressBar musicBar;
	private Image img, scaledimg;
	private MusicPlayerController controller = new MusicPlayerController();
	
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
			
			
			playPauseButton = new JButton();
			img = ImageIO.read(getClass().getResource("Play_Icon.png"));
			scaledimg = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		    playPauseButton.setIcon(new ImageIcon(scaledimg));
		    playPauseButton.setBorderPainted(false);
		    playPauseButton.setContentAreaFilled(false);
		    playPauseButton.addActionListener(new btnPlay_Pressed());
		    
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
			
			img = ImageIO.read(getClass().getResource("Previous_icon.png"));
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
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	class btnPlay_Pressed implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				controller.play("song1");
			} catch (LineUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (UnsupportedAudioFileException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
