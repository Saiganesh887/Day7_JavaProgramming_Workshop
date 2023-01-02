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
    static void showBoard(){
        System.out.println(board[1] +" | "+ board[2] + " | " + board[3]);
        System.out.println("----------");
        System.out.println(board[4] +" | "+ board[5] + " | " + board[6]);
        System.out.println("----------");
        System.out.println(board[7] +" | "+ board[8] + " | " + board[9]);
    }
    public static void main(String[] args) {
        createEmptyBoard();
        chooseInputLetter();
        showBoard();
    }
}
