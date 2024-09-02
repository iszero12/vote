import com.doyoung.vote.JoinRequest
import com.doyoung.vote.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun Join(username: String, password: String, confirmPassword: String): String? {
    return withContext(Dispatchers.IO) {
        try {
            val authService = RetrofitClient.authService
            val JoinRequest = JoinRequest(username, password, confirmPassword)
            val response = authService.join(JoinRequest)
            response
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}