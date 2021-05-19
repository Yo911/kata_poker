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

    @Test
    void should_return_6C_when_get_card() {
        Card card = new Card(6, Card.Suit.C);

        String result = card.getCard();

        Assertions.assertEquals("6C", result);
    }

    @Test
    void should_return_AD_when_get_card() {
        Card card = new Card(1, Card.Suit.D);

        String result = card.getCard();

        Assertions.assertEquals("AD", result);
    }

    @Test
    void should_throw_exception_bad_range() {
       Assertions.assertThrows(IllegalArgumentException.class, () -> new Card(50, Card.Suit.D));
    }

}