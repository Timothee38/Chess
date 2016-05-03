package me.itselliott.chess.game;

import me.itselliott.chess.Chess;
import me.itselliott.chess.game.board.Square;
import me.itselliott.chess.piece.Piece;
import org.apache.commons.lang3.time.StopWatch;

/**
 * Created by Elliott2 on 16-Apr-16.
 */
public class GameHandler {

    private boolean playing;
    private Colour turn;
    private StopWatch stopWatch;
    private GameState gameState;
    private Square activeSquare;

    public GameHandler() {
        this.turn = Colour.WHITE;
        this.stopWatch = new StopWatch();
        this.playing = false;
        this.gameState = GameState.NONE;
        this.activeSquare = null;
    }

    public void play() {
        this.stopWatch.start();
        this.playing = true;
        this.gameState = GameState.PLAYING;
        Chess.getInstance().getWindow().open();
    }

    public void stop() {
        this.stopWatch.stop();
        this.playing = false;
        this.gameState =  GameState.NONE;
    }

    public boolean isPlaying() {
        return this.playing;
    }

    public Colour getCurrentTurn() {
        return this.turn;
    }

    public Square getActiveSquare() {
        return this.activeSquare;
    }

    public void setActiveSquare(Square activeSquare) {
        this.activeSquare = activeSquare;
    }

    public StopWatch getStopWatch() {
        return this.stopWatch;
    }

    public long getTime() {
        return this.stopWatch.getTime();
    }

    public GameState getGameState() {
        return this.gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void setTurn(Colour turn) {
        this.turn = turn;
    }
}
