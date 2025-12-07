package game.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class BadStepDefs {

    @When("^two players play tictactoe$")
    public void two_players_play_tictactoe() {}
    @When("^the game is played$")
    public void the_game_is_played() {}
    @And("^player O wins$")
    public void player_o_wins() {}
    @Then("^the game ends$")
    public void the_game_ends() {}
    @And("^its a cats game$")
    public void its_a_cats_game() {}
}
