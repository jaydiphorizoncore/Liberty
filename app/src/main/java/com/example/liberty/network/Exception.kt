package com.example.liberty.network

import android.content.Context
import android.widget.Toast
import java.io.IOException

class ApiException(message: String) : IOException(message)
class UnAuthorisedException(message: String) : IOException(message)
class AppVersionException(message: String) : IOException(message)

fun Context.toast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
}