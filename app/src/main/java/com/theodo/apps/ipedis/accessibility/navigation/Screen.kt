package com.theodo.apps.ipedis.accessibility.navigation

import kotlinx.serialization.Serializable

sealed class Screen {
    abstract val title: String
}

@Serializable
data object Home : Screen() {
    override val title: String = "Home"
}

@Serializable
data object List : Screen() {
    override val title: String = "Liste"
}

@Serializable
data object Order : Screen() {
    override val title: String = "Ordre"
}

@Serializable
data object Detail : Screen() {
    override val title: String = "Detail"
}

@Serializable
data object Offer : Screen() {
    override val title: String = "Nos offres"
}
