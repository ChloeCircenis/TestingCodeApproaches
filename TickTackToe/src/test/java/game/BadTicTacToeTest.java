package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BadTicTacToeTest {
    @Test
    public void gameStartTest(){
        BadTicTacToe game = new BadTicTacToe.Builder()
                .size(3)
                .setTwoPlayers()
                .build();
        assertTrue(game.isBoardEmpty());
    }
    @Test
    public void gameEndTest(){
        BadTicTacToe game = new BadTicTacToe.Builder()
                .size(1)
                .setTwoPlayers()
                .build();
        game.makeMove(1,1);
        game.printBoard();
        assertFalse(game.isBoardEmpty());
    }
    @Test
    public void TestGetWinner(){
        BadTicTacToe game = new BadTicTacToe.Builder()
                .size(3)
                .setTwoPlayers()
                .build();
        game.makeMove(2,2);
        game.switchPlayer();
        game.makeMove(1,2);
        game.switchPlayer();
        game.makeMove(1,1);
        game.switchPlayer();
        game.makeMove(3,2);
        game.switchPlayer();
        game.makeMove(3,3);
        assertSame(game.getWinner(), game.getCurrentPlayer());
    }
    @Test
    public void CatsGameTest(){
        BadTicTacToe game = new BadTicTacToe.Builder()
                .size(3)
                .setTwoPlayers()
                .build();
        game.makeMove(2,2);
        game.switchPlayer();
        game.makeMove(1,2);
        game.switchPlayer();
        game.makeMove(3,3);
        game.switchPlayer();
        game.makeMove(1,1);
        game.switchPlayer();
        game.makeMove(1,3);
        game.switchPlayer();
        game.makeMove(3,1);
        game.switchPlayer();
        game.makeMove(2,1);
        game.switchPlayer();
        game.makeMove(2,3);
        game.switchPlayer();
        game.makeMove(3,2);
        assertTrue(game.isBoardFull());
        assertNull(game.getWinner());
    }
    @Test
    public void TestBoard(){
        BadTicTacToe game = new BadTicTacToe.Builder()
                .size(3)
                .setTwoPlayers()
                .build();
        if(game.isValidMove(2,2)){
            game.makeMove(2,2);
            game.switchPlayer();
            game.printBoard();
        }
        if(game.isValidMove(2,2)){
            game.makeMove(2,2);
            game.switchPlayer();
            game.printBoard();
        }
        game.switchPlayer();
        game.makeMove(1,2);
        game.printBoard();
    }
}
