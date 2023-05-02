package com.aristidevs.horoscopapp.data

import com.aristidevs.horoscopapp.core.network.ErrorType.BadRequest
import com.aristidevs.horoscopapp.core.network.ErrorType.ExceptionError
import com.aristidevs.horoscopapp.core.network.ErrorType.Forbidden
import com.aristidevs.horoscopapp.core.network.ErrorType.InternalServerError
import com.aristidevs.horoscopapp.core.network.ErrorType.InvalidData
import com.aristidevs.horoscopapp.core.network.ErrorType.UncontrolledError
import com.aristidevs.horoscopapp.core.network.ResultType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

open class BaseRepository {

    inline fun <T> runApiCallFlow(crossinline call: () -> Response<T>): Flow<ResultType<T>> = flow {
        try {
            val response = call()
            if (response.isSuccessful) {
                emit(ResultType.Success(response.body()))
            } else {
                val error = when (response.code()) {
                    BadRequest.errorCode -> BadRequest
                    InvalidData.errorCode -> InvalidData
                    Forbidden.errorCode -> Forbidden
                    InternalServerError.errorCode -> InternalServerError
                    else -> UncontrolledError(response.code())
                }
                emit(ResultType.Error(error))
            }
        } catch (e: Exception) {
            emit(ResultType.Error(ExceptionError(e)))
        }
    }

}