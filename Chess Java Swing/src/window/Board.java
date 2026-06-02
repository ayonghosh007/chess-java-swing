package window;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

import lib.Constants;

public class Board extends JLabel implements Constants {

	/**
	 *
	 */
	private static final long serialVersionUID = 9009501604564899782L;

	public Board() {
		setSize(BOARD_SIZE);
		setLocation(SCREEN_SIZE.width/2 - BOARD_SIZE.width/2, SCREEN_SIZE.height/2 - BOARD_SIZE.height/2);
		setOpaque(true);
		setVisible(true);
		setBackground(Color.WHITE);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(settings.getImage(), 0, 0, getWidth(), getHeight(), null);
	}

	public void initializeGrid() {
		for(int i = 0; i < 8; i ++) {
			for(int j = 0; j < 8; j ++) {
				grid[i][j] = new Box(i, j);
				add(grid[i][j]);
			}
		}
	}

}
