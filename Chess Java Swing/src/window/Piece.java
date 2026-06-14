package window;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import lib.Constants;

public class Piece extends JLabel implements Constants {

	/**
	 *
	 */
	private static final long serialVersionUID = -6284508934775907437L;

	private String fileName;

	private boolean white;

	public int moves;

	private int X, Y;

	private Piece(String fileName, boolean white) {
		// TODO Auto-generated constructor stub
		this.fileName = fileName;
		this.white = white;
		moves = 0;

		setSize(PIECE_SIZE);
		setLocation((BOX_SIZE.width - getWidth()) / 2, (BOX_SIZE.height - getHeight()) / 2);

		Piece thisPiece = this;

		MouseAdapter mouse = new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
                Container currentParent = getParent();
                Point mouseInLabel = SwingUtilities.convertPoint(thisPiece, e.getPoint(), label);

                if (currentParent != label) {
                    currentParent.remove(thisPiece);

                    label.add(thisPiece);
                    label.setComponentZOrder(thisPiece, 0);
                }

                int newX = mouseInLabel.x - (thisPiece.getWidth() / 2);
                int newY = mouseInLabel.y - (thisPiece.getHeight() / 2);
                thisPiece.setLocation(newX, newY);

                label.repaint();
			}

			@Override
            public void mouseDragged(MouseEvent e) {
				Point mouseInLabel = SwingUtilities.convertPoint(thisPiece, e.getPoint(), label);

				int newX = mouseInLabel.x - (thisPiece.getWidth() / 2);
                int newY = mouseInLabel.y - (thisPiece.getHeight() / 2);

                newX = newX > board.getX() + board_width - getWidth() / 2 ?
                		board.getX() + board_width - getWidth() / 2 :
                		newX < board.getX() - getWidth() / 2 ? board.getX() - getWidth() / 2 : newX;

                newY = newY > board.getY() + board_width - getHeight() / 2 ?
                		board.getY() + board_width - getHeight() / 2 :
                		newY < board.getY() - getHeight() / 2 ? board.getY() - getWidth() / 2 : newY;

                thisPiece.setLocation(newX, newY);
            }

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				Point mouseInBoard = SwingUtilities.convertPoint(thisPiece, e.getPoint(), board);

				int gridX = mouseInBoard.x / BOX_SIZE.width;
				int gridY = board.isReverse()? (mouseInBoard.y / BOX_SIZE.height) :
												(7 - mouseInBoard.y / BOX_SIZE.height);

				label.remove(thisPiece);

				if((gridX >= 0 && gridX <= 7) && (gridY >= 0 && gridY <= 7)) {
					if(gridX == X && gridY == Y) {
						grid[gridX][gridY].addPiece(thisPiece);
					}
					else {
						grid[gridX][gridY].addPiece(grid[X][Y].removePiece());
					}
				}
				else {
					grid[X][Y].addPiece(thisPiece);
				}

				label.repaint();
			}
		};

		addMouseListener(mouse);
		addMouseMotionListener(mouse);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		HELP.getSVG(fileName).paintIcon(this, g, 0, 0);
	}

	public static Piece king(boolean white)
	{
		return new Piece((white?"w":"b")+"K.svg", white);
	}

	public static Piece queen(boolean white)
	{
		return new Piece((white?"w":"b")+"Q.svg", white);
	}

	public static Piece bishop(boolean white)
	{
		return new Piece((white?"w":"b")+"B.svg", white);
	}

	public static Piece rook(boolean white)
	{
		return new Piece((white?"w":"b")+"R.svg", white);
	}

	public static Piece knight(boolean white)
	{
		return new Piece((white?"w":"b")+"N.svg", white);
	}

	public static Piece pawn(boolean white)
	{
		return new Piece((white?"w":"b")+"P.svg", white);
	}

	public boolean isWhite() {
		return white;
	}

	public int getx() {
		return X;
	}

	public void setx(int x) {
		X = x;
	}

	public int gety() {
		return Y;
	}

	public void sety(int y) {
		Y = y;
	}
}
