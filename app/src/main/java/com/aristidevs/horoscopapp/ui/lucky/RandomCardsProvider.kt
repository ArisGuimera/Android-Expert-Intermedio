package com.aristidevs.horoscopapp.ui.lucky

import com.aristidevs.horoscopapp.R
import com.aristidevs.horoscopapp.ui.lucky.model.LuckyModel
import javax.inject.Inject
import kotlin.random.Random

class RandomCardsProvider @Inject constructor() {

    fun getLucky(): LuckyModel = when (Random.nextInt(0, 33)) {
        0 -> LuckyModel(R.drawable.card_fool, R.string.app_name)
        1 -> LuckyModel(R.drawable.card_moon, R.string.app_name)
        2 -> LuckyModel(R.drawable.card_hermit, R.string.app_name)
        3 -> LuckyModel(R.drawable.card_star, R.string.app_name)
        4 -> LuckyModel(R.drawable.card_sun, R.string.app_name)
        5 -> LuckyModel(R.drawable.card_sword, R.string.app_name)
        6 -> LuckyModel(R.drawable.card_chariot, R.string.app_name)
        7 -> LuckyModel(R.drawable.card_death, R.string.app_name)
        8 -> LuckyModel(R.drawable.card_devil, R.string.app_name)
        9 -> LuckyModel(R.drawable.card_empress, R.string.app_name)
        10 -> LuckyModel(R.drawable.card_hierophant, R.string.app_name)
        11 -> LuckyModel(R.drawable.card_ace_pentacles, R.string.app_name)
        12 -> LuckyModel(R.drawable.card_judgement, R.string.app_name)
        13 -> LuckyModel(R.drawable.card_world, R.string.app_name)
        14 -> LuckyModel(R.drawable.card_wheel_fortune, R.string.app_name)
        15 -> LuckyModel(R.drawable.card_tower, R.string.app_name)
        16 -> LuckyModel(R.drawable.card_temperance, R.string.app_name)
        17 -> LuckyModel(R.drawable.card_strength, R.string.app_name)
        18 -> LuckyModel(R.drawable.card_queen_wands, R.string.app_name)
        19 -> LuckyModel(R.drawable.card_queen_swords, R.string.app_name)
        20 -> LuckyModel(R.drawable.card_priestess, R.string.app_name)
        21 -> LuckyModel(R.drawable.card_nine_wands, R.string.app_name)
        22 -> LuckyModel(R.drawable.card_moon, R.string.app_name)
        23 -> LuckyModel(R.drawable.card_magician, R.string.app_name)
        24 -> LuckyModel(R.drawable.card_king_pentacles, R.string.app_name)
        25 -> LuckyModel(R.drawable.card_justice, R.string.app_name)
        26 -> LuckyModel(R.drawable.card_tower, R.string.app_name)
        27 -> LuckyModel(R.drawable.card_justice, R.string.app_name)
        28 -> LuckyModel(R.drawable.card_justice, R.string.app_name)
        29 -> LuckyModel(R.drawable.card_justice, R.string.app_name)
        30 -> LuckyModel(R.drawable.card_justice, R.string.app_name)
        31 -> LuckyModel(R.drawable.card_justice, R.string.app_name)
        32 -> LuckyModel(R.drawable.card_justice, R.string.app_name)
        33 -> LuckyModel(R.drawable.card_justice, R.string.app_name)
        else -> LuckyModel(R.drawable.card_reverse, R.string.app_name)
    }
}