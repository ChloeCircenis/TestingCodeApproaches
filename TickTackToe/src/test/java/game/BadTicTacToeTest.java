package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BadTicTacToeTest {
    @Test
    public void badGameStartTest(){
        BadTicTacToe game = new BadTicTacToe();
        assertTrue(game.isBoardEmpty());
    }
    @Test
    public void badGameEndTest(){
        BadTicTacToe game = new BadTicTacToe();
        game.makeMove(1,1);
        game.printBoard();
        assertFalse(game.isBoardEmpty());
    }
    @Test
    public void badTestGetWinner(){
        BadTicTacToe game = new BadTicTacToe();
        game.makeMove(2,2);
        game.makeMove(1,1);
        game.makeMove(3,3);
        assertSame(game.getWinner(), game.getCurrentPlayer());
    }
    @Test
    public void badCatsGameTest(){
        BadTicTacToe game = new BadTicTacToe();
        for(int i = 1; i <= game.board.length; i++){
            for(int j = 1; j <= game.board.length; j++){
                game.makeMove(i,j);
            }
        }
        game.printBoard();
        assertTrue(game.isBoardFull());
        assertEquals(game.getWinner(),game.getCurrentPlayer());
    }
    @Test
    public void badTestBoard(){
        BadTicTacToe game = new BadTicTacToe();
        game.makeMove(2,2);
        game.switchPlayer();
        game.printBoard();
        game.makeMove(2,2);
        game.switchPlayer();
        game.printBoard();
        game.switchPlayer();
        game.makeMove(1,2);
        game.printBoard();
    }
}
