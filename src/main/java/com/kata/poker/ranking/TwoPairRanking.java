package com.kata.poker.ranking;

import com.kata.poker.Card;
import com.kata.poker.Hand;

import java.util.List;
import java.util.stream.Collectors;

import static com.kata.poker.util.RankingUtil.*;

public class TwoPairRanking implements IRanking {
    private List<Integer> valuesfromHighest;

    @Override
    public String evaluate(Hand hand) {
        List<Integer> frequencyCards = getFrequencyCards(hand.getValues(), 2);
        if (frequencyCards.size() != 2) {
            return null;
        }
        valuesfromHighest = getCardsValuesFromHighest(hand.getHandGame());
        valuesfromHighest.removeAll(frequencyCards);
        frequencyCards.stream().sorted().forEach(pair -> valuesfromHighest.add(0, pair));
        return frequencyCards.stream().map(pair -> getCardFromValue(hand.getHandGame(), pair))
                .map(Card::getCardName)
                .collect(Collectors.joining(" and "));
    }

    @Override
    public List<Integer> getValuesfromHighest() {
        return valuesfromHighest;
    }
}
