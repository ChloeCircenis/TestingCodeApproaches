package game;

//everything declared with public access

import java.util.ArrayList;
import java.util.List;

public class BadTicTacToe {
    public final char[][] board;
    public final int size;
    public final Player player1;
    public final Player player2;
    public Player currentPlayer;
    public static final char EMPTY = ' ';
    public List<Character> moves = new ArrayList<>();

    public BadTicTacToe(){
        this.size = 10;
        this.board = new char[10][10];
        this.player1 = new Player("Player1", 'x');
        this.player2 = new Player("Player2", 'o');
        this.currentPlayer = this.player1;
        initBoard();
    }

    public void initBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    public void printBoard() {

        int col = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("| " +board[i][j]+ " |");
                if(col==size-1){
                    System.out.print("\n");
                }
                col++;
                if(col==size){
                    col = 0;
                }

            }
        }
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void makeMove(int row, int col) {
        board[row-1][col-1] = currentPlayer.getSymbol();
        moves.add(currentPlayer.getSymbol());
    }

    public boolean checkWin() {
        char symbol = currentPlayer.getSymbol();
        return moves.contains(symbol);
    }
    public Player getWinner() {
        if (checkWin()) {
            System.out.println(currentPlayer.getName() + " wins!\n");
            return currentPlayer;
        }
        return null;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBoardEmpty() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public void switchPlayer() {
        if(currentPlayer == player1) {
            currentPlayer = player2;
        } else if(currentPlayer == player2) {
            currentPlayer = player1;
        }
    }
}

