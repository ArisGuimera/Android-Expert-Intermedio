package com.aristidevs.horoscapp.domain.usecase

import com.aristidevs.horoscapp.domain.Repository
import javax.inject.Inject

class GetPredictionUseCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(sign: String) = repository.getPrediction(sign)
}