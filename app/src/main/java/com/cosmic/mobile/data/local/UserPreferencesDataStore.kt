package com.cosmic.mobile.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.cosmic.mobile.domain.models.Language
import com.cosmic.mobile.domain.models.Theme
import com.cosmic.mobile.domain.models.UserPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.userPreferencesDataStore: DataStore<Preferences> by preferencesDataStore(
    name = "user_preferences"
)

class UserPreferencesDataStore(context: Context) {
    private val dataStore = context.userPreferencesDataStore

    private object Keys {
        val THEME = stringPreferencesKey("theme")
        val LANGUAGE = stringPreferencesKey("language")
        val CLOUD_AI_ENABLED = booleanPreferencesKey("cloud_ai_enabled")
        val ACCESSIBILITY_ENABLED = booleanPreferencesKey("accessibility_enabled")
        val WAKE_BUTTON_ENABLED = booleanPreferencesKey("wake_button_enabled")
    }

    val userPreferencesFlow: Flow<UserPreferences> = dataStore.data.map { preferences ->
        UserPreferences(
            theme = preferences[Keys.THEME] ?: Theme.DARK,
            language = preferences[Keys.LANGUAGE] ?: Language.ENGLISH,
            cloudAiEnabled = preferences[Keys.CLOUD_AI_ENABLED] ?: false,
            accessibilityEnabled = preferences[Keys.ACCESSIBILITY_ENABLED] ?: false,
            wakeButtonEnabled = preferences[Keys.WAKE_BUTTON_ENABLED] ?: true
        )
    }

    suspend fun updateTheme(theme: String) {
        dataStore.edit { preferences ->
            preferences[Keys.THEME] = theme
        }
    }

    suspend fun updateLanguage(language: String) {
        dataStore.edit { preferences ->
            preferences[Keys.LANGUAGE] = language
        }
    }

    suspend fun updateCloudAiEnabled(enabled: Boolean) {
        dataStore.edit { preferences ->
            preferences[Keys.CLOUD_AI_ENABLED] = enabled
        }
    }

    suspend fun updateAccessibilityEnabled(enabled: Boolean) {
        dataStore.edit { preferences ->
            preferences[Keys.ACCESSIBILITY_ENABLED] = enabled
        }
    }

    suspend fun updateWakeButtonEnabled(enabled: Boolean) {
        dataStore.edit { preferences ->
            preferences[Keys.WAKE_BUTTON_ENABLED] = enabled
        }
    }
}
