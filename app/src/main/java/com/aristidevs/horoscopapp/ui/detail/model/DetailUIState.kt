package com.aristidevs.horoscopapp.ui.detail.model

import com.aristidevs.horoscopapp.domain.model.HoroscopeModel

sealed class DetailUIState {
    object Loading : DetailUIState()
    data class Success(val horoscopeModel: HoroscopeModel) : DetailUIState()
    data class Error(val msg: String) : DetailUIState()
}