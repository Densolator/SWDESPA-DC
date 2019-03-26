import java.awt.*;

import javax.swing.*;
public class ProfilePanel extends JPanel{
	private JLabel label;
	
	public ProfilePanel()
	{
		setLayout(new FlowLayout());
		instantiate();
	}
	
	private void instantiate()
	{
		label = new JLabel("This panel is for the User's profile");
		add(label);
	}
}
