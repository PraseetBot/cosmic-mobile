package com.cosmic.mobile.domain.models

data class UserPreferences(
    val theme: String = "dark",
    val language: String = "en",
    val cloudAiEnabled: Boolean = false,
    val accessibilityEnabled: Boolean = false,
    val wakeButtonEnabled: Boolean = true
)

object Theme {
    const val DARK = "dark"
    const val LIGHT = "light"
    const val SYSTEM = "system"
}

object Language {
    const val ENGLISH = "en"
    const val HINDI = "hi"
    const val HINGLISH = "hi-EN"
}
