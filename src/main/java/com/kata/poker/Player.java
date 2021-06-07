package com.kata.poker;

public class Player {
    public static final String TIE = "Tie.";

    public static final String WINS = "wins. - with";

    private final String name;

    private final Hand hand;

    public Player(String name, String handString) {
        this.name = name;
        this.hand = new Hand(handString);
    }

    public String compareHand(Player player2) {
        String player2Hand = player2.hand.evaluate();
        String playerHand = this.hand.evaluate();

        Boolean isWinner = this.hand.isBetterThan(player2.hand);

        if (isWinner == null) {
            return TIE;
        }

        return isWinner ?
                getWinner(this, playerHand) :
                getWinner(player2, player2Hand)
                ;
    }

    private String getWinner(Player player, String handPlayed) {
        return String.join(" ", player.name, WINS, handPlayed);
    }
}
