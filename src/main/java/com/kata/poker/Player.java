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

        String winHand;
        Player winPlayer;

        if (player2.hand.getRank().getRankValue() > this.hand.getRank().getRankValue()) {
            winHand = player2Hand;
            winPlayer = player2;
        } else {
            winHand = playerHand;
            winPlayer = this;
        }

        return getWinner(winPlayer, winHand);
    }

    private String getWinner(Player player, String handPlayed) {
        return player.name + " wins. - with " + handPlayed;
    }


}
