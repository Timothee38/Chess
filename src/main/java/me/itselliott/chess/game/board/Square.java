package me.itselliott.chess.game.board;

import javafx.scene.shape.Rectangle;
import me.itselliott.chess.game.Colour;
import me.itselliott.chess.piece.Piece;

/**
 * Created by Elliott2 on 15-Apr-16.
 */
public class Square {

    private final int x;
    private final int y;
    private boolean occupied;
    private Piece piece;
    private Rectangle rectangle;
    private Colour colour;

    public Square(int x, int y, boolean occupied, Piece piece, Colour colour) {
        this.x = x;
        this.y = y;
        this.occupied = occupied;
        this.piece = piece;
        this.rectangle = new Rectangle(45, 45);
        this.rectangle.setX(this.x * 45);
        this.rectangle.setY(this.y * 45);
    }

    public Square(int x, int y, Colour colour) {
        this(x, y, false, null, colour);
    }

    public int getY() {
        return this.y;
    }

    public int getX() {
        return this.x;
    }

    public boolean isOccupied() {
        return this.occupied;
    }

    public Piece getPiece() {
        return this.piece;
    }

    public Rectangle getRectangle() {
        return this.rectangle;
    }

    public Colour getColour() {
        return this.colour;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    @Override
    public String toString() {
        return "[SQUARE: " +  (this.piece != null ? this.piece.toString() : "empty") + ": @:x=" + this.x + ",y=" + this.y + "]";
    }
}
