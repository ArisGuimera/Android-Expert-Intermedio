package com.aristidevs.horoscopapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aristidevs.horoscopapp.core.network.ResultType
import com.aristidevs.horoscopapp.data.network.model.HoroscopeResponse
import com.aristidevs.horoscopapp.domain.GetHoroscopeUseCase
import com.aristidevs.horoscopapp.domain.dto.HoroscopeDTO
import com.aristidevs.horoscopapp.domain.model.HoroscopeModel
import com.aristidevs.horoscopapp.ui.detail.model.DetailUIState
import com.aristidevs.horoscopapp.ui.detail.model.DetailUIState.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val getHoroscopeUseCase: GetHoroscopeUseCase) :
    ViewModel() {

    private val _uiState = MutableStateFlow<DetailUIState>(Loading)
    val uiState:StateFlow<DetailUIState> = _uiState

    fun getHoroscope() {
        viewModelScope.launch {
            getHoroscopeUseCase(HoroscopeDTO(sign = "aries"))
                .collect { result: ResultType<HoroscopeModel> ->
                    when(result){
                        is ResultType.Error -> {
                            _uiState.value = Error(result.msg ?: "Que ha pachao")
                        }
                        is ResultType.Success -> {
                            _uiState.value = Success(result.data!!)
                        }
                    }
                }
        }
    }
}