package window;

import javax.swing.JLabel;

import lib.Constants;

public class Label extends JLabel implements Constants {

	/**
	 *
	 */
	private static final long serialVersionUID = -1534733691090703505L;

	public Label() {
		// TODO Auto-generated constructor stub
		setVisible(true);
		setOpaque(false);
		setSize(SCREEN_SIZE);
		setLocation(0, 0);
	}
}