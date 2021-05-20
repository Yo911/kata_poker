package com.kata.poker;

import java.util.*;
import java.util.stream.Collectors;

public class Hand {
    public static final String SEPARATOR = " ";

    private Set<Card> handGame;

    private List<Integer> values;

    private List<Integer> highestCards;

    private Rank rank;

    private String winsCards;

    public Hand(Set<Card> handGame) {
        if (handGame == null || handGame.size() != 5) {
            throw new IllegalArgumentException("a Hand should have 5 card");
        }
        this.handGame = handGame;
        this.values = handGame.stream().map(Card::getValue).sorted().collect(Collectors.toList());
        this.highestCards = new ArrayList<>(handGame.size());
    }

    public Hand(String hand) {
        this(Arrays.stream(hand.split(SEPARATOR)).map(Card::new).collect(Collectors.toSet()));
    }

    public Rank getRank() {
        return rank;
    }

    public String evaluate() {
        for (Rank value : Rank.values()) {
            this.winsCards = value.evaluate(this.handGame, this.values, this.highestCards);
            if (this.winsCards != null) {
                this.rank = value;
                return getHandEvaluation();
            }
        }
        return null;
    }

    public boolean isBetterThan(Hand adverseHand) {
        if (this.rank.getRankValue() != adverseHand.rank.getRankValue()) {
            return this.rank.getRankValue() > adverseHand.rank.getRankValue();
        }

        for (int i = 0; i < this.highestCards.size(); i++) {
            Integer highCard = this.highestCards.get(i);
            Integer adverseHighCard = adverseHand.highestCards.get(i);
            return highCard > adverseHighCard;
        }

        return false;
    }

    private String getHandEvaluation() {
        return this.rank.rankToString(this.winsCards);
    }

    @Override
    public String toString() {
        return this.handGame.stream().map(Card::getCard).collect(Collectors.joining(" "));
    }
}
