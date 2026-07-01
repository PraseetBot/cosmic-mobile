package com.cosmic.mobile.domain.models

data class CommandResult(
    val command: Command,
    val intent: String,
    val confidence: Float,
    val target: String? = null,
    val alternativeSuggestions: List<String> = emptyList(),
    val error: String? = null
)

data class ConfirmationState(
    val commandResult: CommandResult? = null,
    val editableContent: String = "",
    val isConfirmed: Boolean = false
)
