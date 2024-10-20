package com.example.keepnotes.data.auth

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

/**
 * @param open Initial value of the state (whether [open] has been invoked)
 */
//@Stable
//class OneTapSignInState(open: Boolean = false) {
//    var opened by mutableStateOf(open)
//        private set
//
//    fun open() {
//        opened = true
//    }
//
//    internal fun close() {
//        opened = false
//    }
//}
@Stable
class OneTapSignInState(open: Boolean = false) {
    var opened by mutableStateOf(open)
        private set

    // Do nothing when open() is called
    fun open() {
        // Prevent the state from changing to 'true'
        // This disables the sign-in functionality
    }

    internal fun close() {
        opened = false
    }
}

