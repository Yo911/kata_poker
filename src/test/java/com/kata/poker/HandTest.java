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
        Assertions.assertEquals(Rank.HIGH.getRankValue(), hand.getRank().getRankValue());
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
        Assertions.assertEquals(Rank.HIGH.getRankValue(), hand.getRank().getRankValue());
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
        Assertions.assertEquals(Rank.HIGH.getRankValue(), hand.getRank().getRankValue());
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
        Assertions.assertEquals(Rank.PAIR.getRankValue(), hand.getRank().getRankValue());
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
        Assertions.assertEquals(Rank.PAIR.getRankValue(), hand.getRank().getRankValue());
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
        Assertions.assertEquals(Rank.TWO_PAIR.getRankValue(), hand.getRank().getRankValue());
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
        Assertions.assertEquals(Rank.TWO_PAIR.getRankValue(), hand.getRank().getRankValue());
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
        Assertions.assertEquals(Rank.THREE_OF_KIND.getRankValue(), hand.getRank().getRankValue());
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
        Assertions.assertEquals(Rank.STRAIGHT.getRankValue(), hand.getRank().getRankValue());
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
        Assertions.assertEquals(Rank.STRAIGHT.getRankValue(), hand.getRank().getRankValue());
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
        Assertions.assertEquals(Rank.FLUSH.getRankValue(), hand.getRank().getRankValue());
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
        Assertions.assertEquals(Rank.FULL.getRankValue(), hand.getRank().getRankValue());
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

        Assertions.assertEquals("four of kind : 10", evaluateResult);
        Assertions.assertEquals(Rank.FOUR_OF_KIND.getRankValue(), hand.getRank().getRankValue());
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
        Assertions.assertEquals(Rank.STRAIGHT_FLUSH.getRankValue(), hand.getRank().getRankValue());
    }

    @Test
    void should_failed_when_get_hand_from_string() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Hand("5S 4D"));
    }

    @Test
    void should_return_false_when_test_if_is_better_than_adverse_hand() {
        Hand hand = new Hand("2H 3D 5S 2C 2D");
        Hand adverse = new Hand("2S 5D 5S 5C KD");
        hand.evaluate();
        adverse.evaluate();

        Assertions.assertFalse(hand.isBetterThan(adverse));
    }

    @Test
    void should_return_true_when_test_if_is_better_than_adverse_hand() {
        Hand hand = new Hand("2S 5D 5S 5C KD");
        Hand adverse = new Hand("2H 3D 5S 8C 2D");
        hand.evaluate();
        adverse.evaluate();

        Assertions.assertTrue(hand.isBetterThan(adverse));
    }

    @Test
    void should_return_true_when_test_if_is_better_than_adverse_hand_and_have_same_rank() {
        Hand hand = new Hand("2S 5D 5S 5C KD");
        Hand adverse = new Hand("2H 3D 5S 2C 2D");
        hand.evaluate();
        adverse.evaluate();

        Assertions.assertTrue(hand.isBetterThan(adverse));
    }

    @Test
    void should_return_false_when_test_if_is_better_than_adverse_hand_and_have_same_pair() {
        Hand hand = new Hand("2S 2D 3S 5C KD");
        Hand adverse = new Hand("2H 3D 5S 2C AD");
        hand.evaluate();
        adverse.evaluate();

        Assertions.assertFalse(hand.isBetterThan(adverse));
    }

}