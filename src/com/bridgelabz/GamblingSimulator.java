package com.bridgelabz;

import java.util.Scanner;

public class GamblingSimulator {
    static int gamblerStack = 100;
    static void gamblingGame() {
        int wins = 0;
        int loss = 0;
        int gain = 0;
        int lost = 0;
        int daysWon = 0;
        int daysLost = 0;
        int cash = gamblerStack;
        while (cash > gamblerStack / 2 && cash < gamblerStack + gamblerStack / 2) {
            if (Math.random() < 0.5) {
                cash++;
                wins++;
                System.out.println("gambler wins, and amount available: " + cash);
            } else {
                cash--;
                loss++;
                System.out.println("gambler loses, So amount available:  " + cash);
            }
        }
            System.out.println("Gambler resigns for the day");
            System.out.println(wins + " Total wins of day");
            System.out.println(loss + " Total losses of day");
            if (cash == 150) {
                System.out.println("Gambler gains");
                gain = 50;
                daysWon++;
            }
            System.out.println("Amount won: " + gain);
            if (cash == 50) {
                System.out.println("Gambler lost");
                lost = 50;
                daysLost++;
            }
            System.out.println("amount lost: " + lost);
            System.out.println("Number of days won: "+daysWon);
            System.out.println("Number of days lost: "+daysLost);
    }
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            gamblingGame();
        }
    }
}
