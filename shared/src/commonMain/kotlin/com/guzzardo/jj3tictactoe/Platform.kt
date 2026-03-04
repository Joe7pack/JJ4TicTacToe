package com.guzzardo.jj3tictactoe

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform