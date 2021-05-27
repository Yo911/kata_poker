package com.kata.poker.ranking;

import com.kata.poker.Hand;

import java.util.List;

public interface IRanking {
    String evaluate(Hand hand);

    List<Integer> getValuesfromHighest();
}
