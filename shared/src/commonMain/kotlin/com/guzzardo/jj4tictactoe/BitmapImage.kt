package com.guzzardo.jj4tictactoe

interface BitmapImage {
    val name: Int
}

expect fun getBitmapImage(bmpResId: Int): Int
