package game;


public class TicTacToe {
    private final char[][] board;
    private final int size;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private static final char EMPTY = ' ';

    public TicTacToe(int size, Player player1, Player player2) {
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
    public void clearBoard(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = EMPTY;
            }
        }
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
    public Player getWinner() {
        if (checkWin()) {
            System.out.println("Player " + currentPlayer.getName() + " wins!\n");
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
        if(!checkWin()){
            System.out.println("It's a Cats Game!\n");
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
            this.size = n;
            return this;
        }

        public Builder setTwoPlayers() {
            this.player1 = new Player("X", 'X');
            this.player2 = new Player("O", 'O');
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

