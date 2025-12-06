package game;

//everything declared with public access

public class BadTicTacToe {
    public final char[][] board;
    public final int size;
    public final Player player1;
    public final Player player2;
    public Player currentPlayer;
    public static final char EMPTY = ' ';

    public BadTicTacToe(){
        this.size = 10;
        this.board = new char[10][10];
        this.player1 = new Player("Player1", 'x');
        this.player2 = new Player("Player2", 'o');
        this.currentPlayer = this.player1;
        initBoard();
    }

    public BadTicTacToe(int size, Player player1, Player player2) {
        this.size = size;
        this.board = new char[size][size];
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
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

    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < size &&
                col >= 0 && col < size &&
                board[row-1][col-1] == EMPTY;
    }

    public void makeMove(int row, int col) {
        board[row-1][col-1] = currentPlayer.getSymbol();
        System.out.print("Player " + currentPlayer.getName() + " is making new move at ("+ row + ", " + col + ")\n");
    }
    public boolean checkRows(char symbol){
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
    public boolean checkCols(char symbol){
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
    public boolean checkLeftDiagonal(char symbol){
        boolean diagL = true;
        for (int i = 0; i < size; i++) {
            if (board[i][i] != symbol) {
                diagL = false;
                break;
            }
        }
        return diagL;
    }
    public boolean checkRightDiagonal(char symbol){
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
        }
        else if(currentPlayer == player2) {
            currentPlayer = player1;
        }
    }

    public static class Builder {
        public int size;
        public Player player1;
        public Player player2;

        public BadTicTacToe.Builder size(int n) {
            this.size = n;
            return this;
        }

        public BadTicTacToe.Builder setTwoPlayers() {
            this.player1 = new Player("player 1", 'X');
            this.player2 = new Player("player 2", 'O');
            return this;
        }

        public BadTicTacToe build() {
            if (player1 == null || player2 == null) {
                throw new IllegalStateException("Players not set");
            }
            return new BadTicTacToe(size, player1, player2);
        }
    }
}

