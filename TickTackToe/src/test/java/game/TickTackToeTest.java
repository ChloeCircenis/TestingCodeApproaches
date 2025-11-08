package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TickTackToeTest {
    @Test
    public void gameStartTest(){
        TickTackToe game = new TickTackToe().Builder()
                .emptyNbyNGameBoard(3)
                .build();
        assertTrue(game.board.getEntries() == null);
        assertTrue(game.players.size()==2);
    }
    @Test
    public void gameEndTest(){
        TickTackToe game = new TickTackToe().Builder()
                .emptyNbyNGameBoard(0)
                .build();
        assertTrue(game.isOver());
    }
    @Test
    public void PlayerXWInsTest(){
        TickTackToe game = new TickTackToe().Builder()
                .emptyNbyNGameBoard(3)
                .build();
        game.takeTurn(game.playerX,2,2);
        game.takeTurn(game.playerO,1,2);
        game.takeTurn(game.playerX,1,1);
        game.takeTurn(game.playerO,3,2);
        game.takeTurn(game.playerX,3,3);
        assertTrue(game.winner == game.playerX);
    }
    @Test
    public void PlayerOWinsTest(){
        TickTackToe game = new TickTackToe().Builder()
                .emptyNbyNGameBoard(3)
                .build();
        game.takeTurn(game.playerX,2,2);
        game.takeTurn(game.playerO,1,2);
        game.takeTurn(game.playerX,3,3);
        game.takeTurn(game.playerO,1,1);
        game.takeTurn(game.playerX,3,1);
        game.takeTurn(game.playerO,1,3);
        assertTrue(game.winner == game.playerO);
    }
    @Test
    public void CatsGameTest(){
        TickTackToe game = new TickTackToe().Builder()
                .emptyNbyNGameBoard(3)
                .build();
        game.takeTurn(game.playerX,2,2);
        game.takeTurn(game.playerO,1,2);
        game.takeTurn(game.playerX,3,3);
        game.takeTurn(game.playerO,1,1);
        game.takeTurn(game.playerX,1,3);
        game.takeTurn(game.playerO,3,1);
        game.takeTurn(game.playerX,2,1);
        game.takeTurn(game.playerO,2,3);
        game.takeTurn(game.playerX,3,2);
        assertTrue(game.isOver());
        assertTrue(game.winner == null);
    }
}
