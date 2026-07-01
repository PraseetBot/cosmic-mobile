package com.cosmic.mobile.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.cosmic.mobile.domain.models.Command
import kotlinx.coroutines.flow.Flow

@Dao
interface CommandDao {
    @Insert
    suspend fun insertCommand(command: Command): Long

    @Query("SELECT * FROM commands ORDER BY timestamp DESC LIMIT :limit OFFSET :offset")
    fun getAllCommands(limit: Int = 50, offset: Int = 0): Flow<List<Command>>

    @Query("SELECT * FROM commands WHERE id = :commandId")
    suspend fun getCommandById(commandId: String): Command?

    @Query("SELECT * FROM commands WHERE intent = :intent ORDER BY timestamp DESC LIMIT :limit")
    fun getCommandsByIntent(intent: String, limit: Int = 10): Flow<List<Command>>

    @Query("DELETE FROM commands WHERE timestamp < :beforeTimestamp")
    suspend fun deleteCommandsBefore(beforeTimestamp: Long)

    @Query("DELETE FROM commands")
    suspend fun deleteAllCommands()

    @Query("SELECT COUNT(*) FROM commands")
    suspend fun getCommandCount(): Int
}
