package com.aristidevs.horoscopapp.data.network

import com.aristidevs.horoscopapp.core.network.ResultType
import com.aristidevs.horoscopapp.data.network.model.HoroscopeResponse
import com.aristidevs.horoscopapp.data.network.model.toDomain
import com.aristidevs.horoscopapp.domain.dto.HoroscopeDTO
import com.aristidevs.horoscopapp.domain.model.HoroscopeModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class HoroscopeRepository @Inject constructor(private val api: HoroscopeApi) {
    fun getHoroscope(horoscopeDTO: HoroscopeDTO): Flow<ResultType<HoroscopeModel>> = flow {
        try {
            val response = api.getHoroscope(horoscopeDTO.sign, horoscopeDTO.date, horoscopeDTO.lang)
            if (response.isSuccessful) {
                response.body()?.let {horoscopeResponse ->
                    emit(ResultType.Success(horoscopeResponse.toDomain()))
                }
            } else {
                val msg = when (response.code()) {
                    404 -> "Not found"
                    405 -> "Eres un imbecil"
                    else -> "Error genérico"
                }
                emit(ResultType.Error(msg))
            }

        } catch (e: Exception) {
            val msg = when (e) {
                is IOException -> "Error IO"
                else -> "CRASH FINAL Y CAOS"
            }
            emit(ResultType.Error(msg))
        }
    }
}