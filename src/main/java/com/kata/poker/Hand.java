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
        Card highCard;
        Optional<Card> cardOptional = handGame.stream().filter(c -> c.getValue() == 1).findAny();
        if (!cardOptional.isPresent()) {
            cardOptional = handGame.stream().max(Comparator.comparingInt(Card::getValue));
        }
        highCard = cardOptional.get();
        return "high card: " + highCard.getCardName();
    }

}
