package lib;

import java.awt.Dimension;
import java.awt.Toolkit;

import window.Board;
import window.Frame;

public interface Constants {

	public static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int board_width = (Math.min(SCREEN_SIZE.width, SCREEN_SIZE.height) - 100) / 8 * 8;
	public static final Dimension BOARD_SIZE = new Dimension(board_width, board_width);
	public static final Dimension BOX = new Dimension(board_width / 8, board_width / 8);

	public static final Settings settings = new Settings();
	public static final Frame frame = new Frame();
	public static final Board board = new Board();
}
