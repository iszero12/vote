import com.doyoung.vote.LoginRequest
import com.doyoung.vote.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun login(username: String, password: String): String? {
    return withContext(Dispatchers.IO) {
        try {
            val authService = RetrofitClient.authService
            val loginRequest = LoginRequest(username, password)
            val response = authService.login(loginRequest)
            response
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}