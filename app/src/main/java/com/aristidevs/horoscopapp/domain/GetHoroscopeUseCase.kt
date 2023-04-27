package com.aristidevs.horoscopapp.domain

import com.aristidevs.horoscopapp.data.network.HoroscopeApi
import com.aristidevs.horoscopapp.data.network.model.HoroscopeResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class GetHoroscopeUseCase @Inject constructor(private val api: HoroscopeApi) {

    suspend operator fun invoke(): Flow<HoroscopeResponse?> {
        val response = api.getHoroscope("aries", "today")
        if (response.isSuccessful) {
            return flowOf(response.body())
        }
        return flowOf(null)
    }

}