package window;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;

import lib.Constants;

public class Box extends JLabel implements Constants {

	/**
	 *
	 */
	private static final long serialVersionUID = -9049289875180972315L;

	private int x, y;

	public Box(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;

		setSize(BOX_SIZE);
		setLocation(BOX_SIZE.width * x, BOARD_SIZE.height - BOX_SIZE.width * (y + 1));
		setOpaque(false);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g.create();

		g2d.setColor((x + y) % 2 == 0? settings.lightColor() : settings.darkColor());
        g2d.fillRect(0, 0, getWidth(), getHeight());

        g2d.dispose();
	}
}
