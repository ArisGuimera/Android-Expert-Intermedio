package com.aristidevs.horoscopapp.domain.dto

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class HoroscopeDTO(
    val sign: String,
    val date: String = getCurrentDay(),
    val lang: String = "es"
)

fun getCurrentDay(): String {
    val currentDate = Date()
    val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    return dateFormat.format(currentDate)
}
