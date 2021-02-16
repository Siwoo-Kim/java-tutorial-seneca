package com.siwoo.classes;

public class StaticClass {
    
    public static class Card {
        public static int HEIGHT, WIDTH = 10;
        public int number;
        public String suit;

        public Card(int number, String suit) {
            this.number = number;
            this.suit = suit;
        }
        
        @Override
        public String toString() {
            return String.format("[%s - %d] (%d, %d)", suit, number, HEIGHT, WIDTH);
        }
    }


    public static void main(String[] args) {
        Card[] cards = {
            new Card(1, "HEART"),
            new Card(2, "HEART"),
            new Card(3, "HEART"),
            new Card(4, "HEART"),

        new Card(1, "CLOVER"),
        new Card(2, "CLOVER"),
        new Card(3, "CLOVER"),
         new Card(4, "CLOVER"),
        };
        
        for (Card card: cards)
            System.out.println(card);
        
        cards[0].number = 5;

        for (Card card: cards)
            System.out.println(card);
        
        Card.HEIGHT = 100;

        for (Card card: cards)
            System.out.println(card);

    }
}
