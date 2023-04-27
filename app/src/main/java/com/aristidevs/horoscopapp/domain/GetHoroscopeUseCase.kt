package com.aristidevs.horoscopapp.domain

import com.aristidevs.horoscopapp.core.network.ResultType
import com.aristidevs.horoscopapp.data.network.HoroscopeRepository
import com.aristidevs.horoscopapp.domain.dto.HoroscopeDTO
import com.aristidevs.horoscopapp.domain.model.HoroscopeModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetHoroscopeUseCase @Inject constructor(private val horoscopeRepository: HoroscopeRepository) {

    operator fun invoke(horoscopeDTO: HoroscopeDTO): Flow<ResultType<HoroscopeModel>> =
        horoscopeRepository.getHoroscope(horoscopeDTO)

}