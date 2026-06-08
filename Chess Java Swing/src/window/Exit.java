package window;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;

import lib.Constants;

public class Exit extends JDialog implements Constants {

	/**
	 *
	 */
	private static final long serialVersionUID = 3218697640120888149L;

	private JButton yes, no;

	private boolean active;

	public Exit() {
		setActive(false);
		setSize(SCREEN_SIZE.width*2/5, SCREEN_SIZE.height/3);
		setLocation((SCREEN_SIZE.width - getWidth())/2, (SCREEN_SIZE.height - getHeight())/2);
		setUndecorated(true);
		setLayout(null);

		yes = new JButton("YES");
		yes.setSize(getWidth()/4, getHeight()/4);
		yes.setLocation(getWidth()/8, getHeight()*3/5);
		yes.setBackground(Color.LIGHT_GRAY.brighter());
		yes.setForeground(Color.BLACK);
		yes.setFocusable(false);
		yes.setFont(new Font("Calibri", Font.BOLD, 40));
		yes.setVerticalAlignment(JButton.CENTER);
		yes.addActionListener(e -> System.exit(0));

		add(yes);

		no = new JButton("NO");
		no.setSize(getWidth()/4, getHeight()/4);
		no.setLocation(getWidth()*5/8, getHeight()*3/5);
		no.setBackground(Color.LIGHT_GRAY.brighter());
		no.setForeground(Color.BLACK);
		no.setFocusable(false);
		no.setFont(new Font("Calibri", Font.BOLD, 40));
		no.setVerticalAlignment(JButton.CENTER);
		no.addActionListener(e -> {
			setActive(false);
			frame.setEnabled(true);
			frame.requestFocus();
			frame.toFront();
		});

		add(no);
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
		setVisible(active);
	}
}
