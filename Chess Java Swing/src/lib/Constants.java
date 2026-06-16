package lib;

import java.awt.Dimension;
import java.awt.Toolkit;

import window.Board;
import window.Box;
import window.Exit;
import window.Frame;
import window.Label;
import window.Piece;

public interface Constants {

	public static final int K = 0;
	public static final int Q = 1;
	public static final int B1 = 2;
	public static final int B2 = 3;
	public static final int N1 = 4;
	public static final int N2 = 5;
	public static final int R1 = 6;
	public static final int R2 = 7;

	public static final int W = 0;
	public static final int B = 1;

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
	public static final Piece[][] pieces = new Piece[2][16];
}
