package me.itselliott.chess.gui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;
import me.itselliott.chess.Chess;
import me.itselliott.chess.game.Colour;
import me.itselliott.chess.game.board.Square;

/**
 * Created by Elliott2 on 15-Apr-16.
 */
public class Window extends Application {

    public void open() {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Chess");
        primaryStage.setScene(new Scene(makeBoard()));
        primaryStage.show();
    }

    private Group makeBoard() {
        Group group = new Group();
        for (Square square : Chess.getInstance().getBoard()) {
            if (square.getColour().equals(Colour.BLACK)) square.getRectangle().setFill(Color.DARKGRAY);
            else if (square.getColour().equals(Colour.WHITE)) square.getRectangle().setFill(Color.GRAY);
            if (square.isOccupied()) square.getRectangle().setFill(new ImagePattern(new Image(square.getPiece().getIconLocation())));
            square.getRectangle().setOnMouseClicked(new MoveHandler(square.getRectangle(), square));
            group.getChildren().add(square.getRectangle());
        }
        return group;
    }

    public void moveIcon(Square from, Square to) {
        if (from.isOccupied()) {
            to.getRectangle().setFill(new ImagePattern(new Image(from.getPiece().getIconLocation())));
            from.getRectangle().setFill(from.getColour() == Colour.WHITE ? Color.GRAY : Color.DARKGRAY );
        }
    }

}
