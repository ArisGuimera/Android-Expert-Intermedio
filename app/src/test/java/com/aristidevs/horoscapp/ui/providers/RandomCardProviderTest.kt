package com.aristidevs.horoscapp.ui.providers

import org.junit.Assert.*
import org.junit.Test

class RandomCardProviderTest{

    @Test
    fun `getRandomCard should return a random card`(){
        val randomCard = RandomCardProvider()

        val card = randomCard.getLucky()

        assertNotNull(card)
    }
}