package me.itselliott.chess.game.board;

import javafx.scene.shape.Rectangle;
import me.itselliott.chess.game.Colour;
import me.itselliott.chess.piece.Piece;

import java.util.*;

/**
 * Created by Elliott2 on 15-Apr-16.
 */
public class Board implements Iterable<Square> {

    private Square[][] squares = new Square[8][8];
    private HashMap<Rectangle, Square> rectangleMap = new HashMap<>();

    public Board() {
        boolean white = true;
        for (int y = 0; y < this.squares.length ; y++) {
            for (int x = 0; x < this.squares[y].length; x++) {
                Square square = new Square(x, y, white ? Colour.WHITE : Colour.BLACK);
                this.squares[y][x] = square;
                this.rectangleMap.put(square.getRectangle(), square);
                white = !white;
            }
            white = !white;
        }
    }

    public List<Square> getSquares() {
        List<Square> squares = new ArrayList<Square>();
        for (Square[] square : this.squares) {
            Collections.addAll(squares, square);
        }
        return squares;
    }

    public Square getSquare(int x, int y) {
        return this.squares[y][x];
    }

    public void setSquare(Piece piece, int x, int y) {
        if (!this.getSquare(x, y).isOccupied()) {
            this.squares[y][x].setPiece(piece);
            this.squares[y][x].setOccupied(true);
        }
    }

    public HashMap<Rectangle, Square> getRectangleMap() {
        return this.rectangleMap;
    }

    public Square getSquareByRectangle(Rectangle rectangle) {
        return this.rectangleMap.get(rectangle);
    }

    @Override
    public Iterator<Square> iterator() {
        return this.getSquares().iterator();
    }
}
