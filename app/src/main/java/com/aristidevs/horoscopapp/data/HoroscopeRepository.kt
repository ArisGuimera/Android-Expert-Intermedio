package com.aristidevs.horoscopapp.data

import android.util.Log
import com.aristidevs.horoscopapp.core.network.ErrorType
import com.aristidevs.horoscopapp.core.network.ResultType
import com.aristidevs.horoscopapp.data.network.HoroscopeApi
import com.aristidevs.horoscopapp.data.network.model.toDomain
import com.aristidevs.horoscopapp.domain.dto.HoroscopeDTO
import com.aristidevs.horoscopapp.domain.model.HoroscopeModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class HoroscopeRepository @Inject constructor(private val api: HoroscopeApi) : BaseRepository() {

    suspend fun getHoroscope(horoscopeDTO: HoroscopeDTO):ResultType<HoroscopeModel>{
       return try {
            val response = api.getHoroscope(horoscopeDTO.sign, horoscopeDTO.date, horoscopeDTO.lang)
            if (response.isSuccessful) {
                response.body()?.let {horoscopeResponse ->
                    ResultType.Success(horoscopeResponse.toDomain())
                } ?: ResultType.Error(ErrorType.UncontrolledError(999))
            } else {
                val error = when (response.code()) {
                    ErrorType.BadRequest.errorCode -> ErrorType.BadRequest
                    ErrorType.InvalidData.errorCode -> ErrorType.InvalidData
                    ErrorType.Forbidden.errorCode -> ErrorType.Forbidden
                    ErrorType.InternalServerError.errorCode -> ErrorType.InternalServerError
                    else -> ErrorType.UncontrolledError(response.code())
                }
                Log.i("aristiCurso", "error")
                ResultType.Error(error)
            }

        } catch (e: Exception) {
           Log.i("aristiCurso", "exception")
            ResultType.Error(ErrorType.ExceptionError(e))
        }
    }

//    fun getHoroscope(horoscopeDTO: HoroscopeDTO) =
//        runApiCallFlow { api.getHoroscope(horoscopeDTO.sign, horoscopeDTO.date, horoscopeDTO.lang) }

//    fun getHoroscope(horoscopeDTO: HoroscopeDTO): Flow<ResultType<HoroscopeModel>> = flow {
//        try {
//            val response = api.getHoroscope(horoscopeDTO.sign, horoscopeDTO.date, horoscopeDTO.lang)
//            if (response.isSuccessful) {
//                response.body()?.let {horoscopeResponse ->
//                    emit(ResultType.Success(horoscopeResponse.toDomain()))
//                }
//            } else {
//                val msg = when (response.code()) {
//                    404 -> "Not found"
//                    405 -> "Eres un imbecil"
//                    else -> "Error genérico"
//                }
//                emit(ResultType.Error(msg))
//            }
//
//        } catch (e: Exception) {
//            val msg = when (e) {
//                is IOException -> "Error IO"
//                else -> "CRASH FINAL Y CAOS"
//            }
//            emit(ResultType.Error(msg))
//        }
//    }
}