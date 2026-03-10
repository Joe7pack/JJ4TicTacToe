package com.guzzardo.jj3tictactoe

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.content.res.Resources

actual fun getBitmapImage(bmpResId: Int): Bitmap? {
    lateinit var resources: Resources
    //getResources()
    val opts = BitmapFactory.Options()
    opts.inMutable = true
    val bmp = BitmapFactory.decodeResource(resources, bmpResId, opts)
    /* if (bmp == null) {
        val d = ResourcesCompat.getDrawable(resources, bmpResId, null)
        val w = d!!.intrinsicWidth
        val h = d.intrinsicHeight
        bmp = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        val c = Canvas(bmp)
        d.setBounds(0, 0, w - 1, h - 1)
        d.draw(c)
    } */
    return bmp
}
