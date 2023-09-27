package com.example.liberty.data.network

import android.util.Log
import com.example.liberty.util.ApiException
import com.example.liberty.util.AppVersionException
import com.example.liberty.util.UnAuthorisedException
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response

open class SafeApiRequest {
    suspend fun <T : Any> apiRequest(call: suspend () -> Response<T>): T? {
        val response = call.invoke()
        if (response.isSuccessful) {
            return response.body()
        } else {
            val error = response.errorBody()?.string()
            val message = StringBuilder()
            error?.let {
                try {
                    message.append(JSONObject(it).getString("message"))
                } catch (e: JSONException) {
                    Log.e("TAG", e.toString())
                }
            }
            if (response.code() == 401) {
                throw UnAuthorisedException(message.toString())
            } else if (response.code() == 505) {
                throw AppVersionException(message.toString())
            } else {
                throw ApiException(message.toString())
            }
        }
    }

}