package game;

public class GameBoard {
    private static final char EMPTY = ' ';
    private final char[][] board;

    public GameBoard(int n) {
        board = new char[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                board[r][c] = EMPTY;
            }
        }
    }

    public char[][] getBoard() {
        return board;
    }

    public boolean isEmpty() {
        for (char[] row : board)
            for (char cell : row)
                if (cell != EMPTY)
                    return false;
        return true;
    }

    public void place(int r, int c, char symbol) {
        board[r][c] = symbol;
    }
}
{
}
