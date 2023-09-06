package com.aristidevs.horoscapp.ui.horoscope

import androidx.lifecycle.ViewModel
import com.aristidevs.horoscapp.data.providers.HoroscopeRepository
import com.aristidevs.horoscapp.domain.model.HoroscopeInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopeViewModel @Inject constructor(
    horoscopeRepositoryProvider: HoroscopeRepository
) : ViewModel() {

    private var _horoscope = MutableStateFlow<List<HoroscopeInfo>>(emptyList())
    val horoscope: StateFlow<List<HoroscopeInfo>> = _horoscope

    init {
        _horoscope.value = horoscopeRepositoryProvider.getHoroscopes()
    }

}