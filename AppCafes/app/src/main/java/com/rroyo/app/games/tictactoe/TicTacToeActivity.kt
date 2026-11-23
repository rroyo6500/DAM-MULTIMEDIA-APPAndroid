package com.rroyo.app.games.tictactoe

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.slider.Slider
import com.rroyo.app.games.tictactoe.game_core.GameConstants
import com.rroyo.app.games.tictactoe.game_core.ai.AI
import com.rroyo.app.games.tictactoe.game_core.enums.GameDificulties
import com.rroyo.app.games.tictactoe.game_core.objects.Point
import com.rroyo.app.games.tictactoe.game_core.utils.Util
import com.rroyo.appcafes.R

class TicTacToeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tic_tac_toe)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initComponents()

    }

    fun getButton(point: Point) : Button? {
        val pos = "${point.y}|${point.x}"

        val btn = when (pos) {
            "0|0" -> findViewById<Button>(R.id.btn_00)
            "0|1" -> findViewById<Button>(R.id.btn_01)
            "0|2" -> findViewById<Button>(R.id.btn_02)
            "1|0" -> findViewById<Button>(R.id.btn_10)
            "1|1" -> findViewById<Button>(R.id.btn_11)
            "1|2" -> findViewById<Button>(R.id.btn_12)
            "2|0" -> findViewById<Button>(R.id.btn_20)
            "2|1" -> findViewById<Button>(R.id.btn_21)
            "2|2" -> findViewById<Button>(R.id.btn_22)
            else -> null
        }
        return btn
    }

    fun resetButtons() {
        for (y in 0..<3) {
            for (x in 0..<3) {
                val btn = getButton(Point(x, y))
                val btnid = "$y|$x"
                btn?.text = btnid
                btn?.setTextColor(Color.argb(0, 0, 0 ,0))
                btn?.isActivated = true
            }
        }
    }

    fun updateBoard() {
        var x = 0;
        val row = null
        val col = null
        for ((y, row) in GameConstants.board.board.withIndex()) {
            for (col in row) {
                val btn = getButton(Point(x, y))
                btn?.text = "$col"
                x++
            }
        }

    }

    fun initComponents() {
        initDifficultySpinner()
        initButtons()
    }

    fun initButtons() {
        val onClickListener : View.OnClickListener = View.OnClickListener { v ->
            val board = GameConstants.board
            if (Util.haveMovements(board) && !GameConstants.win) {
                val btn = findViewById<Button>(v?.id!!)
                if (btn.text.toString().contains("|")) {
                    val btnPosition : List<String> = btn.text.toString().split("|").toList()
                    val point = Point(btnPosition[1].toInt(), btnPosition[0].toInt())

                    if (board.getPos(point.x, point.y) == board.base) {
                        board.setPos(point.x, point.y, 'X')
                        btn.text = "X"
                        btn.setTextColor(Color.BLACK)
                        btn.isActivated = false

                        if (Util.compVictory(board, 'X')) {
                            GameConstants.win = true
                            Toast.makeText(this, "Ha ganado 'X", Toast.LENGTH_SHORT).show()
                            return@OnClickListener
                        }

                        if (Util.haveMovements(board)) {
                            val aiPoint : Point? = AI.start(board)
                            if (aiPoint != null) {
                                val aiBtn = getButton(aiPoint)
                                aiBtn?.text = "O"
                                aiBtn?.setTextColor(Color.BLACK)
                                aiBtn?.isActivated = false
                            }
                        }

                        if (Util.compVictory(board, 'O')) {
                            GameConstants.win = true
                            Toast.makeText(this, "Ha ganado 'O", Toast.LENGTH_SHORT).show()
                        } else if (!Util.haveMovements(board)) {
                            Toast.makeText(this, "Empate", Toast.LENGTH_SHORT).show()
                        }

                    }
                }
            }
        }

        findViewById<Button>(R.id.btn_00).setOnClickListener(onClickListener)
        findViewById<Button>(R.id.btn_01).setOnClickListener(onClickListener)
        findViewById<Button>(R.id.btn_02).setOnClickListener(onClickListener)
        findViewById<Button>(R.id.btn_10).setOnClickListener(onClickListener)
        findViewById<Button>(R.id.btn_11).setOnClickListener(onClickListener)
        findViewById<Button>(R.id.btn_12).setOnClickListener(onClickListener)
        findViewById<Button>(R.id.btn_20).setOnClickListener(onClickListener)
        findViewById<Button>(R.id.btn_21).setOnClickListener(onClickListener)
        findViewById<Button>(R.id.btn_22).setOnClickListener(onClickListener)

        findViewById<Button>(R.id.btnRestart).setOnClickListener {
            resetButtons()
            GameConstants.board.clear()
            GameConstants.win = false
        }
    }

    fun initDifficultySpinner() {
        findViewById<Spinner>(R.id.difficulty).onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedDificulty = parent?.getItemAtPosition(position).toString()

                resetButtons()
                GameConstants.board.clear()
                GameConstants.win = false

                when (selectedDificulty) {
                    "Fàcil" -> GameConstants.difficulty = GameDificulties.EASY
                    "Medio" -> GameConstants.difficulty = GameDificulties.MEDIUM
                    "Difícil" -> GameConstants.difficulty = GameDificulties.HARD
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // No hace nada
            }
        }
    }
}