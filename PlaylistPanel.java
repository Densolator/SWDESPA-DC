import java.awt.*;

import javax.swing.*;
public class PlaylistPanel extends JPanel{
	private JLabel label;
	
	public PlaylistPanel()
	{
		setLayout(new FlowLayout());
		instantiate();
	}
	
	private void instantiate()
	{
		label = new JLabel("This panel is for the User's playlist");
		add(label);
	}
}