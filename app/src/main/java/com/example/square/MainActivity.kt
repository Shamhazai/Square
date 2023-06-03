package com.example.square

import android.content.Context
import android.graphics.Canvas
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    private lateinit var square: SquareView
    private lateinit var startButton: Button
    private var currentColorIndex = 0
    private val colors = arrayOf(Color.BLUE, Color.RED, Color.YELLOW)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val square: SquareView = findViewById(R.id.squareView)
        val startButton: Button = findViewById(R.id.start_button)

        square.setBackgroundColor(colors[currentColorIndex])

        startButton.setOnClickListener {
            currentColorIndex = (currentColorIndex + 1) % colors.size
            square.setBackgroundColor(colors[currentColorIndex])
        }
    }
}

class SquareView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private var squareColor: Int = Color.BLUE

    override fun setBackgroundColor(color: Int) {
        squareColor = color
        invalidate() // Redraw the view
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val paint = Paint()
        paint.color = squareColor
        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), paint)
    }
}
