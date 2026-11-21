package com.rroyo.app.games.tictactoe

import android.os.Bundle
import android.os.Debug
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rroyo.app.games.tictactoe.game_core.GameConstants
import com.rroyo.app.games.tictactoe.game_core.enums.GameDificulties
import com.rroyo.app.games.tictactoe.game_core.objects.Point
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

    fun initComponents() {
        initDifficultySpinner()
        initButtons()
    }

    fun initButtons() {
        val onClickListener : View.OnClickListener = View.OnClickListener { v ->
            val btnPosition : List<String> = findViewById<Button>(v?.id!!).text.toString()
                .split("|").toList()
            val point = Point(btnPosition[1].toInt(), btnPosition[0].toInt())



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