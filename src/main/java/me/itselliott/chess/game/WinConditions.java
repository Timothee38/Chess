package me.itselliott.chess.game;

import me.itselliott.chess.Chess;
import me.itselliott.chess.game.board.Board;
import me.itselliott.chess.game.board.Square;
import me.itselliott.chess.piece.pieces.King;
import me.itselliott.chess.utils.SquareUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Elliott2 on 09-May-16.
 */
public class WinConditions {

    private GameHandler gameHandler;
    private Board board;

    public WinConditions(GameHandler gameHandler) {
        this.gameHandler = gameHandler;
        Chess.getInstance().getBoard();
    }

    public boolean checkWinCondition() {
        Set<Square> occupiedWhiteMoves = new HashSet<>();
        Set<Square> occupiedBlackMoves = new HashSet<>();
        for (Square square : this.board) {
            if (square.isOccupied()) {
                if (square.getColour() == Colour.WHITE) occupiedWhiteMoves.addAll(square.getPiece().getMoves());
                if (square.getColour() == Colour.BLACK) occupiedBlackMoves.addAll(square.getPiece().getMoves());
            }
        }
        return occupiedWhiteMoves.containsAll(SquareUtil.getPieceBySquare(King.class, Colour.WHITE).getMoves()) || occupiedBlackMoves.containsAll(SquareUtil.getPieceBySquare(King.class, Colour.BLACK).getMoves());
    }

}
