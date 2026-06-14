package lib;

import java.awt.Dimension;
import java.awt.Toolkit;

import window.Board;
import window.Box;
import window.Exit;
import window.Frame;
import window.Label;

public interface Constants {

	public static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int board_width = (Math.min(SCREEN_SIZE.width, SCREEN_SIZE.height) * 9 / 10) / 8 * 8;
	public static final Dimension BOARD_SIZE = new Dimension(board_width, board_width);
	public static final Dimension BOX_SIZE = new Dimension(board_width / 8, board_width / 8);
	public static final Dimension PIECE_SIZE = new Dimension(BOX_SIZE.width * 9 / 10, BOX_SIZE.height * 9 / 10);

	public static final Help HELP = new Help();

	public static final Exit exit = new Exit();
	public static final Settings settings = new Settings();
	public static final Frame frame = new Frame();
	public static final Label label = new Label();
	public static final Board board = new Board();
	public static final Box[][] grid = new Box[8][8];
}
