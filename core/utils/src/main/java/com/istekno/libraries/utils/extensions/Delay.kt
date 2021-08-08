package com.istekno.libraries.utils.extensions

import android.content.Context
import android.os.Handler

object Delay {
    fun Context.delay(time: Long, action: () -> Unit) {
        Handler(mainLooper).postDelayed(
            { action() }, time
        )
    }
}