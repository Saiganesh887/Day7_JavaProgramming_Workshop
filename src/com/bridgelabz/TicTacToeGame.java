package com.bridgelabz;
public class TicTacToeGame {
    static char[] board = new char[10];
    static void createEmptyBoard(){
        for(int i = 1; i < board.length; i++){
            board[i] = ' ';
        }
    }
    public static void main(String[] args) {
        createEmptyBoard();
    }
}
