package com.aristidevs.horoscopapp.ui.detail.model

import com.aristidevs.horoscopapp.data.network.model.HoroscopeResponse

sealed class DetailUIState {
    object Loading : DetailUIState()
    data class Success(val horoscopeResponse: HoroscopeResponse) : DetailUIState()
    data class Error(val msg: String) : DetailUIState()
}