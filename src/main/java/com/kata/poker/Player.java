package com.kata.poker;

public class Player {
    private String name;

    private Hand hand;

    public Player(String name, Hand hand) {
        this.name = name;
        this.hand = hand;
    }

    public Player(String name, String handString) {
        this.name = name;
        this.hand = new Hand(handString);
    }

    public String compareHand(Player player2) {
        String player2Hand = player2.hand.evaluate();
        String playerHand = this.hand.evaluate();

        return player2.name + " wins. - with " + player2Hand;
    }


}
