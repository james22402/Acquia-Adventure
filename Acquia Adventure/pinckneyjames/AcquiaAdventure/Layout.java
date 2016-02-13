package pinckneyjames.AcquiaAdventure;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

public class Layout extends BorderLayout {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Runner runner;

	public Layout() {
		
	}
	
	public void addTheComponent(JPanel c, String direction, int x, int y, int w, int h)
	{
		Runner.frame.add(c, direction);
		c.setPreferredSize(new Dimension(w,h));
		Runner.frame.setVisible(true);
	}

	

}
