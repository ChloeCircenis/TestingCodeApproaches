Feature: Details of game play
  As a game player
  I want to play a game with multiple outcomes
  So that I can ensure that all outcomes are possible


  Scenario: Play a game where playerX wins
    Given a size 3 tictactoe board and two players
    When the game is played in the board
    Then playerX wins
    And the game is over


  Scenario: Play a game where playerO wins
    Given a size 3 tictactoe board and two players
    When the game is played in the board
    Then playerO wins
    And the game is over

  Scenario: Play a game where the two players tie
    Given a size 3 tictactoe board and two players
    When the game is played in the board
    Then the players tie
    And the game is over
