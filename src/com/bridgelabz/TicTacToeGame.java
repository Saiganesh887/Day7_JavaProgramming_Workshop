package com.bridgelabz;

import java.util.Scanner;

public class TicTacToeGame {
    static char[] board = new char[10];
    static char playerLetter;
    static char computerLetter;

    static void createEmptyBoard() {
        for (int i = 1; i < board.length; i++) {
            board[i] = ' ';
        }
    }

    static void chooseInputLetter() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a letter for you ( X  or  O ) to play game : ");
        playerLetter = sc.next().charAt(0);
        if (playerLetter == 'X' || playerLetter == 'x')
            computerLetter = 'O';
        else if (playerLetter == 'O' || playerLetter == 'o')
            computerLetter = 'X';
        else {
            System.out.println("Invalid Input");
            chooseInputLetter();
        }
    }

    static void showBoard() {
        System.out.println("-_-_-_-_-_-_-_-_-_-");
        System.out.println(board[1] + " | " + board[2] + " | " + board[3]);
        System.out.println("----------");
        System.out.println(board[4] + " | " + board[5] + " | " + board[6]);
        System.out.println("----------");
        System.out.println(board[7] + " | " + board[8] + " | " + board[9]);
    }

    static void playerTurn() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter positions in board between (1 - 9):");
        int userInput = sc.nextInt();
        if (userInput > 9 || userInput < 1) {
            System.out.println("Invalid Input.");
            playerTurn();
        }
        if (board[userInput] == ' ') {
            System.out.println("Player choose: " + userInput);
            board[userInput] = playerLetter;
        } else {
            System.out.print("The position is already filled.");
            playerTurn();
        }
        if (checkWinner(playerLetter)) {
            System.out.println("Player wins.");
            System.exit(0);
        } else {
            showBoard();
            checkFreeSpace();
            System.out.println("Computers chance: ");
            computerTurn();
        }
    }

    static void computerTurn() {
        int computerMove = (int) Math.floor(Math.random() * 10) % 9 + 1;
        if(computerAsWinner()){
            checkWinner(computerLetter);
            System.out.println("computer wins.");
            System.exit(0);
        }else if(computerAsPlayerBlocker()){
            showBoard();
            playerTurn();
        }else if (board[computerMove] == ' ' && !computerAsPlayerBlocker()) {
            board[computerMove] = computerLetter;
        } else if(board[computerMove] != ' ') {
            System.out.println("Position is already filled.");
            computerTurn();
        }
        if (checkWinner(computerLetter)) {
            System.out.println("Computer wins.");
            System.exit(0);
        }
        else{
            showBoard();
            checkFreeSpace();
            System.out.println("Player chance: ");
            playerTurn();
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
            System.out.println("Board is completly filled.");
            System.exit(0);
        }else{
            System.out.println(freeSpaces + " free spaces is available in board.");
        }
    }
    static void firstToStartGame(){
        int head = 0;
        int toss = (int)(Math.random() * 10) % 2;//0 or 1
        if(toss == head) {
            System.out.println("Computer starts the play first.");
            computerTurn();
        }
        else {
            System.out.println("User starts the play first.");
            playerTurn();
        }
    }
    static boolean checkWinner(char letter){
         if(    (board[1] == letter && board[2] == letter && board[3] == letter) ||
                (board[1] == letter && board[4] == letter && board[7] == letter) ||
                (board[1] == letter && board[5] == letter && board[9] == letter) ||
                (board[2] == letter && board[5] == letter && board[8] == letter) ||
                (board[3] == letter && board[5] == letter && board[7] == letter) ||
                (board[4] == letter && board[5] == letter && board[6] == letter) ||
                (board[7] == letter && board[8] == letter && board[9] == letter)    ){
            showBoard();
            return true;
        }
        return false;
    }
    static boolean computerAsWinner(){
        if (board[1] == computerLetter && board[2] == computerLetter && board[3] == ' ') {
            board[3] = computerLetter;
            return true;
        } else if (board[1] == computerLetter && board[3] == computerLetter && board[2] == ' ') {
            board[2] = computerLetter;
            return true;
        } else if (board[2] == computerLetter && board[3] == computerLetter && board[1] == ' ') {
            board[1] = computerLetter;
            return true;
        } else if (board[4] == computerLetter && board[5] == computerLetter && board[6] == ' ') {
            board[6] = computerLetter;
            return true;
        } else if (board[4] == computerLetter && board[6] == computerLetter && board[5] == ' ') {
            board[5] = computerLetter;
            return true;
        } else if (board[6] == computerLetter && board[5] == computerLetter && board[4] == ' ') {
            board[4] = computerLetter;
            return true;
        } else if (board[7] == computerLetter && board[8] == computerLetter && board[9] == ' ') {
            board[9] = computerLetter;
            return true;
        } else if (board[7] == computerLetter && board[9] == computerLetter && board[8] == ' ') {
            board[8] = computerLetter;
            return true;
        } else if (board[9] == computerLetter && board[8] == computerLetter && board[7] == ' ') {
            board[7] = computerLetter;
            return true;
        } else if (board[1] == computerLetter && board[4] == computerLetter && board[7] == ' ') {
            board[7] = computerLetter;
            return true;
        } else if (board[1] == computerLetter && board[7] == computerLetter && board[4] == ' ') {
            board[4] = computerLetter;
            return true;
        } else if (board[7] == computerLetter && board[4] == computerLetter && board[1] == ' ') {
            board[1] = computerLetter;
            return true;
        } else if (board[2] == computerLetter && board[5] == computerLetter&& board[8] == ' ') {
            board[8] = computerLetter;
            return true;
        } else if (board[2] == computerLetter && board[8] == computerLetter && board[5] == ' ') {
            board[5] = computerLetter;
            return true;
        } else if (board[5] == computerLetter && board[8] == computerLetter && board[2] == ' ') {
            board[2] = computerLetter;
            return true;
        } else if (board[3] == computerLetter && board[6] == computerLetter && board[9] == ' ') {
            board[9] = computerLetter;
            return true;
        } else if (board[3] == computerLetter && board[9] == computerLetter && board[6] == ' ') {
            board[6] = computerLetter;
            return true;
        } else if (board[6] == computerLetter && board[9] == computerLetter && board[3] == ' ') {
            board[3] = computerLetter;
            return true;
        } else if (board[1] == computerLetter && board[5] == computerLetter && board[9] == ' ') {
            board[9] = computerLetter;
            return true;
        } else if (board[1] == computerLetter && board[9] == computerLetter && board[5] == ' ') {
            board[5] = computerLetter;
            return true;
        } else if (board[5] == computerLetter && board[9] == computerLetter && board[1] == ' ') {
            board[1] = computerLetter;
            return true;
        } else if (board[3] == computerLetter && board[5] == computerLetter && board[7] == ' ') {
            board[7] = computerLetter;
            return true;
        } else if (board[3] == computerLetter && board[7] == computerLetter && board[5] == ' ') {
            board[5] = computerLetter;
            return true;
        } else if (board[7] == computerLetter && board[5] == computerLetter && board[3] == ' ') {
            board[3] = computerLetter;
            return true;
        }
        return false;
    }
    static boolean computerAsPlayerBlocker(){
            if (board[1] == playerLetter && board[2] == playerLetter && board[3] == ' ') {
                board[3] = computerLetter;
                return true;
            } else if (board[1] == playerLetter && board[3] == playerLetter && board[2] == ' ') {
                board[2] = computerLetter;
                return true;
            } else if (board[2] == playerLetter && board[3] == playerLetter && board[1] == ' ') {
                board[1] = computerLetter;
                return true;
            } else if (board[4] == playerLetter && board[5] == playerLetter && board[6] == ' ') {
                board[6] = computerLetter;
                return true;
            } else if (board[4] == playerLetter && board[6] == playerLetter && board[5] == ' ') {
                board[5] = computerLetter;
                return true;
            } else if (board[6] == playerLetter && board[5] == playerLetter && board[4] == ' ') {
                board[4] = computerLetter;
                return true;
            } else if (board[7] == playerLetter && board[8] == playerLetter && board[9] == ' ') {
                board[9] = computerLetter;
                return true;
            } else if (board[7] == playerLetter && board[9] == playerLetter && board[8] == ' ') {
                board[8] = computerLetter;
                return true;
            } else if (board[9] == playerLetter && board[8] == playerLetter && board[7] == ' ') {
                board[7] = computerLetter;
                return true;
            } else if (board[1] == playerLetter && board[4] == playerLetter && board[7] == ' ') {
                board[7] = computerLetter;
                return true;
            } else if (board[1] == playerLetter && board[7] == playerLetter && board[4] == ' ') {
                board[4] = computerLetter;
                return true;
            } else if (board[7] == playerLetter && board[4] == playerLetter && board[1] == ' ') {
                board[1] = computerLetter;
                return true;
            } else if (board[2] == playerLetter && board[5] == playerLetter && board[8] == ' ') {
                board[8] = computerLetter;
                return true;
            } else if (board[2] == playerLetter && board[8] == playerLetter && board[5] == ' ') {
                board[5] = computerLetter;
                return true;
            } else if (board[5] == playerLetter && board[8] == playerLetter && board[2] == ' ') {
                board[2] = computerLetter;
                return true;
            } else if (board[3] == playerLetter && board[6] == playerLetter && board[9] == ' ') {
                board[9] = computerLetter;
                return true;
            } else if (board[3] == playerLetter && board[9] == playerLetter && board[6] == ' ') {
                board[6] = computerLetter;
                return true;
            } else if (board[6] == playerLetter && board[9] == playerLetter && board[3] == ' ') {
                board[3] = computerLetter;
                return true;
            } else if (board[1] == playerLetter && board[5] == playerLetter && board[9] == ' ') {
                board[9] = computerLetter;
                return true;
            } else if (board[1] == playerLetter && board[9] == playerLetter && board[5] == ' ') {
                board[5] = computerLetter;
                return true;
            } else if (board[5] == playerLetter && board[9] == playerLetter && board[1] == ' ') {
                board[1] = computerLetter;
                return true;
            } else if (board[3] == playerLetter && board[5] == playerLetter && board[7] == ' ') {
                board[7] = computerLetter;
                return true;
            } else if (board[3] == playerLetter && board[7] == playerLetter && board[5] == ' ') {
                board[5] = computerLetter;
                return true;
            } else if (board[7] == playerLetter && board[5] == playerLetter && board[3] == ' ') {
                board[3] = computerLetter;
                return true;
            }
            return false;
    }
    public static void main(String[] args) {
        createEmptyBoard();
        chooseInputLetter();
        firstToStartGame();
    }
}
