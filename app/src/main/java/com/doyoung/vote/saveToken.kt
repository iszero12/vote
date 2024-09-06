import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.doyoung.vote.dataStore
import kotlinx.coroutines.runBlocking


val TOKEN_KEY = stringPreferencesKey("auth_token")

fun saveToken(context: Context, token: String) {
    runBlocking {
        context.dataStore.edit { preferences ->
            preferences[TOKEN_KEY] = token
        }
    }
}
