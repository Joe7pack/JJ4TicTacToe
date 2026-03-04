package com.guzzardo.jj3tictactoe

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View

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
}