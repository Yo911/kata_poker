package com.kata.poker.ranking;

import static com.kata.poker.util.RankingUtil.getCardFromValue;
import static com.kata.poker.util.RankingUtil.getCardsValuesFromHighest;

import com.kata.poker.Hand;

import java.util.List;


public class HighRanking implements IRanking {
    private List<Integer> valuesfromHighest;

    public List<Integer> getValuesfromHighest() {
        return valuesfromHighest;
    }

    @Override
    public String evaluate(Hand hand) {
        valuesfromHighest = getCardsValuesFromHighest(hand.getHandGame());
        return getCardFromValue(hand.getHandGame(), valuesfromHighest.get(0)).getCardName();
    }
}
