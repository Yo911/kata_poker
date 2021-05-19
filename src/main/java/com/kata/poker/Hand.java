package com.kata.poker;

import java.util.*;
import java.util.stream.Collectors;

public class Hand {
    Set<Card> handGame;

    public Hand(Set<Card> handGame) {
        this.handGame = handGame;
    }

    public String evaluate() {
        Card cardPair = evaluateCardPair();
        if (cardPair != null) {
            return "pair of : " + cardPair.getCardName();
        }
        Card highCard = evaluateHighCard();
        return "high card: " + highCard.getCardName();
    }

    private Card evaluateCardPair() {
        List<Integer> values = this.handGame.stream().map(Card::getValue).collect(Collectors.toList());
        Optional<Integer> optionalPairValue = values.stream().filter(val -> Collections.frequency(values, val) == 2).findFirst();
        return optionalPairValue.isEmpty() ? null :
                this.handGame.stream().filter(c -> c.getValue() == optionalPairValue.get()).findFirst().orElse(null);
    }

    private Card evaluateHighCard() {
        Optional<Card> cardOptional = handGame.stream().filter(c -> c.getValue() == 1).findAny();
        if (cardOptional.isEmpty()) {
            cardOptional = handGame.stream().max(Comparator.comparingInt(Card::getValue));
        }
        return cardOptional.orElse(null);
    }

}
