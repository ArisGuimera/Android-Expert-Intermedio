package com.aristidevs.horoscapp.data

import android.util.Log
import com.aristidevs.horoscapp.data.network.HoroscopeApiService
import com.aristidevs.horoscapp.data.network.response.PredictionResponse
import com.aristidevs.horoscapp.domain.Repository
import com.aristidevs.horoscapp.domain.model.PredictionModel
import retrofit2.Retrofit
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService) : Repository {

    override suspend fun getPrediction(sign: String): PredictionModel? {
        runCatching { apiService.getHoroscope(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("aris", "Ha ocurrido un error ${it.message}") }
        return null
    }
}
