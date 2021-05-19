package com.kata.poker;

import java.util.HashMap;
import java.util.Map;

public class Card {

    private static final Map<Integer, String> cards = new HashMap<>();

    private static final Map<String, String> cardName = new HashMap<>();

    static {
        cards.put(0, "2");
        cards.put(1, "3");
        cards.put(2, "4");
        cards.put(3, "5");
        cards.put(4, "6");
        cards.put(5, "7");
        cards.put(6, "8");
        cards.put(7, "9");
        cards.put(8, "T");
        cards.put(9, "J");
        cards.put(10, "Q");
        cards.put(11, "K");
        cards.put(12, "A");

        cardName.put("T", "10");
        cardName.put("J", "Jack");
        cardName.put("Q", "Queen");
        cardName.put("K", "King");
        cardName.put("A", "Ace");
    }

    private int value;

    private Suit suit;

    public Card(int value, Suit suit) {
        if (cards.get(value) == null) {
            throw new IllegalArgumentException("Illegal argument, cards value should be between 1 and 13, the current value is " + value);
        }
        this.value = value;
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }

    public String getCard() {
        return cards.get(value) + suit.note;
    }

    public String getCardName() {
        String card = cards.get(value);
        return cardName.getOrDefault(card, card);
    }

    public enum Suit {
        H("H", "Heart"),
        C("C", "Clubs"),
        D("D", "Diamond"),
        S("S", "Spade");

        private final String note;
        private final String label;

        Suit(String note, String label) {
            this.note = note;
            this.label = label;
        }
    }
}
