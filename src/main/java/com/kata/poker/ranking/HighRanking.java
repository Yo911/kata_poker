package com.kata.poker.ranking;

import static com.kata.poker.util.RankingUtil.getCardFromValue;
import static com.kata.poker.util.RankingUtil.getCardsValuesFromHighest;

import com.kata.poker.Hand;

import java.util.List;


public class HighRanking implements IRanking {

    @Override
    public String evaluate(Hand hand) {
        List<Integer> valuesfromHighest = getCardsValuesFromHighest(hand.getHandGame());
        hand.setHighestCards(valuesfromHighest);
        return getCardFromValue(hand.getHandGame(), valuesfromHighest.get(0)).getCardName();
    }
}
