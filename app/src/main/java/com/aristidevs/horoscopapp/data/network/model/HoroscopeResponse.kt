package com.aristidevs.horoscopapp.data.network.model

import com.aristidevs.horoscopapp.domain.model.HoroscopeModel
import com.google.gson.annotations.SerializedName

data class HoroscopeResponse(
    @SerializedName("date") val date: String,
    @SerializedName("horoscope") val horoscope: String,
    @SerializedName("icon") val icon: String,
    @SerializedName("id") val id: Int,
    @SerializedName("sign") val sign: String,
)

fun HoroscopeResponse.toDomain() = HoroscopeModel(
    horoscope = this.horoscope,
    icon = this.icon,
    sign = this.sign
)
