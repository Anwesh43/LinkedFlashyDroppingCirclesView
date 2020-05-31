package com.anwesh.uiprojects.flashydroppingballview

/**
 * Created by anweshmishra on 31/05/20.
 */

import android.view.View
import android.view.MotionEvent
import android.app.Activity
import android.content.Context
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.Color

val nodes : Int = 5
val parts : Int = 5
val scGap : Float = 0.05f / parts
val strokeFactor : Int = 90
val sizeFactor : Float = 2.9f
val foreColor : Int = Color.parseColor("#4CAF50")
val backColor : Int = Color.parseColor("#BDBDBD")
val delay : Long = 20

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.sinify() : Float = Math.sin(this * Math.PI).toFloat()

fun Canvas.drawFlashyDroppingBall(scale : Float, size : Float, h : Float, paint : Paint) {
    var sk : Float = 1f
    for (j in 0..(parts - 2)) {
        var scj : Float = scale.divideScale(j, parts)
        if (scj <= 0f) {
            break
        }
        sk *= scj.sinify()
    }
    val scLast : Float = scale.divideScale(parts - 1, parts)
    drawCircle(0f, size + h * scLast, size * (1 - sk), paint)
}

fun Canvas.drawFDBNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    val gap : Float = w / (nodes + 1)
    val size : Float = gap / sizeFactor
    paint.color = foreColor
    save()
    translate(gap * i + 1, 0f)
    drawFlashyDroppingBall(scale, size, h, paint)
    restore()
}

class FlashyDroppingBallView(ctx : Context) : View(ctx) {

    override fun onDraw(canvas : Canvas) {

    }

    override fun onTouchEvent(event : MotionEvent) : Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {

            }
        }
        return true
    }
}