package window;

import javax.swing.JFrame;

import main.Constants;

public class Frame extends JFrame implements Constants {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7929949333044430064L;
	
	public Frame() {
		setVisible(false);
		setLocation(0, 0);
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setUndecorated(true);
	}

}
