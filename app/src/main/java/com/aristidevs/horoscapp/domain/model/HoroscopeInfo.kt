package com.aristidevs.horoscapp.domain.model

import com.aristidevs.horoscapp.R

sealed class HoroscopeInfo(val img:Int, val name:Int){
    data object Aries:HoroscopeInfo(R.drawable.aries, R.string.aries)
    data object Taurus: HoroscopeInfo(R.drawable.tauro, R.string.taurus)
    data object Gemini: HoroscopeInfo(R.drawable.geminis, R.string.gemini)
    data object Cancer: HoroscopeInfo(R.drawable.cancer, R.string.cancer)
    data object Leo: HoroscopeInfo(R.drawable.leo, R.string.leo)
    data object Virgo: HoroscopeInfo(R.drawable.virgo, R.string.virgo)
    data object Libra: HoroscopeInfo(R.drawable.libra, R.string.libra)
    data object Scorpio: HoroscopeInfo(R.drawable.escorpio, R.string.scorpio)
    data object Sagittarius: HoroscopeInfo(R.drawable.sagitario, R.string.sagittarius)
    data object Capricorn: HoroscopeInfo(R.drawable.capricornio, R.string.capricorn)
    data object Aquarius: HoroscopeInfo(R.drawable.aquario, R.string.aquarius)
    data object Pisces: HoroscopeInfo(R.drawable.piscis, R.string.pisces)
}

