package lib;

import javax.swing.SwingUtilities;

public class Main implements Constants {

	public static void run() {
		SwingUtilities.invokeLater(() -> {
			board.initializeGrid();

			label.add(board);
			frame.add(label);

			board.setVisible(true);
			label.setVisible(true);
			frame.setVisible(true);
		});
	}
}