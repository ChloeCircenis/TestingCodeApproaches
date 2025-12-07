Feature: Details of game play
  As a game player
  I want to play a game with multiple outcomes
  So that I can ensure that all outcomes are possible


  Scenario: Play a game where player X wins
    When two players play tictactoe
    When the game is played
    And player O wins
    Then the game ends


  Scenario: Play a game where player O wins
    When two players play tictactoe
    When the game is played
    And player O wins
    Then the game ends

  Scenario: Play a game where the two players tie
    When two players play tictactoe
    When the game is played
    And its a cats game
    Then the game ends
