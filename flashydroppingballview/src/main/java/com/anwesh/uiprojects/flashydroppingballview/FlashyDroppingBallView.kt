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
