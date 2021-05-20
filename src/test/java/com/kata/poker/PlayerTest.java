package com.kata.poker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    void should_set_winner_white_when_compare_player() {
        Player player1 = new Player("Black", "2S 3D 5S 9C KD");
        Player player2 = new Player("White", "2H 3D 5S 9C 2D");

        String winner = player1.compareHand(player2);

        Assertions.assertEquals("White wins. - with pair of : 2", winner);
    }

    @Test
    void should_set_winner_black_when_compare_player() {
        Player player1 = new Player("Black", "2H 5D 5S 5C KD");
        Player player2 = new Player("White", "2H 3D 5S 9C 2D");

        String winner = player1.compareHand(player2);

        Assertions.assertEquals("Black wins. - with three of kind : 5", winner);
    }

    @Test
    void should_return_equality_when_same_hand() {
        Player player1 = new Player("Black", "3S 5C 6H JD AD");
        Player player2 = new Player("White", "3H 5D 6C JH AC");

        String winner = player1.compareHand(player2);

        Assertions.assertEquals("Tie.", winner);
    }

}