package me.itselliott.chess.piece;

import javafx.scene.shape.Rectangle;
import me.itselliott.chess.game.board.Board;
import me.itselliott.chess.Chess;
import me.itselliott.chess.game.Colour;
import me.itselliott.chess.game.board.Square;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Elliott2 on 15-Apr-16.
 */
public abstract class Piece {

    protected Board board;
    private PieceState state;
    private Colour player;
    private Square square;
    private String iconLocation;

    protected int x;
    protected int y;

    public Piece(Colour player, PieceState state, int x, int y, String iconLocation) {
        this.board = Chess.getInstance().getBoard();
        this.state = state;
        this.player = player;
        this.x = x;
        this.y = y;
        this.square = this.board.getSquare(this.x, this.y);
        this.iconLocation = iconLocation;
    }

    public PieceState getState() {
        return this.state;
    }

    public Colour getPlayer() {
        return this.player;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Square getSquare() {
        return this.square;
    }

    public String getIconLocation() {
        return this.iconLocation;
    }

    public Set<Square> getMoves() {
        return this.board.getSquares().stream().filter(square -> this.canMove(square.getX(), square.getY()) && this.board.getSquare(square.getX(),square.getY()) != this.square).collect(Collectors.toSet());
    }

    public void move(int x, int y) {
        if (this.canMove(x, y) && this.board.getSquare(x, y) != this.square) {
            this.board.setSquare(this, x, y);
            Chess.getInstance().getWindow().moveIcon(this.square, this.board.getSquare(x,y));
            this.board.getSquare(this.x, this.y).setOccupied(false);
            this.x = x;
            this.y = y;
            this.square = this.board.getSquare(this.x, this.y);
        }
    }

    public abstract boolean canMove(int x, int y);

}
