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
        List<Integer> paires = values.stream()
                .filter(val -> Collections.frequency(values, val) == 2)
                .distinct()
                .collect(Collectors.toList());
        if (paires.size() == 2) {
            List<String> pairesString = new ArrayList<>(2);
            for (int pair : paires) {
                pairesString.add(this.handGame.stream()
                        .filter(c -> c.getValue() == pair).map(Card::getCardName).findFirst().orElse(null));
            }
            return "two pair of : " + String.join(" and ", pairesString);
        }
        Card cardPair = evaluateCardPair();
        if (cardPair != null) {
            return "pair of : " + cardPair.getCardName();
        }
        Card highCard = evaluateHighCard();
        return "high card: " + highCard.getCardName();
    }

    private Card evaluateCardPair() {
        List<Integer> values = this.handGame.stream().map(Card::getValue).collect(Collectors.toList());
        Optional<Integer> optionalPairValue = values.stream()
                .filter(val -> Collections.frequency(values, val) == 2).findFirst();
        return optionalPairValue.isEmpty() ? null :
                this.handGame.stream()
                        .filter(c -> c.getValue() == optionalPairValue.get()).findFirst().orElse(null);
    }

    private Card evaluateHighCard() {
        Optional<Card> cardOptional = handGame.stream()
                .filter(c -> c.getValue() == 1).findAny();
        if (cardOptional.isEmpty()) {
            cardOptional = handGame.stream().max(Comparator.comparingInt(Card::getValue));
        }
        return cardOptional.orElse(null);
    }

}
