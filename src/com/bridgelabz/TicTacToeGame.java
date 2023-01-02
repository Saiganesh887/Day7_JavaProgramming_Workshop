package com.bridgelabz;

import java.util.Scanner;

public class TicTacToeGame {
    static char[] board = new char[10];
    static char playerLetter;
    static char computerLetter;
    static void createEmptyBoard(){
        for(int i = 1; i < board.length; i++){
            board[i] = ' ';
        }
    }
    static void chooseInputLetter(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a letter for you ( X  or  O ) to play game : ");
        playerLetter = sc.next().toUpperCase().charAt(0);
        if(playerLetter == 'X')
            computerLetter = 'O';
        if(playerLetter == 'O')
            computerLetter = 'X';
    }
    public static void main(String[] args) {
        createEmptyBoard();
        chooseInputLetter();
    }
}
