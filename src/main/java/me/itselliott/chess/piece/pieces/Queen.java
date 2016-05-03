package me.itselliott.chess.piece.pieces;

import me.itselliott.chess.game.Colour;
import me.itselliott.chess.piece.Piece;
import me.itselliott.chess.piece.PieceState;

/**
 * Created by Elliott2 on 21-Apr-16.
 */
public class Queen extends Piece {

    public Queen(Colour owner, PieceState state, int x, int y, String iconPath) {
        super(owner, state, x, y, iconPath);
    }

    @Override
    public boolean canMove(int x, int y) {
        return (Math.abs(x - this.x) == Math.abs(y - this.y)) || (y - this.y == 0) || (x - this.x == 0);
    }

    @Override
    public String toString() {
        return "Queen";
    }
}
