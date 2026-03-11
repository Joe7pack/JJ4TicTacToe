package com.guzzardo.jj4tictactoe

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform