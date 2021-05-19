package com.kata.poker;

import java.util.*;
import java.util.stream.Collectors;

public class Hand {
    Set<Card> handGame;

    public Hand(Set<Card> handGame) {
        this.handGame = handGame;
    }

    public String evaluate() {
        List<Integer> values = this.handGame.stream().map(Card::getValue).collect(Collectors.toList());
        Optional<Integer> optionalPairValue = values.stream().filter(val -> Collections.frequency(values, val) == 2).findFirst();
        if (optionalPairValue.isPresent()) {
            Card card = this.handGame.stream().filter(c -> c.getValue() == optionalPairValue.get()).findFirst().orElse(null);
            return "pair of : " + card.getCardName();
        }
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
