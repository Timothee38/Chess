package me.itselliott.chess.utils;

import me.itselliott.chess.Chess;
import me.itselliott.chess.game.Colour;

/**
 * Created by Elliott2 on 04-May-16.
 */
public class ColourUtil {

    public static Colour inverseCurrent() {
         if (Chess.getInstance().getGameHandler().getCurrentTurn() == Colour.BLACK) return Colour.WHITE;
         return Colour.BLACK;
    }

}
