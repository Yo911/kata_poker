package com.kata.poker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class HandTest {

    @Test
    void should_return_ace_high_when_evaluate_hand() {
        Set<Card> handGameSet = new HashSet<>();
        handGameSet.add(new Card(1, Card.Suit.S));
        handGameSet.add(new Card(2, Card.Suit.C));
        handGameSet.add(new Card(5, Card.Suit.S));
        handGameSet.add(new Card(11, Card.Suit.D));
        handGameSet.add(new Card(8, Card.Suit.H));
        Hand hand = new Hand(handGameSet);

        String evaluateResult = hand.evaluate();

        Assertions.assertEquals("high card: Ace", evaluateResult);
    }

    @Test
    void should_return_king_high_when_evaluate_hand() {
        Set<Card> handGameSet = new HashSet<>();
        handGameSet.add(new Card(13, Card.Suit.S));
        handGameSet.add(new Card(2, Card.Suit.C));
        handGameSet.add(new Card(5, Card.Suit.S));
        handGameSet.add(new Card(11, Card.Suit.D));
        handGameSet.add(new Card(8, Card.Suit.H));
        Hand hand = new Hand(handGameSet);

        String evaluateResult = hand.evaluate();

        Assertions.assertEquals("high card: King", evaluateResult);
    }

    @Test
    void should_return_7_high_when_evaluate_hand() {
        Set<Card> handGameSet = new HashSet<>();
        handGameSet.add(new Card(7, Card.Suit.S));
        handGameSet.add(new Card(6, Card.Suit.C));
        handGameSet.add(new Card(5, Card.Suit.S));
        handGameSet.add(new Card(4, Card.Suit.D));
        handGameSet.add(new Card(2, Card.Suit.H));
        Hand hand = new Hand(handGameSet);

        String evaluateResult = hand.evaluate();

        Assertions.assertEquals("high card: 7", evaluateResult);
    }

    @Test
    void should_return_pair_of_7_when_evaluate_hand() {
        Set<Card> handGameSet = new HashSet<>();
        handGameSet.add(new Card(7, Card.Suit.S));
        handGameSet.add(new Card(7, Card.Suit.C));
        handGameSet.add(new Card(5, Card.Suit.S));
        handGameSet.add(new Card(4, Card.Suit.D));
        handGameSet.add(new Card(2, Card.Suit.H));
        Hand hand = new Hand(handGameSet);

        String evaluateResult = hand.evaluate();

        Assertions.assertEquals("pair of : 7", evaluateResult);
    }

    @Test
    void should_return_pair_of_jack_when_evaluate_hand() {
        Set<Card> handGameSet = new HashSet<>();
        handGameSet.add(new Card(11, Card.Suit.S));
        handGameSet.add(new Card(11, Card.Suit.C));
        handGameSet.add(new Card(5, Card.Suit.S));
        handGameSet.add(new Card(4, Card.Suit.D));
        handGameSet.add(new Card(2, Card.Suit.H));
        Hand hand = new Hand(handGameSet);

        String evaluateResult = hand.evaluate();

        Assertions.assertEquals("pair of : Jack", evaluateResult);
    }

}