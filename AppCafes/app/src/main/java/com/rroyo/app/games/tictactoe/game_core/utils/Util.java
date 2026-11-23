package com.rroyo.app.games.tictactoe.game_core.utils;

import com.rroyo.app.games.tictactoe.game_core.objects.Board;


public class Util {

    /**
     * Determines if the specified player has achieved a winning condition on the board.
     * A winning condition is satisfied if the player has a complete row, column,
     * or diagonal filled with their symbol.
     *
     * @param b The game board to evaluate.
     * @param player The character representing the player's symbol.
     * @return true if the player has a winning condition; false otherwise.
     */
    public static boolean compVictory(Board b, char player) {
        for (int i = 0; i < b.height; i++)
            if (b.getPos(i, 0) == player &&
                    b.getPos(i, 1) == player &&
                    b.getPos(i, 2) == player
            ) return true;

        for (int i = 0; i < b.width; i++)
            if (b.getPos(0, i) == player &&
                    b.getPos(1, i) == player &&
                    b.getPos(2, i) == player
            ) return true;

        return (
                (b.getPos(0,0) == player &&
                        b.getPos(1,1) == player &&
                        b.getPos(2,2) == player) ||
                        (b.getPos(0,2) == player &&
                                b.getPos(1,1) == player &&
                                b.getPos(2,0) == player)
        );
    }

    /**
     * Determines if there are any possible movements left on the board.
     * A movement is considered possible if there is at least one position
     * with the default base character.
     *
     * @param b The game board to check for possible movements.
     * @return true if there is at least one position with the base character; false otherwise.
     */
    public static boolean haveMovements(Board b) {
        if (b == null) return false;

        for (int y = 0; y < b.height; y++) {
            for (int x = 0; x < b.width; x++) {
                if (b.getPos(x, y) == b.base) return true;
            }
        }
        return false;
    }

}
