package com.guzzardo.jj3tictactoe

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.geometry.Rect
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.PixelMap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.toPixelMap
import androidx.compose.ui.unit.IntRect

import jj3tictactoe.composeapp.generated.resources.Res
import jj3tictactoe.composeapp.generated.resources.allowed_move
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.imageResource
import org.jetbrains.compose.resources.painterResource
import jj3tictactoe.composeapp.generated.resources.lib_circlecrossblue
import jj3tictactoe.composeapp.generated.resources.lib_circlered
import jj3tictactoe.composeapp.generated.resources.lib_crossred
import jj3tictactoe.composeapp.generated.resources.lib_crossgreen
import jj3tictactoe.composeapp.generated.resources.lib_circleblue
import jj3tictactoe.composeapp.generated.resources.lib_circlecrossgreen
import jj3tictactoe.composeapp.generated.resources.lib_circlecrossred
import jj3tictactoe.composeapp.generated.resources.lib_circlegreen
import jj3tictactoe.composeapp.generated.resources.lib_crossblue
import jj3tictactoe.composeapp.generated.resources.prize_token
import jj3tictactoe.composeapp.generated.resources.taken_move
import org.jetbrains.compose.resources.imageResource
import org.jetbrains.compose.resources.stringArrayResource
import androidx.compose.ui.tooling.preview.Preview
import kotlin.random.Random

open class GameView(context: Context, attrs: AttributeSet) : CustomView(context, attrs) {
    //CustomView(context, attrs)
    //super(context, attrs)

    override fun requestLayout() {
        super.requestLayout()
        Log.i("Greeting requestLayout", "========> requesting layout")
    }

    var lastWidthMeasureSpec: Int = 0
    var lastHeightMeasureSpec: Int = 0

    fun onMeasure2(widthMeasureSpec: Int, heightMeasureSpec: Int) {

        createBitmapFromResource(Res.drawable.allowed_move)
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        //val minw: Int = View.getPaddingLeft + View.getPaddingRight + View.getSuggestedMinimumWidth
        ///val w: Int = View.resolveSizeAndState(minw, widthMeasureSpec, 0)

        //val minh: Int = View.getPaddingTop + View.getPaddingBottom + View.getSuggestedMinimumHeight
        //val h: Int = View.resolveSizeAndState(minh, heightMeasureSpec, 0)

       //lastWidthMeasureSpec = w //widthMeasureSpec
        //lastHeightMeasureSpec = h //heightMeasureSpec

        Log.i("Greeting", "onMeasure view width: $lastWidthMeasureSpec, height: $lastHeightMeasureSpec")

         /* override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
             super.onMeasure(widthMeasureSpec, heightMeasureSpec)
             lastWidthMeasureSpec = widthMeasureSpec
             lastHeightMeasureSpec = heightMeasureSpec
         } */
         //View.setMeasuredDimension(lastWidthMeasureSpec , lastHeightMeasureSpec )
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        lastWidthMeasureSpec = right - left
        lastHeightMeasureSpec = bottom - top
        Log.i("Greeting onLayout", "getDimensions width: $lastWidthMeasureSpec, height: $lastHeightMeasureSpec")
    }

   fun remeasureDimensions(width: Int, height: Int) {
       //View.setMeasuredDimension(width, height)
    }

    //fun getDimensions(): Point {
        //return Point(lastWidthMeasureSpec, lastHeightMeasureSpec)
    //}

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val desiredWidth: Int = paddingLeft + paddingRight
        val desiredHeight: Int = paddingTop + paddingBottom

        val measuredWidth = resolveSize(desiredWidth, widthMeasureSpec)
        val measuredHeight = resolveSize(desiredHeight, heightMeasureSpec)

        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec)
        Log.i("onMeasure--->", "measured width: $widthMeasureSpec, height: $heightMeasureSpec")
    }


    protected fun onMeasure3(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        //View.resolveSize()   .setMeasuredDimension(
            //getDefaultSize2(View.getSuggestedMinimumWidth, widthMeasureSpec),
           //getDefaultSize2(View.getSuggestedMinimumHeight, heightMeasureSpec)
        //)
        //Log.i("Greeting onMeasure", "measured width: ${View.getMeasuredWidth}, height: ${View.getMeasuredHeight}")
    }//

    fun getDefaultSize2(size: Int, measureSpec: Int): Int {
        var result = size
        val specMode = View.MeasureSpec.getMode(measureSpec)
        val specSize = View.MeasureSpec.getSize(measureSpec)

        when (specMode) {
            View.MeasureSpec.UNSPECIFIED -> result = size
            View.MeasureSpec.AT_MOST, View.MeasureSpec.EXACTLY -> result = specSize
        }
        return result
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        Log.i("onSizeChanged--->", "width: $w, height: $h, oldWidth: $oldw, oldHeight: $oldh")
    }

    //@Composable
    fun createBitmapFromResource(resource: DrawableResource): ImageBitmap {
        // The imageResource function is a composable, so it should ideally be called
        // within a Composable scope. If you need it outside of Compose, you might need
        // a platform-specific implementation using 'expect/actual' or a third-party library
        // that handles non-composable resource loading.
        // For general Compose usage:
        return imageResource(resource = resource)
    }
}