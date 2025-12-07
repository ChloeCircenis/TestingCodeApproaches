package game.stepdefs;

import game.TicTacToe;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GoodStepDefs {
    private TicTacToe game;

    @Given("^a size (\\d+) tictactoe board and two players$")
    public void aTicTacToeBoardAndTwoPlayers(Integer arg0){
        this.game = new TicTacToe.Builder()
                .size(arg0).setTwoPlayers().build();
    }
    @When("^the game is played in the board$")
    public void theGameIsPlayedInTheBoard(){
        game.makeMove(1,1);
        game.printBoard();
        game.switchPlayer();
        game.makeMove(3,1);
        game.printBoard();
        game.switchPlayer();
        game.makeMove(1,3);
        game.printBoard();
        game.switchPlayer();
        game.makeMove(3,3);
        game.printBoard();
        game.switchPlayer();
    }
    @Then("^playerX wins$")
    public void playerXWins(){
        if(game.isValidMove(1,2)){
            game.makeMove(1,2);
            game.printBoard();
        }

    }
    @Then("^playerO wins$")
    public void playerOWins(){
        game.makeMove(2,2);
        game.printBoard();
        game.switchPlayer();
        game.makeMove(3,2);
        game.printBoard();
    }
    @And("^the game is over$")
    public void theGameIsOver(){
        assertTrue(game.checkWin() || game.isBoardFull());
        game.clearBoard();
    }
    @Then("^the players tie$")
    public void thePlayersTie(){
        game.makeMove(3,2);
        game.printBoard();
        game.switchPlayer();

        game.makeMove(1,2);
        game.printBoard();
        game.switchPlayer();

        game.makeMove(2,2);
        game.printBoard();
        game.switchPlayer();

        game.makeMove(2,3);
        game.printBoard();
        game.switchPlayer();

        game.makeMove(2,1);
        game.printBoard();
        game.switchPlayer();
        assertTrue(game.isBoardFull());
    }
}
