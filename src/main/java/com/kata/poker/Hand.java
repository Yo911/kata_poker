package com.kata.poker;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Hand {
    private Set<Card> handGame;

    private List<Integer> values;

    public Hand(Set<Card> handGame) {
        this.handGame = handGame;
        this.values = handGame.stream().map(Card::getValue).sorted().collect(Collectors.toList());
    }

    public String evaluate() {
        Card fourOfKind = getNumbersOfKind(4);
        if (fourOfKind != null) {
            return "three of kind : " + fourOfKind.getCardName();
        }
        if (isFlush() == 1) {
            return "flush of : " + evaluateHighCard().getCardName();
        }
        if (isConsecutive()) {
            return "straight of : " + evaluateHighCard().getCardName();
        }
        Card threeOfKind = getNumbersOfKind(3);
        List<Integer> paires = getPaires();
        if (threeOfKind != null) {
            if (!paires.isEmpty()) {
                return "full of : " + threeOfKind.getCardName() + " over " + getCardFromValue(paires.get(0)).getCardName();
            }
            return "three of kind : " + threeOfKind.getCardName();

        }
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

    private long isFlush() {
        return handGame.stream().map(Card::getSuit).distinct().count();
    }

    private boolean isConsecutive() {
        boolean isConsecutive = true;
        for (int i = values.size() - 1; i > 0; i--) {
            isConsecutive &= values.get(i) == values.get(i - 1) + 1;
        }
        return isConsecutive;
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

    private Card getNumbersOfKind(int numberOfFrequency) {
        Optional<Integer> three = values.stream()
                .filter(frequencyOfCardValuePredicate(values, numberOfFrequency)).findFirst();
        return three.isEmpty() ? null : getCardFromValue(three.get());
    }

    private Predicate<Integer> frequencyOfCardValuePredicate(List<Integer> values, int numberOfFrequency) {
        return val -> Collections.frequency(values, val) == numberOfFrequency;
    }

    private Card evaluateHighCard() {
        return handGame.stream().max(Comparator.comparingInt(Card::getValue)).orElse(null);
    }
}
