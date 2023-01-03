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
        System.out.println("-_-_-_-_-_-_-_-_-_-");
        System.out.println(board[1] +" | "+ board[2] + " | " + board[3]);
        System.out.println("----------");
        System.out.println(board[4] +" | "+ board[5] + " | " + board[6]);
        System.out.println("----------");
        System.out.println(board[7] +" | "+ board[8] + " | " + board[9]);
    }
    static void playerTurn(){
        int playerMove;
        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter positions in board between (1 - 9):");
            playerMove = sc.nextInt();
            if (board[playerMove] == ' ') {
                break;
            }
        }
        System.out.println("Player choose: "+playerMove);
        board[playerMove] = playerLetter;
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
            System.exit(0);
        }else{
            System.out.println(freeSpaces + " free spaces is available in board.");
        }
    }
    static void firstToStartGame(){
        int head = 0;
        int toss = (int)(Math.random() * 10) % 2;
        if(toss == head) {
            System.out.println("Computer starts the play first.");
            computerTurn();
            showBoard();
            while (true) {
                checkFreeSpace();
                playerTurn();
                showBoard();
                computerTurn();
                showBoard();
                winner();
            }
        }
        else {
            System.out.println("User starts the play first.");
            playerTurn();
            showBoard();
            while (true) {
                computerTurn();
                showBoard();
                checkFreeSpace();
                playerTurn();
                showBoard();
                winner();
            }
        }
    }
    static void winner(){
        if((board[1] == playerLetter && board[2] == playerLetter && board[3] == playerLetter) ||
                (board[1] == playerLetter && board[4] == playerLetter && board[7] == playerLetter) ||
                (board[1] == playerLetter && board[5] == playerLetter && board[9] == playerLetter) ||
                (board[2] == playerLetter && board[5] == playerLetter && board[8] == playerLetter) ||
                (board[3] == playerLetter && board[6] == playerLetter && board[9] == playerLetter) ||
                (board[3] == playerLetter && board[5] == playerLetter && board[7] == playerLetter) ||
                (board[4] == playerLetter && board[5] == playerLetter && board[6] == playerLetter) ||
                (board[7] == playerLetter && board[8] == playerLetter && board[9] == playerLetter)){
            showBoard();
            System.out.println("Player wins the game");
            System.exit(0);
        }
    }
    static void computerTurn(){
        int computerMove;
        while(true){
            computerMove = (int) Math.floor(Math.random() * 10) % 9 + 1;
            if(board[computerMove] == ' '){
                break;
            }
        }
        System.out.println("Computer choose: "+computerMove);
        board[computerMove] = computerLetter;
    }
    public static void main(String[] args) {
        createEmptyBoard();
        chooseInputLetter();
        firstToStartGame();
    }
}
