package com.kata.poker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CardTest {

    @Test
    void should_return_5H_when_get_card() {
        Card card = new Card(5, Card.Suit.H);

        String result = card.getCard();

        Assertions.assertEquals("5H", result);
    }

}