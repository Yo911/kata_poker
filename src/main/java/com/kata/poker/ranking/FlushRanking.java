package com.kata.poker.ranking;

import com.kata.poker.Card;
import com.kata.poker.Hand;

import java.util.List;

import static com.kata.poker.util.RankingUtil.*;

public class FlushRanking implements IRanking{

    @Override
    public String evaluate(Hand hand) {
        List<Integer> valuesfromHighest = getCardsValuesFromHighest(hand.getHandGame());
        hand.setHighestCards(valuesfromHighest);
        Card card = getCardFromValue(hand.getHandGame(), valuesfromHighest.get(0));
        return isFlush(hand.getHandGame()) ?
                card.getCardName():
                null;
    }
}
