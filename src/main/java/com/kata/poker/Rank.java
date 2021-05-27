package com.kata.poker;

import com.kata.poker.ranking.*;

public enum Rank {
    STRAIGHT_FLUSH(8, "straight flush of", new StraightFlushRanking()),
    FOUR_OF_KIND(7, "four of kind", new FourOfKindRanking()),
    FULL(6, "full of", new FullRanking()),
    FLUSH(5, "flush of", new FlushRanking()),
    STRAIGHT(4, "straight of", new StraightRanking()),
    THREE_OF_KIND(3, "three of kind", new ThreeOfKindRanking()),
    TWO_PAIR(2, "two pair of", new TwoPairRanking()),
    PAIR(1, "pair of", new PairRanking()),
    HIGH(0, "high card", new HighRanking());

    private final int rankValue;

    private final String rankString;

    private final IRanking ranking;

    Rank(int rankValue, String rankString, IRanking ranking) {
        this.rankValue = rankValue;
        this.rankString = rankString;
        this.ranking = ranking;
    }

    public int getRankValue() {
        return rankValue;
    }

    public String getRankString() {
        return rankString;
    }

    public IRanking getRanking() {
        return ranking;
    }

    public String evaluate(Hand hand) {
        return this.ranking.evaluate(hand);
    }
}
