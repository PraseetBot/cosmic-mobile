package com.cosmic.mobile.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.cosmic.mobile.domain.models.ActionLog
import kotlinx.coroutines.flow.Flow

@Dao
interface ActionLogDao {
    @Insert
    suspend fun insertActionLog(actionLog: ActionLog): Long

    @Query("SELECT * FROM action_logs WHERE commandId = :commandId")
    suspend fun getActionLogsByCommandId(commandId: String): List<ActionLog>

    @Query("SELECT * FROM action_logs ORDER BY timestamp DESC LIMIT :limit OFFSET :offset")
    fun getAllActionLogs(limit: Int = 50, offset: Int = 0): Flow<List<ActionLog>>

    @Query("SELECT * FROM action_logs WHERE actionType = :actionType ORDER BY timestamp DESC LIMIT :limit")
    fun getActionLogsByType(actionType: String, limit: Int = 10): Flow<List<ActionLog>>

    @Query("DELETE FROM action_logs WHERE timestamp < :beforeTimestamp")
    suspend fun deleteActionLogsBefore(beforeTimestamp: Long)

    @Query("DELETE FROM action_logs")
    suspend fun deleteAllActionLogs()
}
