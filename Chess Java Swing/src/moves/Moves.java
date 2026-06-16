package moves;

import java.util.LinkedList;

import lib.Constants;
import window.Piece;

public abstract class Moves implements Constants {

	protected LinkedList<Move> path;
	protected Piece piece;

	public Moves() {
		// TODO Auto-generated constructor stub
		path = new LinkedList<>();
	}

	public void calculateMoves() {}

	class Move {
		public int x, y;

		private boolean enPassant, castle;

		public boolean isEnPassant() {
			return enPassant;
		}

		public void setEnPassant(boolean enPassant) {
			this.enPassant = enPassant;
		}

		public boolean isCastle() {
			return castle;
		}

		public void setCastle(boolean castle) {
			this.castle = castle;
		}
	}
}
