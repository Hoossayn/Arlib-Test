package com.example.core.model

data class UserEditableSettings(
    val themeConfig: ThemeConfig = ThemeConfig.DARK,
    val isDynamicColor: Boolean = false,
)
