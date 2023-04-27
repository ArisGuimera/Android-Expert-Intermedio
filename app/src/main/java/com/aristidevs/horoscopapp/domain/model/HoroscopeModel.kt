package com.aristidevs.horoscopapp.domain.model

import com.google.gson.annotations.SerializedName

data class HoroscopeModel (
    val horoscope: String,
    val icon: String,
    val sign: String,
)