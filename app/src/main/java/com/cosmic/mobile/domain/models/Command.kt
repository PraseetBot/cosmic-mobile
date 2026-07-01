package com.cosmic.mobile.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "commands")
data class Command(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val transcript: String,
    val normalizedText: String,
    val intent: String,
    val confidence: Float,
    val language: String,
    val timestamp: Long = System.currentTimeMillis(),
    val status: String = CommandStatus.SUCCESS
)

object CommandStatus {
    const val SUCCESS = "success"
    const val FAILED = "failed"
    const val CANCELLED = "cancelled"
}

object IntentType {
    const val OPEN_APP = "OPEN_APP"
    const val WEB_SEARCH = "WEB_SEARCH"
    const val SEND_MESSAGE = "SEND_MESSAGE"
    const val SCROLL = "SCROLL"
    const val UNKNOWN = "UNKNOWN"
}
