package com.aristidevs.horoscopapp.core.network

import java.lang.Exception

sealed class ErrorType(val errorCode:Int) {
    object BadRequest:ErrorType(400)
    object InvalidData:ErrorType(401)
    object Forbidden:ErrorType(403)
    object InternalServerError:ErrorType(500)
    data class UncontrolledError(val code:Int):ErrorType(code)
    data class ExceptionError(val exception: Exception):ErrorType(666)
}