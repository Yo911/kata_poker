package com.kata.poker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class HandTest {

    @Test
    void should_return_ace_high_when_evaluate_hand() {
        Set<Card> handGameSet = new HashSet<>();
        handGameSet.add(new Card(12, Card.Suit.S));
        handGameSet.add(new Card(0, Card.Suit.C));
        handGameSet.add(new Card(3, Card.Suit.S));
        handGameSet.add(new Card(9, Card.Suit.D));
        handGameSet.add(new Card(6, Card.Suit.H));
        Hand hand = new Hand(handGameSet);

        String evaluateResult = hand.evaluate();

        Assertions.assertEquals("high card: Ace", evaluateResult);
    }

    @Test
    void should_return_king_high_when_evaluate_hand() {
        Set<Card> handGameSet = new HashSet<>();
        handGameSet.add(new Card(11, Card.Suit.S));
        handGameSet.add(new Card(0, Card.Suit.C));
        handGameSet.add(new Card(3, Card.Suit.S));
        handGameSet.add(new Card(9, Card.Suit.D));
        handGameSet.add(new Card(6, Card.Suit.H));
        Hand hand = new Hand(handGameSet);

        String evaluateResult = hand.evaluate();

        Assertions.assertEquals("high card: King", evaluateResult);
    }

    @Test
    void should_return_7_high_when_evaluate_hand() {
        Set<Card> handGameSet = new HashSet<>();
        handGameSet.add(new Card(5, Card.Suit.S));
        handGameSet.add(new Card(4, Card.Suit.C));
        handGameSet.add(new Card(3, Card.Suit.S));
        handGameSet.add(new Card(2, Card.Suit.D));
        handGameSet.add(new Card(0, Card.Suit.H));
        Hand hand = new Hand(handGameSet);

        String evaluateResult = hand.evaluate();

        Assertions.assertEquals("high card: 7", evaluateResult);
    }

    @Test
    void should_return_pair_of_7_when_evaluate_hand() {
        Set<Card> handGameSet = new HashSet<>();
        handGameSet.add(new Card(5, Card.Suit.S));
        handGameSet.add(new Card(5, Card.Suit.C));
        handGameSet.add(new Card(3, Card.Suit.S));
        handGameSet.add(new Card(2, Card.Suit.D));
        handGameSet.add(new Card(0, Card.Suit.H));
        Hand hand = new Hand(handGameSet);

        String evaluateResult = hand.evaluate();

        Assertions.assertEquals("pair of : 7", evaluateResult);
    }

    @Test
    void should_return_pair_of_jack_when_evaluate_hand() {
        Set<Card> handGameSet = new HashSet<>();
        handGameSet.add(new Card(9, Card.Suit.S));
        handGameSet.add(new Card(9, Card.Suit.C));
        handGameSet.add(new Card(3, Card.Suit.S));
        handGameSet.add(new Card(2, Card.Suit.D));
        handGameSet.add(new Card(0, Card.Suit.H));
        Hand hand = new Hand(handGameSet);

        String evaluateResult = hand.evaluate();

        Assertions.assertEquals("pair of : Jack", evaluateResult);
    }

    @Test
    void should_return_two_pair_of_5_and_7_when_evaluate_hand() {
        Set<Card> handGameSet = new HashSet<>();
        handGameSet.add(new Card(3, Card.Suit.S));
        handGameSet.add(new Card(5, Card.Suit.C));
        handGameSet.add(new Card(3, Card.Suit.S));
        handGameSet.add(new Card(5, Card.Suit.D));
        handGameSet.add(new Card(0, Card.Suit.H));
        Hand hand = new Hand(handGameSet);

        String evaluateResult = hand.evaluate();

        Assertions.assertEquals("two pair of : 5 and 7", evaluateResult);
    }

    @Test
    void should_return_two_pair_of_queen_and_ace_when_evaluate_hand() {
        Set<Card> handGameSet = new HashSet<>();
        handGameSet.add(new Card(12, Card.Suit.S));
        handGameSet.add(new Card(10, Card.Suit.C));
        handGameSet.add(new Card(10, Card.Suit.S));
        handGameSet.add(new Card(12, Card.Suit.D));
        handGameSet.add(new Card(0, Card.Suit.H));
        Hand hand = new Hand(handGameSet);

        String evaluateResult = hand.evaluate();

        Assertions.assertEquals("two pair of : Queen and Ace", evaluateResult);
    }

    @Test
    void should_return_three_of_kind_of_3_when_evaluate_hand() {
        Set<Card> handGameSet = new HashSet<>();
        handGameSet.add(new Card(1, Card.Suit.S));
        handGameSet.add(new Card(1, Card.Suit.C));
        handGameSet.add(new Card(12, Card.Suit.S));
        handGameSet.add(new Card(1, Card.Suit.D));
        handGameSet.add(new Card(0, Card.Suit.H));
        Hand hand = new Hand(handGameSet);

        String evaluateResult = hand.evaluate();

        Assertions.assertEquals("three of kind : 3", evaluateResult);
    }

    @Test
    void should_return_straingth_of_6_when_evaluate_hand() {
        Set<Card> handGameSet = new HashSet<>();
        handGameSet.add(new Card(0, Card.Suit.S));
        handGameSet.add(new Card(1, Card.Suit.C));
        handGameSet.add(new Card(2, Card.Suit.S));
        handGameSet.add(new Card(3, Card.Suit.D));
        handGameSet.add(new Card(4, Card.Suit.H));
        Hand hand = new Hand(handGameSet);

        String evaluateResult = hand.evaluate();

        Assertions.assertEquals("straight of : 6", evaluateResult);
    }

    @Test
    void should_return_straingth_of_queen_when_evaluate_hand() {
        Set<Card> handGameSet = new HashSet<>();
        handGameSet.add(new Card(6, Card.Suit.S));
        handGameSet.add(new Card(7, Card.Suit.C));
        handGameSet.add(new Card(8, Card.Suit.S));
        handGameSet.add(new Card(9, Card.Suit.D));
        handGameSet.add(new Card(10, Card.Suit.H));
        Hand hand = new Hand(handGameSet);

        String evaluateResult = hand.evaluate();

        Assertions.assertEquals("straight of : Queen", evaluateResult);
    }

    @Test
    void should_return_flush_of_queen_when_evaluate_hand() {
        Set<Card> handGameSet = new HashSet<>();
        handGameSet.add(new Card(6, Card.Suit.S));
        handGameSet.add(new Card(7, Card.Suit.S));
        handGameSet.add(new Card(8, Card.Suit.S));
        handGameSet.add(new Card(2, Card.Suit.S));
        handGameSet.add(new Card(10, Card.Suit.S));
        Hand hand = new Hand(handGameSet);

        String evaluateResult = hand.evaluate();

        Assertions.assertEquals("flush of : Queen", evaluateResult);
    }

    @Test
    void should_return_full_of_10_by_8_when_evaluate_hand() {
        Set<Card> handGameSet = new HashSet<>();
        handGameSet.add(new Card(6, Card.Suit.S));
        handGameSet.add(new Card(6, Card.Suit.H));
        handGameSet.add(new Card(8, Card.Suit.D));
        handGameSet.add(new Card(8, Card.Suit.C));
        handGameSet.add(new Card(8, Card.Suit.S));
        Hand hand = new Hand(handGameSet);

        String evaluateResult = hand.evaluate();

        Assertions.assertEquals("full of : 10 over 8", evaluateResult);
    }

    @Test
    void should_return_four_of_kind_of_10_when_evaluate_hand() {
        Set<Card> handGameSet = new HashSet<>();
        handGameSet.add(new Card(6, Card.Suit.S));
        handGameSet.add(new Card(8, Card.Suit.H));
        handGameSet.add(new Card(8, Card.Suit.D));
        handGameSet.add(new Card(8, Card.Suit.C));
        handGameSet.add(new Card(8, Card.Suit.S));
        Hand hand = new Hand(handGameSet);

        String evaluateResult = hand.evaluate();

        Assertions.assertEquals("three of kind : 10", evaluateResult);
    }

    @Test
    void should_return_straight_flush_of_10_when_evaluate_hand() {
        Set<Card> handGameSet = new HashSet<>();
        handGameSet.add(new Card(4, Card.Suit.H));
        handGameSet.add(new Card(5, Card.Suit.H));
        handGameSet.add(new Card(6, Card.Suit.H));
        handGameSet.add(new Card(7, Card.Suit.H));
        handGameSet.add(new Card(8, Card.Suit.H));
        Hand hand = new Hand(handGameSet);

        String evaluateResult = hand.evaluate();

        Assertions.assertEquals("straight flush of : 10", evaluateResult);
    }

}