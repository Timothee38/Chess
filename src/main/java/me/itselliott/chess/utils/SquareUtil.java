package me.itselliott.chess.utils;

import me.itselliott.chess.Chess;
import me.itselliott.chess.game.Colour;
import me.itselliott.chess.game.board.Board;
import me.itselliott.chess.game.board.Square;
import me.itselliott.chess.piece.Piece;
import me.itselliott.chess.piece.pieces.King;

/**
 * Created by Elliott2 on 21-Apr-16.
 */
public class SquareUtil {

    public static Piece getPieceBySquare(Class<? extends  Piece> piece, Colour colour) {
        for (Square square : Chess.getInstance().getBoard()) {
            if (square.getPiece().getClass() == piece && square.getColour() == colour) return square.getPiece();
        }
        return null;
    }

}
