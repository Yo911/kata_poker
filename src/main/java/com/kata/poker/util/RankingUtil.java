package com.kata.poker.util;

import com.kata.poker.Card;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RankingUtil {

    public static Card getCardFromValue(Set<Card> handGame, int value) {
        return handGame.stream()
                .filter(c -> c.getValue() == value).findFirst().orElse(null);
    }

    public static List<Integer> getFrequencyCards(List<Integer> values, int n) {
        return values.stream()
                .filter(frequencyOfCardValuePredicate(values, n)).distinct().collect(Collectors.toList());
    }

    private static Predicate<Integer> frequencyOfCardValuePredicate(List<Integer> values, int numberOfFrequency) {
        return val -> Collections.frequency(values, val) == numberOfFrequency;
    }

    public static List<Integer> getCardsValuesFromHighest(Set<Card> cards) {
        return cards.stream().map(Card::getValue).sorted((v1, v2) -> Integer.compare(v2, v1)).collect(Collectors.toList());
    }

    public static boolean isConsecutive(List<Integer> values) {
        boolean isConsecutive = true;
        for (int i = values.size() - 1; i > 0; i--) {
            isConsecutive &= values.get(i) == values.get(i - 1) + 1;
        }
        return isConsecutive;
    }

    public static boolean isFlush(Set<Card> handGame) {
        return handGame.stream().map(Card::getSuit).distinct().count() == 1;
    }
}
