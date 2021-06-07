package com.kata.poker.ranking;

import com.kata.poker.Card;
import com.kata.poker.Hand;
import java.util.List;
import java.util.Set;

import static com.kata.poker.util.RankingUtil.getCardFromValue;
import static com.kata.poker.util.RankingUtil.getFrequencyCards;

public class FullRanking implements IRanking{

    @Override
    public String evaluate(Hand hand) {
        List<Integer> threeOfKindCards = getFrequencyCards(hand.getValues(), 3);
        List<Integer> pairCards = getFrequencyCards(hand.getValues(), 2);
        if (threeOfKindCards.isEmpty() || pairCards.isEmpty()) {
            return null;
        }
        Integer threeOfKindValue = threeOfKindCards.get(0);
        Integer pairValue = pairCards.get(0);
        List<Integer> valuesfromHighest = List.of(threeOfKindValue, pairValue);
        hand.setHighestCards(valuesfromHighest);
        Set<Card> handGame = hand.getHandGame();
        return getCardFromValue(handGame, threeOfKindValue).getCardName() + " over " + getCardFromValue(handGame, pairValue).getCardName();
    }
}
