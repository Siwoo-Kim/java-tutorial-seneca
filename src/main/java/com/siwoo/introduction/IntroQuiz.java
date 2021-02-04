package com.siwoo.introduction;

/**
 * java DooBee
 * DooBeeDooBeeDo
 * 
 * 
 */
public class IntroQuiz {

    public static void main(String[] args) {
        DooBee dooBee = new DooBee();
        dooBee.dooBee();
    }
}


class DooBee {
    
    public void dooBee() {
        int x = 1;
        while (x < 3) {
            System.out.print("Doo");
            System.out.print("Bee");
            x = x + 1;
        }
        if (x == 3) {
            System.out.print("Do");
        }
    }
}