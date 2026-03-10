package com.guzzardo.jj4tictactoe

import android.content.Context
import android.util.AttributeSet
import android.view.View

open class CustomView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    //val context = context
    //val attrs = attrs

    init {
        requestLayout()

    }

    /* override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        // 1. Get constraints from parent
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)

        // 2. Define desired size (e.g., 100dp converted to pixels)
        val desiredWidth = 100 * context.resources.displayMetrics.density.toInt()
        val desiredHeight = 100 * context.resources.displayMetrics.density.toInt()

        // 3. Measure Width
        val width = when (widthMode) {
            MeasureSpec.EXACTLY -> widthSize // Parent forced a size
            MeasureSpec.AT_MOST -> minOf(desiredWidth, widthSize) // Wrap content
            else -> desiredWidth // Unspecified
        }

        // 4. Set final dimensions
        setMeasuredDimension(width, desiredHeight)
    } */
}