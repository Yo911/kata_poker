package com.kata.poker.ranking;

import com.kata.poker.Hand;

import java.util.List;

import static com.kata.poker.util.RankingUtil.*;

public class StraightRanking implements IRanking {
    @Override
    public String evaluate(Hand hand) {
        List<Integer> valuesfromHighest = getCardsValuesFromHighest(hand.getHandGame());
        hand.setHighestCards(valuesfromHighest);
        return isConsecutive(hand.getValues()) ?
                getCardFromValue(hand.getHandGame(), valuesfromHighest.get(0)).getCardName():
                null;
    }
}
