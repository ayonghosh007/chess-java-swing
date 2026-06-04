package window;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

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

	public Box(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		rev = false;
		piece = null;

		setSize(BOX_SIZE);
		setLocation(BOX_SIZE.width * x, BOARD_SIZE.height - BOX_SIZE.width * (y + 1));
		setOpaque(false);

		letters = new Cods(false);
		numbers = new Cods(true);

		letters.repaint();
		numbers.repaint();

		add(letters);
		add(numbers);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g.create();

		g2d.setColor((x + y) % 2 == 0? settings.lightColor() : settings.darkColor());
        g2d.fillRect(0, 0, getWidth(), getHeight());

        g2d.dispose();
	}

	/*
	 * Come here when writing for 2 player mode
	 */
	public void reverse() {
		rev = !rev;
	}

	public Piece addPiece(Piece piece) {
		this.piece = piece;

		add(piece);
		setComponentZOrder(piece, 0);

		return piece;
	}

	public Piece getPiece() {
		return piece;
	}

	public Piece removePiece() {
		Piece piece = getPiece();
		remove(piece);


		this.piece = null;
		return piece;
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
			setFont(new Font("Arial", Font.PLAIN, 22));
			setForeground(new Color((x + y) % 2 == 1?
						settings.lightColor().getRGB() & 0x00ffffff :
						settings.darkColor().getRGB() & 0x00ffffff));

			if(up) {
				setText(y + 1 + "");
				setLocation(0, 0);
			}
			else {
				setText((char)(x + 'a') + "");
				setLocation(BOX_SIZE.width - getWidth(), BOX_SIZE.height - getHeight());
			}
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);

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
		}
	}
}
