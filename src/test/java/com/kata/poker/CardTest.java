package com.kata.poker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CardTest {

    @Test
    void should_return_5H_when_get_card() {
        Card card = new Card(3, Card.Suit.H);

        String result = card.getCard();

        Assertions.assertEquals("5H", result);
    }

    @Test
    void should_return_6C_when_get_card() {
        Card card = new Card(4, Card.Suit.C);

        String result = card.getCard();

        Assertions.assertEquals("6C", result);
    }

    @Test
    void should_return_AD_when_get_card() {
        Card card = new Card(12, Card.Suit.D);

        String result = card.getCard();

        Assertions.assertEquals("AD", result);
    }

    @Test
    void should_return_ace_when_get_card_name() {
        Card card = new Card(12, Card.Suit.D);

        String result = card.getCardName();

        Assertions.assertEquals("Ace", result);
    }

    @Test
    void should_return_king_when_get_card_name() {
        Card card = new Card(11, Card.Suit.D);

        String result = card.getCardName();

        Assertions.assertEquals("King", result);
    }

    @Test
    void should_return_10_and_when_get_card_name() {
        Card card = new Card(8, Card.Suit.D);

        String result = card.getCardName();

        Assertions.assertEquals("10", result);
        Assertions.assertEquals("TD", card.getCard());
    }

    @Test
    void should_throw_exception_bad_range() {
       Assertions.assertThrows(IllegalArgumentException.class, () -> new Card(50, Card.Suit.D));
    }

    @Test
    void should_get_card_from_string() {
        Card card = new Card("TS");

        String result = card.getCardName();

        Assertions.assertEquals("10", result);
        Assertions.assertEquals("TS", card.getCard());
        Assertions.assertEquals(Card.Suit.S, card.getSuit());
    }

    @Test
    void  should_failed_to_get_card_doesnt_exist() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Card("*P"));
    }

    @Test
    void  should_failed_to_get_card_with_suit_doesnt_exist() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Card("9P"));
    }

}