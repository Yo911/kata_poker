package com.kata.poker;

import java.util.Set;

public class Hand {
    Set<Card> handGame;

    public Hand(Set<Card> handGame) {
        this.handGame = handGame;
    }

    public String evaluate() {
        return "high card: Ace";
    }

}
