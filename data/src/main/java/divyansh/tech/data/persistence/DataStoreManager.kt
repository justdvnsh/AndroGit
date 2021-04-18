package divyansh.tech.data.persistence

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import divyansh.tech.utility.C
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(
    name = C.USER_PREF_FILENAME
)

private object PreferenceKeys {
    val AUTH_TOKEN = stringPreferencesKey("auth_token")
}
/*
* Preference Data Store Manager class. Provides utility functions to
* save and retrieve keys.
* @param context -> Application Context
* */
class DataStoreManager(context: Context) {

    private val userDataStore = context.dataStore

    /*
    * suspend function to store the auth token to a shared pref file
    * @param token -> String
    * */
    suspend fun setAuthToken(token: String) {
        userDataStore.edit {
            it[PreferenceKeys.AUTH_TOKEN] = token
        }
    }

    val authToken: Flow<String?> = userDataStore.data.map {
        it[PreferenceKeys.AUTH_TOKEN] ?: null
    }
}