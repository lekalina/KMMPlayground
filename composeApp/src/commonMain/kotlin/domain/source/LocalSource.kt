package domain.source

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalSource(
    private val dataStore: DataStore<Preferences>
) {
    val EXAMPLE_COUNTER = intPreferencesKey("example_counter")

    suspend fun updateExampleCounter(newCounter: Int) {
        dataStore.edit { preferences ->
            preferences[EXAMPLE_COUNTER] = newCounter
        }
    }

    val exampleCounterFlow: Flow<Int?> = dataStore.data
        .map { preferences ->
            preferences[EXAMPLE_COUNTER]
        }
}