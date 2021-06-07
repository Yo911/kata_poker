package com.kata.poker.ranking;

import com.kata.poker.Hand;

import java.util.List;

import static com.kata.poker.util.RankingUtil.*;

public class MultipleCardsRanking implements IRanking {
    private int numbers;

    public MultipleCardsRanking(int numbers) {
        this.numbers = numbers;
    }

    @Override
    public String evaluate(Hand hand) {
        List<Integer> frequencyCards = getFrequencyCards(hand.getValues(), this.numbers);
        if (frequencyCards.isEmpty()) {
            return null;
        }
        List<Integer> valuesfromHighest = getCardsValuesFromHighest(hand.getHandGame());
        valuesfromHighest.removeAll(frequencyCards);
        Integer multiple = frequencyCards.get(0);
        valuesfromHighest.add(0, multiple);
        hand.setHighestCards(valuesfromHighest);
        return getCardFromValue(hand.getHandGame(), multiple).getCardName();
    }
}
