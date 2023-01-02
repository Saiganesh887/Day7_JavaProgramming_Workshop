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
    static void makeMove(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter positions in board between (1 - 9):");
        int position = sc.nextInt();
        if(position > 9 || position < 1){
            System.out.println("Enter correct position:");
            makeMove();
        } else if (board[position] != ' ') {
            System.out.println("The position in board is already filled, Please ");
            makeMove();
        }
        else{
            board[position] = playerLetter;
            showBoard();
            makeMove();
        }
    }
    static void checkFreeSpace(){
        boolean isSpaceAvailable = false;
        int freeSpaces = 0;
        for(int i = 1;i < board.length; i++){
            if(board[i] == ' '){
                isSpaceAvailable = true;
                freeSpaces++;
            }
        }
        if(!isSpaceAvailable){
            System.out.println("Board is full you can't enter any more: ");
        }else{
            System.out.println(freeSpaces + " free spaces is available in board.");
            makeMove();
        }
    }
    public static void main(String[] args) {
        createEmptyBoard();
        chooseInputLetter();
        showBoard();
        makeMove();
        checkFreeSpace();
    }
}
