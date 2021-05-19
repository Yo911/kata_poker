package com.kata.poker;

import java.util.Comparator;
import java.util.Optional;
import java.util.Set;

public class Hand {
    Set<Card> handGame;

    public Hand(Set<Card> handGame) {
        this.handGame = handGame;
    }

    public String evaluate() {
        Card highCard = evaluateHighCard();
        return "high card: " + highCard.getCardName();
    }

    private Card evaluateHighCard() {
        Optional<Card> cardOptional = handGame.stream().filter(c -> c.getValue() == 1).findAny();
        if (cardOptional.isEmpty()) {
            cardOptional = handGame.stream().max(Comparator.comparingInt(Card::getValue));
        }
        return cardOptional.orElse(null);
    }

}
