package window;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

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
		Image img = settings.getImage();

		if(img != null)
			g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
	}

	public void initializeGrid() {
		for(int i = 0; i < 8; i ++) {
			for(int j = 0; j < 8; j ++) {
				grid[i][j] = new Box(i, j);
				add(grid[i][j]);

				if(j == 1)
					grid[i][j].addPiece(Piece.pawn(true));

				if(j == 6)
					grid[i][j].addPiece(Piece.pawn(false));
			}
		}

		grid[4][0].addPiece(Piece.king(true));
		grid[4][7].addPiece(Piece.king(false));

		grid[3][0].addPiece(Piece.queen(true));
		grid[3][7].addPiece(Piece.queen(false));

		grid[2][0].addPiece(Piece.bishop(true));
		grid[2][7].addPiece(Piece.bishop(false));
		grid[5][0].addPiece(Piece.bishop(true));
		grid[5][7].addPiece(Piece.bishop(false));

		grid[1][0].addPiece(Piece.knight(true));
		grid[1][7].addPiece(Piece.knight(false));
		grid[6][0].addPiece(Piece.knight(true));
		grid[6][7].addPiece(Piece.knight(false));

		grid[0][0].addPiece(Piece.rook(true));
		grid[0][7].addPiece(Piece.rook(false));
		grid[7][0].addPiece(Piece.rook(true));
		grid[7][7].addPiece(Piece.rook(false));
	}

}
