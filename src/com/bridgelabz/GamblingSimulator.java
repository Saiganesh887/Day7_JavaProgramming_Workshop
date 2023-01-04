package com.bridgelabz;

public class GamblingSimulator {
    static int gamblerStake = 100;
    static void gamblingGame(int numOfGames) {
        int bets = 0;
        for (int i = 0; i < numOfGames; i++) {
            int cash = gamblerStake;
            while(cash > 0){
                bets++;
                if(Math.random() < 0.5){
                    System.out.println("gambler wins");
                    cash++;
                }else{
                    System.out.println("gambler loses");
                    cash--;
                }
            }
        }
    }
    public static void main(String[] args) {

    }
}
