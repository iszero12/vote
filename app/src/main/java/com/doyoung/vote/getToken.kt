import android.content.Context
import com.doyoung.vote.dataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

fun getToken(context: Context): String? {
    return runBlocking {
        val preferences = context.dataStore.data.first()
        "Bearer "+preferences[TOKEN_KEY]
    }
}
