package me.itselliott.chess;

import me.itselliott.chess.game.GameHandler;
import me.itselliott.chess.game.board.Board;
import me.itselliott.chess.game.Colour;
import me.itselliott.chess.gui.Window;
import me.itselliott.chess.piece.Piece;
import me.itselliott.chess.piece.PieceIcon;
import me.itselliott.chess.piece.PieceState;
import me.itselliott.chess.piece.pieces.King;
import me.itselliott.chess.piece.pieces.Pawn;
import me.itselliott.chess.piece.pieces.Queen;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elliott2 on 15-Apr-16.
 */
public class Chess {

    private static Chess instance;

    private Board board;
    private Window window;
    private List<Piece> pices;
    private GameHandler gameHandler;

    public Chess() {
        instance = this;
        this. board = new Board();
        this.window = new Window();
        this.pices = new ArrayList<>();
        this.gameHandler = new GameHandler();
    }

    public static Chess getInstance() {
        return instance;
    }

    public Board getBoard() {
        return this.board;
    }

    public Window getWindow() {
        return window;
    }

    public List<Piece> getPices() {
        return pices;
    }

    public GameHandler getGameHandler() {
        return this.gameHandler;
    }

    public static void main(String[] args) {
        new Chess();

        getInstance().getBoard().setSquare(new Pawn(Colour.WHITE, PieceState.PLAYING, 0, 0, PieceIcon.PAWN_WHITE.getLocation()), 0, 0);
        getInstance().getBoard().setSquare(new King(Colour.BLACK, PieceState.PLAYING, 6, 4, PieceIcon.KING_BLACK.getLocation()), 6, 4);
        getInstance().getBoard().setSquare(new Queen(Colour.BLACK, PieceState.PLAYING, 3, 5, PieceIcon.QUEEN_BLACK.getLocation()), 3, 5);

        getInstance().getGameHandler().play();
       /* System.out.println("-----------");
        getInstance().getBoard().getSquare(0,0).getPiece().getMoves().forEach(System.out::println);
        System.out.println("-----------");
        getInstance().getBoard().getSquare(6,4).getPiece().getMoves().forEach(System.out::println);*/

    }

}
