package com.kata.poker;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Hand {
    private Set<Card> handGame;

    private List<Integer> values;

    public Hand(Set<Card> handGame) {
        this.handGame = handGame;
        this.values = handGame.stream().map(Card::getValue).collect(Collectors.toList());
    }

    public String evaluate() {
        Card threeOfKind = getThreeOfKind();
        if (threeOfKind != null) {
            return "three of kind : " + threeOfKind.getCardName();
        }
        List<Integer> paires = getPaires();
        List<Card> cardPair = paires.stream().sorted().map(this::getCardFromValue).collect(Collectors.toList());
        if (cardPair.size() == 2) {
            return "two pair of : " + cardPair.stream().map(Card::getCardName).collect(Collectors.joining(" and "));
        }
        if (!cardPair.isEmpty()) {
            return "pair of : " + cardPair.get(0).getCardName();
        }
        Card highCard = evaluateHighCard();
        return "high card: " + highCard.getCardName();
    }

    private Card getCardFromValue(int paireValue) {
        return this.handGame.stream()
                .filter(c -> c.getValue() == paireValue).findFirst().orElse(null);
    }

    private List<Integer> getPaires() {
        List<Integer> paires = values.stream()
                .filter(frequencyOfCardValuePredicate(values, 2)).distinct().collect(Collectors.toList());
        return paires;
    }

    private Card getThreeOfKind() {
        Optional<Integer> three = values.stream()
                .filter(frequencyOfCardValuePredicate(values, 3)).findFirst();
        return three.isEmpty() ? null : getCardFromValue(three.get());
    }

    private Predicate<Integer> frequencyOfCardValuePredicate(List<Integer> values, int numberOfFrequency) {
        return val -> Collections.frequency(values, val) == numberOfFrequency;
    }

    private Card evaluateHighCard() {
        return handGame.stream().max(Comparator.comparingInt(Card::getValue)).orElse(null);
    }
}
