package com.aristidevs.horoscopapp.core.network

sealed class ResultType<T> {
    //val example =  ResultType.Success<HoroscopeResponse>()
    data class Success<T>(val data: T?) : ResultType<T>()
    //val example =  ResultType.Error<HoroscopeResponse>("SUSCRIBETE")
    data class Error<T>(val errorType: ErrorType) : ResultType<T>()
}