package me.itselliott.chess.gui;

import javafx.event.EventHandler;
import javafx.scene.effect.BlendMode;
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
import me.itselliott.chess.utils.ColourUtil;


/**
 * Created by Elliott2 on 16-Apr-16.
 */
public class MoveHandler implements EventHandler<MouseEvent> {

    private Rectangle rectangle;
    private Square square;
    private GameHandler gameHandler;

    public MoveHandler(Rectangle rectangle, Square square) {
        this.rectangle = rectangle;
        this.square = square;
        this.gameHandler = Chess.getInstance().getGameHandler();
    }

    @Override
    public void handle(MouseEvent event) {
        if (event.getSource() == this.rectangle) {
            if (this.gameHandler.getGameState().equals(GameState.PLAYING)) {
                if (this.square.isOccupied()) {
                    this.gameHandler.setActiveSquare(this.square);
                    if (this.gameHandler.getActiveSquare().getPiece().getPlayer() == this.gameHandler.getCurrentTurn()) {
                        this.square.getPiece().getMoves().forEach(move ->  move.getRectangle().setFill(Color.rgb(75, 230, 255, 0.5)));
                        this.gameHandler.setGameState(GameState.WAITING);
                    }
                }
            } else if (this.gameHandler.getGameState().equals(GameState.WAITING)) {
                if (this.gameHandler.getActiveSquare().getPiece().getX() == this.square.getX() && this.gameHandler.getActiveSquare().getPiece().getY() == this.square.getY()) {
                    this.removeHighlightedSquares();
                } else if (this.gameHandler.getActiveSquare().getPiece().canMove(this.square.getX(), this.square.getY())) {
                    this.gameHandler.getActiveSquare().getPiece().getMoves().stream().filter(move -> !move.isOccupied()).forEach(move -> move.getRectangle().setFill(move.getColour() == Colour.WHITE ? Color.GRAY : Color.DARKGRAY));
                    this.gameHandler.getActiveSquare().getPiece().move(this.square.getX(), this.square.getY());
                    this.gameHandler.setTurn(ColourUtil.inverseCurrent());
                    this.removeHighlightedSquares();
                    System.out.println("Current Turn is now: " + this.gameHandler.getCurrentTurn().name());
                }
            }
        }
    }

    private void removeHighlightedSquares() {
        for (Square square : this.gameHandler.getActiveSquare().getPiece().getMoves()) {
            if (!square.isOccupied()) {
                square.getRectangle().setFill(square.getColour() == Colour.WHITE ? Color.GRAY : Color.DARKGRAY);
            } else {
                square.getRectangle().setFill(new ImagePattern(new Image(square.getPiece().getIconLocation())));
            }
        }
        this.gameHandler.setActiveSquare(null);
        this.gameHandler.setGameState(GameState.PLAYING);
    }
}


