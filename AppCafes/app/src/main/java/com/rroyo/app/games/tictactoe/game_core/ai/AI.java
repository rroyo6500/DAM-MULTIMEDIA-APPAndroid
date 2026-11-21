package com.rroyo.app.games.tictactoe.game_core.ai;

import com.rroyo.app.games.tictactoe.game_core.objects.Board;
import com.rroyo.app.games.tictactoe.game_core.objects.Point;
import com.rroyo.app.games.tictactoe.game_core.utils.Util;

public class AI {

    /*
    Hecho principalmente con IA
    (No soy capaz de hacer esto por mi cuenta sin ayuda o sin tirarme 2 semanas seguidas sin hacer nada más .-.)

      - Chat: https://chatgpt.com/share/69990ad1-f4a0-8001-8b20-0b5586fabe57

     */

    private static final char IA = 'O';
    private static final char HUMANO = 'X';

    public static Point calculateMovement(Board board) {
        int mejorValor = Integer.MIN_VALUE;
        int[] movement = new int[]{-1, -1};

        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (board.getPos(x, y) == board.base) {
                    board.setPos(x, y, IA);

                    int valor = minimax(board, 0, false,
                            Integer.MIN_VALUE, Integer.MAX_VALUE);

                    board.setPos(x, y, board.base);

                    if (valor > mejorValor) {
                        mejorValor = valor;
                        movement[0] = x;
                        movement[1] = y;
                    }
                }
            }
        }
        return new Point(movement[0], movement[1]);
    }

    private static int minimax(Board board, int profundidad,
                               boolean esMax, int alpha, int beta) {

        if (Util.compViscory(board, IA))
            return 10 - profundidad;
        if (Util.compViscory(board, HUMANO))
            return profundidad - 10;
        if (!Util.haveMovements(board))
            return 0;

        if (esMax) {
            int mejor = Integer.MIN_VALUE;

            for (int y = 0; y < 3; y++) {
                for (int x = 0; x < 3; x++) {
                    if (board.getPos(x, y) == board.base) {
                        board.setPos(x, y, IA);

                        mejor = Math.max(mejor,
                                minimax(board, profundidad + 1,
                                        false, alpha, beta));

                        board.setPos(x, y, board.base);

                        alpha = Math.max(alpha, mejor);
                        if (beta <= alpha)
                            return mejor;
                    }
                }
            }
            return mejor;
        } else {
            int mejor = Integer.MAX_VALUE;

            for (int y = 0; y < 3; y++) {
                for (int x = 0; x < 3; x++) {
                    if (board.getPos(x, y) == board.base) {
                        board.setPos(x, y, HUMANO);

                        mejor = Math.min(mejor,
                                minimax(board, profundidad + 1,
                                        true, alpha, beta));

                        board.setPos(x, y, board.base);

                        beta = Math.min(beta, mejor);
                        if (beta <= alpha)
                            return mejor;
                    }
                }
            }
            return mejor;
        }
    }

}
