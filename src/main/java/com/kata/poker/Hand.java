package com.kata.poker;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Hand {
    Set<Card> handGame;

    public Hand(Set<Card> handGame) {
        this.handGame = handGame;
    }

    public String evaluate() {
        List<Integer> paires = getPaires();
        List<Card> cardPair = paires.stream().map(this::getCardPair).collect(Collectors.toList());
        if (cardPair.size() == 2) {
            return "two pair of : " + cardPair.stream().map(Card::getCardName).collect(Collectors.joining(" and "));
        }
        if (!cardPair.isEmpty()) {
            return "pair of : " + cardPair.get(0).getCardName();
        }
        Card highCard = evaluateHighCard();
        return "high card: " + highCard.getCardName();
    }

    private Card getCardPair(int paireValue) {
        return this.handGame.stream()
                .filter(c -> c.getValue() == paireValue).findFirst().orElse(null);
    }

    private List<Integer> getPaires() {
        List<Integer> values = this.handGame.stream().map(Card::getValue).collect(Collectors.toList());
        List<Integer> paires = values.stream()
                .filter(frequencyOfCardValuePredicate(values, 2)).distinct().collect(Collectors.toList());
        return paires;
    }

    private Predicate<Integer> frequencyOfCardValuePredicate(List<Integer> values, int numberOfFrequency) {
        return val -> Collections.frequency(values, val) == numberOfFrequency;
    }

    private Card evaluateHighCard() {
        return handGame.stream().max(Comparator.comparingInt(Card::getValue)).orElse(null);
    }

}
