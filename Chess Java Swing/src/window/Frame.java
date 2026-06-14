package window;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

import lib.Constants;

public class Frame extends JFrame implements Constants {

	/**
	 *
	 */
	private static final long serialVersionUID = 7929949333044430064L;

	public Frame() {
		setVisible(false);
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setUndecorated(true);
		setTitle("Chess\u24c7");
		setLayout(null);

		add(new Cross());
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frame.toFront();
				frame.requestFocus();
				exit.setActive(true);
				frame.setEnabled(false);
			}
		});
		addWindowFocusListener(new WindowAdapter() {

			@Override
			public void windowGainedFocus(WindowEvent e) {
				// TODO Auto-generated method stub
				if(exit.isActive()) {
					exit.setActive(false);
					exit.setActive(true);
					frame.setEnabled(false);
				}
			}
		});
	}

	public void paint(Graphics g) {
		super.paint(g);

		getContentPane().setBackground(settings.backColor());
	}

	class Cross extends JLabel{

		/**
		 *
		 */
		private static final long serialVersionUID = 2477248928589192268L;

		private Image  img;

		Cross() {
			setSize(SCREEN_SIZE.height/15, SCREEN_SIZE.height/15);
			setLocation(SCREEN_SIZE.width - SCREEN_SIZE.height/15, 0);
			setOpaque(false);
			setVisible(true);

			addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					img = HELP.getImage("exit.png");
					repaint();
				}

				@Override
				public void mouseExited(MouseEvent e) {
					img = null;
					repaint();
				}

				@Override
				public void mouseClicked(MouseEvent e) {
					exit.setActive(true);
					frame.setEnabled(false);
				}
			});
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.drawImage(img, getWidth() / 10, getHeight() / 10, getWidth() * 4 / 5, getHeight() * 4 / 5, this);
		}
	}
}
