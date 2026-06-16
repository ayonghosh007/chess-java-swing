package window;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputAdapter;

import lib.Constants;
import moves.BishopMoves;
import moves.KingMoves;
import moves.KnightMoves;
import moves.Moves;
import moves.PawnMoves;
import moves.QueenMoves;
import moves.RookMoves;

public class Piece extends JLabel implements Constants {

	public static final String KING = "K";
	public static final String QUEEN = "Q";
	public static final String BISHOP = "B";
	public static final String KNIGHT = "N";
	public static final String ROOK = "R";
	public static final String PAWN = "P";

	public static final String WHITE = "w";
	public static final String BLACK = "b";

	/**
	 *
	 */
	private static final long serialVersionUID = -6284508934775907437L;
	private String fileName;
	private boolean moved;
	private int X, Y;

	public Moves moves;

	private Piece(String fileName) {
		// TODO Auto-generated constructor stub
		this.fileName = fileName;
		this.moved = false;

		setSize(PIECE_SIZE);
		setLocation((BOX_SIZE.width - getWidth()) / 2, (BOX_SIZE.height - getHeight()) / 2);

		Piece thisPiece = this;

		MouseInputAdapter mouse = new MouseInputAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				setCursor(HELP.getCursor("palm"));
			}

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
				setCursor(HELP.getCursor("drag"));
			}

			@Override
            public void mouseDragged(MouseEvent e) {
				setCursor(HELP.getCursor("drag"));
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
				setCursor(HELP.getCursor("palm"));
			}
		};

		addMouseListener(mouse);
		addMouseMotionListener(mouse);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		HELP.getSVG(fileName + ".svg").paintIcon(this, g, 0, 0);
	}

	public static Piece king(boolean white) {
		Piece king = new Piece(( white ? WHITE : BLACK ) + KING);
		king.moves = new KingMoves(king);
		return king;
	}

	public static Piece queen(boolean white) {
		Piece queen = new Piece(( white ? WHITE : BLACK ) + QUEEN);
		queen.moves = new QueenMoves(queen);
		return queen;
	}

	public static Piece bishop(boolean white) {
		Piece bishop = new Piece(( white ? WHITE : BLACK ) + BISHOP);
		bishop.moves = new BishopMoves(bishop);
		return bishop;
	}

	public static Piece rook(boolean white) {
		Piece rook = new Piece(( white ? WHITE : BLACK ) + ROOK);
		rook.moves = new RookMoves(rook);
		return rook;
	}

	public static Piece knight(boolean white) {
		Piece knight = new Piece(( white ? WHITE : BLACK ) + KNIGHT);
		knight.moves = new KnightMoves(knight);
		return knight;
	}

	public static Piece pawn(boolean white) {
		Piece pawn = new Piece(( white ? WHITE : BLACK ) + PAWN);
		pawn.moves = new PawnMoves(pawn);
		return pawn;
	}

	public boolean isKing() {
		return fileName.contains(KING);
	}

	public boolean isQueen() {
		return fileName.contains(QUEEN);
	}

	public boolean isBishop() {
		return fileName.contains(BISHOP);
	}

	public boolean isKnight() {
		return fileName.contains(KNIGHT);
	}

	public boolean isRook() {
		return fileName.contains(ROOK);
	}

	public boolean isPawn() {
		return fileName.contains(PAWN);
	}

	public boolean isWhite() {
		return fileName.contains(WHITE);
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

	public boolean hasMoved() {
		return moved;
	}

	public void setMoved(boolean moved) {
		this.moved = moved;
	}
}
