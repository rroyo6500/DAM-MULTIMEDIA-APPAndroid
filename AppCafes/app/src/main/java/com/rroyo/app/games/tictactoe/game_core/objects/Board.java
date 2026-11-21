package com.rroyo.app.games.tictactoe.game_core.objects;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final List<List<Character>> board = new ArrayList<>();
    public final char base;

    public final int width;
    public final int height;

    public Board (int width, int height, char base) {
        this.base = base;
        this.width = width;
        this.height = height;
        for(int i = 0; i < height; i++){
            board.add(new ArrayList<>());
            for(int j = 0; j < width; j++){
                board.get(board.size()-1).add(base);
            }
        }
    }

    public Board(Board other) {
        this.base = other.base;
        this.width = other.width;
        this.height = other.height;

        for (int y = 0; y < height; y++) {
            List<Character> row = new ArrayList<>(width);
            for (int x = 0; x < width; x++) {
                row.add(other.getPos(x, y));
            }
            board.add(row);
        }
    }

    /**
     * Permite modificar una posicion especifica del tablero
     *
     * @param x Coordenada x de la posicion
     * @param y Coordenada y de la posicion
     * @param newValue Nuevo valor para la posicion
     */
    public void setPos (int x, int y, char newValue) {
        if (x < 0 || x >= width || y < 0 || y >= height) return;
        board.get(y).set(x, newValue);
    }

    /**
     * Devuelve el valor de la posicion especificada
     *
     * @param x Coordenada x de la posicion
     * @param y Coordenada y de la posicion
     * @return Valor de la posicion especificada
     */
    public char getPos (int x, int y){
        if (x < 0 || x >= width || y < 0 || y >= height) return base;
        return board.get(y).get(x);
    }

    /**
     * Liempia el tablero completo
     */
    public void clear () {
        board.clear();
    }

    /**
     * Devuelve el tablero como una Lista / ArrayList
     * @return Contenido del tablero como una Lista / ArrayList
     */
    public List<List<Character>> getBoard () {
        return new Board(this).board;
    }

    /**
     * Dibuja el contenido del tablero en consola
     */
    public void print () {
        for (List<Character> ts : board) {
            System.out.println(ts);
        }
    }

}
