package com.kata.poker.ranking;

import com.kata.poker.Hand;

import java.util.List;

import static com.kata.poker.util.RankingUtil.*;

public class MultipleCardsRanking implements IRanking {
    private int numbers;

    private List<Integer> valuesfromHighest;

    public MultipleCardsRanking(int numbers) {
        this.numbers = numbers;
    }

    @Override
    public String evaluate(Hand hand) {
        List<Integer> frequencyCards = getFrequencyCards(hand.getValues(), this.numbers);
        if (frequencyCards.isEmpty()) {
            return null;
        }
        valuesfromHighest = getCardsValuesFromHighest(hand.getHandGame());
        valuesfromHighest.removeAll(frequencyCards);
        Integer multiple = frequencyCards.get(0);
        valuesfromHighest.add(0, multiple);
        return getCardFromValue(hand.getHandGame(), multiple).getCardName();
    }

    @Override
    public List<Integer> getValuesfromHighest() {
        return valuesfromHighest;
    }
}
