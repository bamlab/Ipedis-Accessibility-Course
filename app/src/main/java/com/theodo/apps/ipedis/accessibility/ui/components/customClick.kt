package com.theodo.apps.ipedis.accessibility.ui.components

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput

fun Modifier.customClick(onClick: () -> Unit): Modifier =
    this then
        Modifier.pointerInput("") {
            detectTapGestures(onTap = { onClick() })
        }
