package com.siwoo.classes.answer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import static com.siwoo.classes.answer.Card.*;

public class CardPack {
    private Map<String, Card[]> cardPack = new LinkedHashMap<>();
    
    public CardPack() {
        for (String s: SUITS) {
            Card[] cards = new Card[END_NUM];
            cardPack.put(s, cards);
            for (int i = START_NUM; i <= END_NUM; i++)
                cards[i-1] = new Card(i, s);
        }
    }

    public CardPack(Card[] jockers) {
        this();
        for (Card card: jockers)
            if (card == null)
                throw new IllegalArgumentException();
        cardPack.put(SPECIAL, Arrays.copyOf(jockers, jockers.length));
    }
    
    public CardPack(Card jocker) {
        this(new Card[]{jocker});
    }

    public int numberOfCards() {
        int cnt = 0;
        for (String suit: cardPack.keySet())
            cnt += cardPack.get(suit).length;
        return cnt;
    }
    
    public Card[] getCards(String suit) {
        checkSuit(suit);
        return Arrays.copyOf(cardPack.get(suit), 
                cardPack.get(suit).length);
    }

    public Card[] getCards(int number) {
        checkNumber(number);
        Card[] cards = new Card[4];
        int i = 0;
        for (String suit: cardPack.keySet())
            if (!suit.equals(SPECIAL))
                cards[i++] = cardPack.get(suit)[number-1];
        return cards;
    }
    
    public void flip() {
        cardPack.values()
                .stream()
                .flatMap(Arrays::stream)
                .forEach(Card::flip);
    }
    
    public void flip(boolean f) {
        cardPack.values()
                .stream()
                .flatMap(Arrays::stream)
                .forEach(c -> c.flip(f));
    }

    public void sort(String[] precedencesOfSuit) {
        Map<String, Card[]> newPack = new LinkedHashMap<>(); 
        for (String suit: precedencesOfSuit) {
            checkSuit(suit);
            Card[] cards = getCards(suit);
            Arrays.sort(cards, Comparator.comparingInt(Card::getNumber));
            newPack.put(suit, cards);
        }
        //remain cards
        for (String suit: cardPack.keySet())
            if (!newPack.containsKey(suit)) {
                Card[] cards = getCards(suit);
                Arrays.sort(cards, Comparator.comparingInt(Card::getNumber));
                newPack.put(suit, cards);
            }
        this.cardPack = newPack;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CardPack[\n");
        for (String s: cardPack.keySet()) {
            sb.append(Arrays.toString(cardPack.get(s)))
                    .append("\n");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        CardPack cardPack = new CardPack(Card.specialCard());
        System.out.println(cardPack);
        System.out.println(cardPack.numberOfCards());
        System.out.println(Arrays.toString(cardPack.getCards(3)));
        System.out.println(Arrays.toString(cardPack.getCards(SPADE)));
        cardPack.flip();
        System.out.println(cardPack);
        cardPack.flip();
        System.out.println(cardPack);
        cardPack.sort(new String[]{SPADE, DIAMOND, HEART});
        System.out.println(cardPack);
    }
}
