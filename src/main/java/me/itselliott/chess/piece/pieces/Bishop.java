package me.itselliott.chess.piece.pieces;

import me.itselliott.chess.game.Colour;
import me.itselliott.chess.piece.Piece;
import me.itselliott.chess.piece.PieceState;

/**
 * Created by Elliott2 on 04-May-16.
 */
public class Bishop extends Piece {

    public Bishop(Colour owner, PieceState state, int x, int y, String iconPath) {
        super(owner, state, x, y, iconPath);
    }

    @Override
    public boolean canMove(int x, int y) {
        return false;
    }

    @Override
    public String toString() {
        return "Bishop";
    }
}
