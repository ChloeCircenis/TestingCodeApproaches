package game;
import java.util.Scanner;


public class TicTacToe {
    private char[][] board;
    private final int size;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private static final char EMPTY = ' ';

    private TicTacToe(int size, Player player1, Player player2) {
        this.size = size;
        this.board = new char[size][size];
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        initBoard();
    }

    private void initBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    public char[][] getBoard() {
        return board;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < size &&
                col >= 0 && col < size &&
                board[row][col] == EMPTY;
    }

    public void makeMove(int row, int col) {
        board[row][col] = currentPlayer.getSymbol();
    }
    protected boolean checkRows(char symbol){
        for (int i = 0; i < size; i++) {
            boolean rowWin = true;
            for (int j = 0; j < size; j++) {
                if (board[i][j] != symbol) {
                    rowWin = false;
                    break;
                }
            }
            if (rowWin) {
                return true;
            }
        }
        return false;
    }
    protected boolean checkCols(char symbol){
        for (int j = 0; j < size; j++) {
            boolean colWin = true;
            for (int i = 0; i < size; i++) {
                if (board[i][j] != symbol) {
                    colWin = false;
                    break;
                }
            }
            if (colWin) {
                return true;
            }
        }
        return false;
    }
    protected boolean checkLeftDiagonal(char symbol){
        boolean diagL = true;
        for (int i = 0; i < size; i++) {
            if (board[i][i] != symbol) {
                diagL = false;
                break;
            }
        }
        return diagL;
    }
    protected boolean checkRightDiagonal(char symbol){
        boolean diag2 = true;
        for (int i = 0; i < size; i++) {
            if (board[i][size - 1 - i] != symbol) {
                diag2 = false;
                break;
            }
        }
        return diag2;
    }
    public boolean checkWin() {
        char symbol = currentPlayer.getSymbol();
        return( checkRows(symbol) || checkCols(symbol) ||  checkLeftDiagonal(symbol) || checkRightDiagonal(symbol));
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
        }
        else if(currentPlayer == player2) {
            currentPlayer = player1;
        }
    }

    public static class Builder {
        private int size;
        private Player player1;
        private Player player2;

        public Builder size(int n) {
            if (n < 3) {
                throw new IllegalArgumentException("Board size must be >= 3");
            }
            this.size = n;
            return this;
        }

        public Builder setPlayers(Player p1, Player p2) {
            this.player1 = p1;
            this.player2 = p2;
            return this;
        }

        public TicTacToe build() {
            if (player1 == null || player2 == null) {
                throw new IllegalStateException("Players not set");
            }
            return new TicTacToe(size, player1, player2);
        }
    }
}

