package com.example.liberty.ui.authentication.loginactivity

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.liberty.data.repository.ApiRepository
import com.example.liberty.data.network.request.loginrequest.LoginRequest
import com.example.liberty.util.ApiException
import com.example.liberty.util.AppConstants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(private val apiRepository: ApiRepository) : ViewModel() {

    lateinit var loginInterface: LoginInterface

    fun getLogin() {
        loginInterface.onStarted()

        CoroutineScope(Dispatchers.IO).launch {
            val token = AppConstants.TOKEN
            val headers = HashMap<String, String>()
            headers[AppConstants.KEY] = token

            val loginRequest = LoginRequest(
                appVersion = "1.3.6",
                deviceModel = "Android SDK built for x86",
                deviceName = "Android",
                deviceNo = "ad8443137d0f2ebb",
                devicePlatform = "Android",
                deviceType = 1,
                deviceUuid = "fqUCJxeQQjmuQxQ7oJyV1i:APA91bFnUyxv9E8gWbGfENAwNMWsk65pu-RuqrTBrBdhjxjjEisSKiKdI9W7JcwwPz9DqL8kaxGRq3UAl6T_JKwo8lR1agu6GAvLnqipP7zq2ahqsmZlAII9eVHIZwlnocRvuLWbTIpt",
                deviceVersion = "11",
                mode = "login",
                username = "1212121212"
            )
            try {

                val response = apiRepository.getLogin(headers, loginRequest)
                Log.d("TAG", "getLogin: $response")
                if (response != null) {
                    loginInterface.onSuccess(response)
                }

            } catch (e: ApiException) {
                loginInterface.onFailure(e.message!!)
            } catch (e: Exception) {
                loginInterface.onFailure(e.message!!)
                Log.e(this::class.simpleName, e.message.toString())
                Log.e("Exception", "Exception: $e")
            }
        }

    }
}