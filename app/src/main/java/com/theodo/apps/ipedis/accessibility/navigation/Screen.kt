package com.theodo.apps.ipedis.accessibility.navigation

import kotlinx.serialization.Serializable

sealed abstract class Screen {
    abstract val title: String

}


@Serializable
object Home : Screen() {
    override val title: String = "Home"
}