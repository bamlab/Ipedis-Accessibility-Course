package com.theodo.apps.ipedis.accessibility.navigation

import kotlinx.serialization.Serializable

abstract sealed class Screen {
    abstract val title: String
}

@Serializable
object Home : Screen() {
    override val title: String = "Home"
}
