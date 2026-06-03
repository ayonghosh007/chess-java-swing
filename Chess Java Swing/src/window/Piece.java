package window;

import java.awt.Graphics;

import javax.swing.JLabel;

import lib.Constants;

public class Piece extends JLabel implements Constants {

	/**
	 *
	 */
	private static final long serialVersionUID = -6284508934775907437L;

	private String fileName;

	private boolean white;

	private Piece(String fileName) {
		// TODO Auto-generated constructor stub
		this.fileName = fileName;

		setSize(PIECE_SIZE);
		setLocation((BOX_SIZE.width - getWidth()) / 2, (BOX_SIZE.height - getHeight()) / 2);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		HELP.getSVG(fileName).paintIcon(this, g, 0, 0);
	}

	public static Piece king(boolean white)
	{
		return new Piece((white?"w":"b")+"K.svg");
	}

	public static Piece queen(boolean white)
	{
		return new Piece((white?"w":"b")+"Q.svg");
	}

	public static Piece bishop(boolean white)
	{
		return new Piece((white?"w":"b")+"B.svg");
	}

	public static Piece rook(boolean white)
	{
		return new Piece((white?"w":"b")+"R.svg");
	}

	public static Piece knight(boolean white)
	{
		return new Piece((white?"w":"b")+"N.svg");
	}

	public static Piece pawn(boolean white)
	{
		return new Piece((white?"w":"b")+"P.svg");
	}

	public boolean isWhite() {
		return white;
	}
}
