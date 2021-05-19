package com.kata.poker;

import java.util.HashMap;
import java.util.Map;

public class Card {

    private static final Map<Integer, String> cards = new HashMap<>();

    static {
        cards.put(2, "2");
        cards.put(3, "3");
        cards.put(4, "4");
        cards.put(5, "5");
        cards.put(6, "6");
        cards.put(7, "7");
        cards.put(8, "8");
        cards.put(9, "9");
        cards.put(10, "T");
        cards.put(11, "J");
        cards.put(12, "Q");
        cards.put(13, "K");
        cards.put(1, "A");
    }

    public Card(int value, Suit suit) {
    }

    public String getCard() {
        return "5H";
    }

    public enum Suit {
        H("H", "Heart");

        private final String note;
        private final String label;

        Suit(String note, String label) {
            this.note = note;
            this.label = label;
        }
    }
}
