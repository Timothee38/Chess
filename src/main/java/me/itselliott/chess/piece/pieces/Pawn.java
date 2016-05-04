package me.itselliott.chess.piece.pieces;

import me.itselliott.chess.game.Colour;
import me.itselliott.chess.piece.Piece;
import me.itselliott.chess.piece.PieceState;
import me.itselliott.chess.piece.Promotable;

/**
 * Created by Elliott2 on 15-Apr-16.
 */
public class Pawn extends Piece implements Promotable {

    private int moves = 0;

    public Pawn(Colour owner, PieceState state, int x, int y, String iconPath) {
        super(owner, state, x, y, iconPath);
    }

    @Override
    public boolean canMove(int x, int y) {
        return (this.moves < 1 && (this.x == x && y - this.y > 0 && y - this.y <= 2)) || (this.moves >= 1 && (this.x == x && y - this.y == 1));
    }

    @Override
    public void move(int x, int y) {
        super.move(x,y);
        this.moves++;
    }

    @Override
    public String toString() {
        return "Pawn";
    }
}
