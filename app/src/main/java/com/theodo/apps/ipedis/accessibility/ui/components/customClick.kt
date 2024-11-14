package com.theodo.apps.ipedis.accessibility.ui.components

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.semantics.Role

fun Modifier.customClick(
    onClick: () -> Unit,
    semanticLabel: String? = null,
    role: Role? = null
): Modifier = this then
    Modifier.pointerInput("") {
        detectTapGestures(onTap = { onClick() })
    }
