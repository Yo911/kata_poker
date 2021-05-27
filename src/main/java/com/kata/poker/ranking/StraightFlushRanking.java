package com.kata.poker.ranking;

import com.kata.poker.Card;
import com.kata.poker.Hand;

import java.util.List;

import static com.kata.poker.util.RankingUtil.*;

public class StraightFlushRanking implements IRanking{
    private List<Integer> valuesfromHighest;

    @Override
    public String evaluate(Hand hand) {
        valuesfromHighest = getCardsValuesFromHighest(hand.getHandGame());
        Card card = getCardFromValue(hand.getHandGame(), valuesfromHighest.get(0));
        return isFlush(hand.getHandGame()) && isConsecutive(hand.getValues()) ?
                card.getCardName():
                null;
    }

    @Override
    public List<Integer> getValuesfromHighest() {
        return valuesfromHighest;
    }
}
