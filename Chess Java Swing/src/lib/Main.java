package lib;

public class Main implements Constants {

	public static void run() {
		board.initializeGrid();
		frame.add(board);

		board.setVisible(true);
		frame.setVisible(true);
	}

}
