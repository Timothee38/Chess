package me.itselliott.chess.piece.pieces;

import me.itselliott.chess.game.Colour;
import me.itselliott.chess.game.board.Square;
import me.itselliott.chess.piece.Piece;
import me.itselliott.chess.piece.PieceState;

/**
 * Created by Elliott2 on 15-Apr-16.
 */
public class King extends Piece {

    public King(Colour owner, PieceState state, int x, int y, String iconPath) {
        super(owner, state, x, y, iconPath);
    }

    @Override
    public boolean canMove(int x, int y) {
        return (Math.abs(x - this.x) == Math.abs(y - this.y) && Math.abs(x - this.x) == 1 && Math.abs(y - this.y) == 1) || (y - this.y == 0 && Math.abs(x - this.x) == 1) || (x - this.x == 0 && Math.abs(y - this.y) == 1);
    }

    @Override
    public String toString() {
        return "King";
    }
}
