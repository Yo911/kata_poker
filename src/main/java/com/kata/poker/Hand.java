package com.kata.poker;

import java.util.*;
import java.util.stream.Collectors;

public class Hand {
    private Set<Card> handGame;

    private List<Integer> values;

    private Rank rank;

    private String winsCards;

    public Hand(Set<Card> handGame) {
        this.handGame = handGame;
        this.values = handGame.stream().map(Card::getValue).sorted().collect(Collectors.toList());
    }

    public Rank getRank() {
        return rank;
    }

    public String evaluate() {
        String wins;
        for (Rank value : Rank.values()) {
            wins = value.evaluate(this.handGame, this.values);
            if (wins != null) {
                this.rank = value;
                this.winsCards = wins;
                return getHandEvaluation();
            }
        }
        return null;
    }

    private String getHandEvaluation() {
        return this.rank.rankToString(this.winsCards);
    }

    @Override
    public String toString() {
        return this.handGame.stream().map(Card::getCard).collect(Collectors.joining(" "));
    }
}
