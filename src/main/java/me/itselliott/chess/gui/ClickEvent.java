package me.itselliott.chess.gui;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import me.itselliott.chess.Chess;
import me.itselliott.chess.game.Colour;
import me.itselliott.chess.game.GameHandler;
import me.itselliott.chess.game.GameState;
import me.itselliott.chess.game.board.Square;
import me.itselliott.chess.piece.Piece;


/**
 * Created by Elliott2 on 16-Apr-16.
 */
public class ClickEvent implements EventHandler<MouseEvent> {

    private Rectangle rectangle;
    private Square square;
    private GameHandler gameHandler;

    public ClickEvent(Rectangle rectangle, Square square) {
        this.rectangle = rectangle;
        this.square = square;
        this.gameHandler = Chess.getInstance().getGameHandler();
    }

    @Override
    public void handle(MouseEvent event) {
        if (event.getSource() == this.rectangle) {
            if (this.gameHandler.getGameState().equals(GameState.PLAYING)) {
                if (this.square.isOccupied()) {
                    this.square.getPiece().getMoves().forEach(move -> move.getRectangle().setFill(Color.AQUA));
                    this.gameHandler.setGameState(GameState.WAITING);
                    this.gameHandler.setActiveSquare(this.square);
                }
            } else if (this.gameHandler.getGameState().equals(GameState.WAITING)) {
                if (this.gameHandler.getActiveSquare().getPiece().canMove(this.square.getX(), this.square.getY())) {
                    this.gameHandler.getActiveSquare().getPiece().getMoves().stream().filter(move -> !move.isOccupied()).forEach(move -> move.getRectangle().setFill(move.getColour() == Colour.WHITE ? Color.GRAY : Color.DARKGRAY));
                    for (Square move : this.gameHandler.getActiveSquare().getPiece().getMoves()) {
                        if (!move.isOccupied()) {
                            move.getRectangle().setFill(move.getColour() == Colour.WHITE ? Color.GRAY : Color.DARKGRAY);
                        } else {
                            move.getRectangle().setFill(new ImagePattern(new Image(move.getPiece().getIconLocation())));
                        }
                    }
                    this.gameHandler.getActiveSquare().getPiece().move(this.square.getX(), this.square.getY());
                    this.gameHandler.setGameState(GameState.PLAYING);
                    this.gameHandler.setActiveSquare(null);
                }
            }
        }
    }
}


