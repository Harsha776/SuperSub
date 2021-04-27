package com.harsha.common

object Constants {
    const val SPLASH_DELAY_MILLIS = 4000L
    const val TRUE=true
    const val ID="id"

    fun secondsToMinute(totalSecs: Int): String? {
        val hours = totalSecs / 3600.toLong()
        val minutes = totalSecs % 3600 / 60.toLong()
        val seconds = totalSecs % 60.toLong()
        return String.format("%02d:%02d", minutes, seconds)
    }
}