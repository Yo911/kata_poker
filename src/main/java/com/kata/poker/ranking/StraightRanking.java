package com.kata.poker.ranking;

import com.kata.poker.Hand;

import java.util.List;

import static com.kata.poker.util.RankingUtil.*;

public class StraightRanking implements IRanking {
    private List<Integer> valuesfromHighest;

    @Override
    public String evaluate(Hand hand) {
        valuesfromHighest = getCardsValuesFromHighest(hand.getHandGame());
        return isConsecutive(hand.getValues()) ?
                getCardFromValue(hand.getHandGame(), valuesfromHighest.get(0)).getCardName():
                null;
    }

    @Override
    public List<Integer> getValuesfromHighest() {
        return valuesfromHighest;
    }
}
