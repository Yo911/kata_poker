package com.kata.poker;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public enum Rank {
    STRAIGHT_FLUSH(8) {
        @Override
        public String rankToString(String cards) {
            return "straight flush of : " + cards;
        }

        @Override
        public String evaluate(Set<Card> handGame, List<Integer> values, List<Integer> highestCards) {
            if (isConsecutive(values) && isFlush(handGame)) {
                return evaluateHighCard(handGame).getCardName();
            }
            return null;
        }
    },
    FOUR_OF_KIND(7) {
        @Override
        public String rankToString(String cards) {
            return "four of kind : " + cards;
        }

        @Override
        public String evaluate(Set<Card> handGame, List<Integer> values, List<Integer> highestCards) {
            Card numbersOfKind = getNumbersOfKind(handGame, values, 4);
            return numbersOfKind != null ? numbersOfKind.getCardName() : null;
        }
    },
    FULL(6) {
        @Override
        public String rankToString(String cards) {
            return "full of : " + cards;
        }

        @Override
        public String evaluate(Set<Card> handGame, List<Integer> values, List<Integer> highestCards) {
            Card threeOfKind = getNumbersOfKind(handGame, values, 3);
            List<Integer> paires = getPaires(values);
            if (threeOfKind == null || paires.size() != 1) {
                return null;
            }
            return threeOfKind.getCardName() + " over " + getCardFromValue(handGame, paires.get(0)).getCardName();
        }
    },
    FLUSH(5) {
        @Override
        public String rankToString(String cards) {
            return "flush of : " + cards;
        }

        @Override
        public String evaluate(Set<Card> handGame, List<Integer> values, List<Integer> highestCards) {
            return isFlush(handGame) ? evaluateHighCard(handGame).getCardName() : null;
        }
    },
    STRAIGHT(4) {
        @Override
        public String rankToString(String cards) {
            return "straight of : " + cards;
        }

        @Override
        public String evaluate(Set<Card> handGame, List<Integer> values, List<Integer> highestCards) {
            return isConsecutive(values) ? evaluateHighCard(handGame).getCardName() : null;
        }
    },
    THREE_OF_KIND(3) {
        @Override
        public String rankToString(String cards) {
            return "three of kind : " + cards;
        }

        @Override
        public String evaluate(Set<Card> handGame, List<Integer> values, List<Integer> highestCards) {
            Card numbersOfKind = getNumbersOfKind(handGame, values, 3);
            if (numbersOfKind != null) {
                highestCards.add(numbersOfKind.getValue());
                return numbersOfKind.getCardName();
            }
            return null;
        }
    },
    TWO_PAIR(2) {
        @Override
        public String rankToString(String cards) {
            return "two pair of : " + cards;
        }

        @Override
        public String evaluate(Set<Card> handGame, List<Integer> values, List<Integer> highestCards) {
            List<Integer> paires = getPaires(values);
            boolean b = paires.size() == 2;
            return paires.size() == 2 ? paires.stream().map(pair -> getCardFromValue(handGame, pair))
                    .map(Card::getCardName)
                    .collect(Collectors.joining(" and ")) : null;
        }
    },
    PAIR(1) {
        @Override
        public String rankToString(String cards) {
            return "pair of : " + cards;
        }

        @Override
        public String evaluate(Set<Card> handGame, List<Integer> values, List<Integer> highestCards) {
            List<Integer> paires = getPaires(values);
            return paires.size() == 1 ? getCardFromValue(handGame, paires.get(0)).getCardName() : null;
        }
    },
    HIGH(0) {
        @Override
        public String rankToString(String cards) {
            return "high card: " + cards;
        }

        @Override
        public String evaluate(Set<Card> handGame, List<Integer> values, List<Integer> highestCards) {
            return evaluateHighCard(handGame).getCardName();
        }
    };

    private int rankValue;

    private String rankString;

    Rank(int rankValue) {
        this.rankValue = rankValue;
    }

    public int getRankValue() {
        return rankValue;
    }

    public abstract String rankToString(String cards);

    public abstract String evaluate(Set<Card> handGame, List<Integer> values, List<Integer> highestCards);

    protected boolean isFlush(Set<Card> handGame) {
        return handGame.stream().map(Card::getSuit).distinct().count() == 1;
    }

    protected boolean isConsecutive(List<Integer> values) {
        boolean isConsecutive = true;
        for (int i = values.size() - 1; i > 0; i--) {
            isConsecutive &= values.get(i) == values.get(i - 1) + 1;
        }
        return isConsecutive;
    }

    protected Card getCardFromValue(Set<Card> handGame, int paireValue) {
        return handGame.stream()
                .filter(c -> c.getValue() == paireValue).findFirst().orElse(null);
    }

    protected List<Integer> getPaires(List<Integer> values) {
        List<Integer> paires = values.stream()
                .filter(frequencyOfCardValuePredicate(values, 2)).distinct().collect(Collectors.toList());
        return paires;
    }

    protected Card getNumbersOfKind(Set<Card> handGame, List<Integer> values, int numberOfFrequency) {
        Optional<Integer> numberOfKinds = values.stream()
                .filter(frequencyOfCardValuePredicate(values, numberOfFrequency)).findFirst();
        return numberOfKinds.isEmpty() ? null : getCardFromValue(handGame, numberOfKinds.get());
    }

    protected Predicate<Integer> frequencyOfCardValuePredicate(List<Integer> values, int numberOfFrequency) {
        return val -> Collections.frequency(values, val) == numberOfFrequency;
    }

    protected Card evaluateHighCard(Set<Card> handGame) {
        return handGame.stream().max(Comparator.comparingInt(Card::getValue)).orElse(null);
    }
}
