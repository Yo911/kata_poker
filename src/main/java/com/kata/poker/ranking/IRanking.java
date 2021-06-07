package com.kata.poker.ranking;

import com.kata.poker.Hand;

public interface IRanking {
    String evaluate(Hand hand);
}
