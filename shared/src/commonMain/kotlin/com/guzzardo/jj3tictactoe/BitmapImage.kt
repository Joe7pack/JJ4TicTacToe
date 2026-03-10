package com.guzzardo.jj3tictactoe

interface BitmapImage {
    val name: Int
}

expect fun getBitmapImage(bmpResId: Int): BitmapImage

