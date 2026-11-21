package com.rroyo.app.games.tictactoe.game_core

import com.rroyo.app.games.tictactoe.game_core.enums.GameDificulties
import com.rroyo.app.games.tictactoe.game_core.objects.Board

class GameConstants {

    companion object {
        var difficulty : GameDificulties = GameDificulties.EASY

        val board : Board = Board(3, 3, ' ')
    }

}