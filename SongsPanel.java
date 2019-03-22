import java.awt.*;

import javax.swing.*;
public class SongsPanel extends JPanel{
	private JLabel label;
	
	public SongsPanel()
	{
		setLayout(new FlowLayout());
		instantiate();
	}
	
	private void instantiate()
	{
		label = new JLabel("This panel is for the User's songs");
		add(label);
	}
}
