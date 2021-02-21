package com.siwoo.classes.answer;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class Card {
    public static final String HEART = "HEART", SPADE = "SPADE", DIAMOND = "DIAMOND", CLUB = "CLUB", SPECIAL = "SPECIAL";
    public static final String[] SUITS = {HEART, SPADE, DIAMOND, CLUB};
    public static int HEIGHT = 10, WIDTH = 5, START_NUM = 1, END_NUM = 13;
    private static final Map<Integer, String> NUMBER_MAP;
    private final int number;
    private final String suit;
    private boolean flip;

    static {
        NUMBER_MAP = new ConcurrentHashMap<>();
        NUMBER_MAP.put(1, "A");
        NUMBER_MAP.put(11, "J");
        NUMBER_MAP.put(12, "Q");
        NUMBER_MAP.put(13, "K");
        for (int i=2; i<=10; i++)
            NUMBER_MAP.put(i, Integer.toString(i));
    }

    public static Card specialCard() {
        return new Card(0, SPECIAL);
    }
    
    public Card(int number, String suit) {
        if (!checkSuit(suit))
            throw new IllegalArgumentException();
        if (!checkNumber(number))
            throw new IllegalArgumentException();
        this.number = number;
        this.suit = suit.toUpperCase();
    }

    public static boolean checkNumber(int number) {
        return number >= 0 && number <= 13;
    }

    public static boolean checkSuit(String suit) {
        if (suit == null) return false;
        return Arrays.stream(SUITS)
                .anyMatch(s -> suit.equals(s) || suit.equals(SPECIAL));
    }

    private String getNumberFormat() {
        return NUMBER_MAP.get(this.number);
    }

    private boolean isSpecialCard() {
        return SPECIAL.equals(suit);
    }
    
    public void flip() {
        this.flip = !flip;
    }

    public void flip(boolean flip) {
        this.flip = flip;
    }

    private String getSuit() {
        return this.suit;
    }
    
    public int getNumber() {
        return number;
    }

    public boolean isFlip() {
        return flip;
    }

    public boolean isSpecial() {
        return SPECIAL.equals(suit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return number == card.number &&
                Objects.equals(suit, card.suit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, suit);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        if (flip)
            sb.append("HIDE");
        else if (isSpecialCard())
            sb.append("Jocker Card");
        else {
            sb.append(getSuit())
                    .append(" - ")
                    .append(getNumberFormat());
        }
        sb.append("]");
        return sb.toString();
    }
}
