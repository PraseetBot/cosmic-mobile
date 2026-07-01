package com.cosmic.mobile.domain.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(
    tableName = "action_logs",
    foreignKeys = [
        ForeignKey(
            entity = Command::class,
            parentColumns = ["id"],
            childColumns = ["commandId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class ActionLog(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val commandId: String,
    val actionType: String,
    val target: String,
    val result: String,
    val timestamp: Long = System.currentTimeMillis(),
    val error: String? = null
)
