package moves;

import window.Piece;

public class GameNotes {

	class Note {
		public Piece currentPiece, capturedPiece;
		public int iniRow, iniCol, finRow, finCol;
		public boolean enPassant, castle, upgrade;
	}
}
