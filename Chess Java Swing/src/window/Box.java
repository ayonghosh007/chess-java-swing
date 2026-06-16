package window;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import lib.Constants;

public class Box extends JLabel implements Constants {

	/**
	 *
	 */
	private static final long serialVersionUID = -9049289875180972315L;

	private Piece piece;

	private int x, y;

	private boolean rev;

	private Cods letters, numbers;

	private Movable movable;

	public Box(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		rev = false;
		piece = null;

		setSize(BOX_SIZE);
		setLocation(BOX_SIZE.width * x, BOARD_SIZE.height - BOX_SIZE.width * (y + 1));
		setOpaque(false);
		setLayout(null);

		letters = new Cods(false);
		numbers = new Cods(true);

		add(letters);
		add(numbers);

		letters.reorder();
		numbers.reorder();

		movable = new Movable();

		add(movable);

		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mousePressed(e);
			}
		});
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g.create();

		g2d.setColor((x + y) % 2 == 0? settings.lightColor() : settings.darkColor());
        g2d.fillRect(0, 0, getWidth(), getHeight());

        g2d.dispose();
	}

	public void reverse() {
		rev = !rev;

		if(rev) {
			setLocation(BOX_SIZE.width * x, BOARD_SIZE.height - BOX_SIZE.width * (7 - y + 1));
		}
		else {
			setLocation(BOX_SIZE.width * x, BOARD_SIZE.height - BOX_SIZE.width * (y + 1));
		}

		repaint();
		letters.reorder();
		numbers.reorder();
	}

	public Piece addPiece(Piece piece) {
		if(this.piece != null)
			removePiece();

		this.piece = piece;

		add(piece);
		setComponentZOrder(piece, 0);

		piece.setx(x);
		piece.sety(y);
		piece.setLocation((BOX_SIZE.width - PIECE_SIZE.width) / 2, (BOX_SIZE.height - PIECE_SIZE.height) / 2);

		return piece;
	}

	public Piece getPiece() {
		return piece;
	}

	public Piece removePiece() {
		Piece piece = getPiece();
		remove(piece);

		piece.setx(-1);
		piece.sety(-1);

		this.piece = null;
		return piece;
	}

	public int getx() {
		return x;
	}

	public int gety() {
		return y;
	}

	public void setMovable(boolean mov) {
		movable.setVisible(mov);
		movable.repaint();
	}

	class Cods extends JLabel {

		/**
		 *
		 */
		private static final long serialVersionUID = -1231059846265787257L;

		private boolean up;

		public Cods(boolean up) {
			// TODO Auto-generated constructor stub
			this.up = up;

			setOpaque(false);
			setSize(BOX_SIZE.width / 5, BOX_SIZE.height / 5);
			setHorizontalAlignment(CENTER);
			setVerticalAlignment(CENTER);
			setFont(new Font("Arial", Font.PLAIN, getWidth() * 2 / 3 + 6));
			setForeground(HELP.getRGBOf((x + y) % 2 == 1?
						settings.lightColor() :
						settings.darkColor()));

			if(up) {
				setText(y + 1 + "");
				setLocation(0, 0);
			}
			else {
				setText((char)(x + 'a') + "");
				setLocation(BOX_SIZE.width - getWidth(), BOX_SIZE.height - getHeight());
			}
		}

		public void reorder() {
			if(up) {
				if(x == 0) {
					setVisible(true);
				}
				else {
					setVisible(false);
				}
			}
			else {
				setVisible(false);
				if(y == 7)
					setVisible(rev);
				if(y == 0)
					setVisible(!rev);
			}

			repaint();
		}
	}

	class Movable extends JLabel {

		/**
		 *
		 */
		private static final long serialVersionUID = 7755595915163179905L;

		public Movable() {
			// TODO Auto-generated constructor stub
			setVisible(false);
			setSize(BOX_SIZE);
			setLocation(0, 0);
			setOpaque(false);
			setLayout(null);
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			Graphics2D g2d = (Graphics2D) g.create();
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			g2d.setColor(new Color(25, 25, 25, 100));

			if(piece == null) {
				int diameter = getWidth() / 3;

				g2d.fillOval((getWidth() - diameter) / 2, (getHeight() - diameter) / 2, diameter, diameter);
			}
			else {
				int stroke = getWidth() / 10;
				int diameter = getWidth() - stroke;

				g2d.setStroke(new BasicStroke(stroke));
				g2d.drawOval((getWidth() - diameter) / 2, (getHeight() - diameter) / 2, diameter, diameter);
			}

	        g2d.dispose();
		}
	}
}
