package com.aristidevs.horoscopapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aristidevs.horoscopapp.domain.GetHoroscopeUseCase
import com.aristidevs.horoscopapp.ui.detail.model.DetailUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val getHoroscopeUseCase: GetHoroscopeUseCase) :
    ViewModel() {

    private val _uiState = MutableStateFlow<DetailUIState>(DetailUIState.Loading)
    val uiState:StateFlow<DetailUIState> = _uiState

    fun getHoroscope() {
        viewModelScope.launch {
            getHoroscopeUseCase()
                .collect { horoscope ->
                    if(horoscope!=null){
                        _uiState.value = DetailUIState.Success(horoscope)
                    }
                }
        }
    }
}