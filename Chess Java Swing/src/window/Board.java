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

	private boolean rev;

	public Board() {
		rev = false;

		setSize(BOARD_SIZE);
		setLocation(SCREEN_SIZE.width/2 - BOARD_SIZE.width/2, SCREEN_SIZE.height/2 - BOARD_SIZE.height/2);
		setOpaque(true);
		setVisible(true);
		setBackground(Color.WHITE);
		setLayout(null);
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

				if(j == 1) {
					pieces[0][i + 8] = Piece.pawn(true);
					grid[i][j].addPiece(pieces[0][i + 8]);
				}

				if(j == 6) {
					pieces[1][i + 8] = Piece.pawn(false);
					grid[i][j].addPiece(pieces[1][i + 8]);
				}
			}
		}

		pieces[0][0] = Piece.king(true);
		pieces[1][0] = Piece.king(false);
		grid[4][0].addPiece(pieces[0][0]);
		grid[4][7].addPiece(pieces[1][0]);

		pieces[0][1] = Piece.queen(true);
		pieces[1][1] = Piece.queen(false);
		grid[3][0].addPiece(pieces[0][1]);
		grid[3][7].addPiece(pieces[1][1]);

		pieces[0][2] = Piece.bishop(true);
		pieces[1][2] = Piece.bishop(false);
		pieces[0][3] = Piece.bishop(true);
		pieces[1][3] = Piece.bishop(false);
		grid[2][0].addPiece(pieces[0][2]);
		grid[2][7].addPiece(pieces[1][2]);
		grid[5][0].addPiece(pieces[0][3]);
		grid[5][7].addPiece(pieces[1][3]);

		pieces[0][4] = Piece.knight(true);
		pieces[1][4] = Piece.knight(false);
		pieces[0][5] = Piece.knight(true);
		pieces[1][5] = Piece.knight(false);
		grid[1][0].addPiece(pieces[0][4]);
		grid[1][7].addPiece(pieces[1][4]);
		grid[6][0].addPiece(pieces[0][5]);
		grid[6][7].addPiece(pieces[1][5]);

		pieces[0][6] = Piece.rook(true);
		pieces[1][6] = Piece.rook(false);
		pieces[0][7] = Piece.rook(true);
		pieces[1][7] = Piece.rook(false);
		grid[0][0].addPiece(pieces[0][6]);
		grid[0][7].addPiece(pieces[1][6]);
		grid[7][0].addPiece(pieces[0][7]);
		grid[7][7].addPiece(pieces[1][7]);
	}

	public void reverse() {
		rev = !rev;
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++)
				grid[i][j].reverse();
		}
	}

	public boolean isReverse() {
		return rev;
	}

	public void calculate() {

	}
}
