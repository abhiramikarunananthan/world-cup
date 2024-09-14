package no.abhiramikarunananthan.worldcup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class ScoreBoardTest {

    private ScoreBoard scoreBoard;
    private Game gameOne;
    private Game gameTwo;
    private Game gameThree;
    private Game gameFour;



    @BeforeEach
//arrange
    public void setUp() {
        scoreBoard = new ScoreBoard();
        gameOne = new Game("Canada", "USA");
        gameTwo = new Game("Spain", "Norway");
        gameThree = new Game("Sweden", "Denmark");
        gameFour = new Game("Croatia", "Finland");


    }

    @Test
    void startGameTest() {

        //act
        boolean firstGameStarted = scoreBoard.startGame(gameOne);
        boolean sameAsFirstGameStarted = scoreBoard.startGame(gameOne);


        //assert
        assertTrue(firstGameStarted, "Game should be started for valid input.");
        assertFalse(sameAsFirstGameStarted, "Game should not start as this exact game has already started.");

    }

    @Test
    void updateScoreTest() {

        //arrange
        scoreBoard.startGame(gameOne);
        scoreBoard.startGame(gameTwo);
        Game gameNotInScoreboard = new Game("Japan", "China");
        int newHomeScore = 3;
        int newAwayScore = 2;
        int illegalScore = -4;

        //act
        boolean scoreIsUpdated = scoreBoard.updateScore(gameOne, newHomeScore, newAwayScore);
        boolean scoreNotUpdated = scoreBoard.updateScore(gameNotInScoreboard, newHomeScore, newAwayScore);


        //assert
        assertTrue(scoreIsUpdated, "Score should be updated successfully for valid game and scores");
        assertFalse(scoreNotUpdated, "Score should not be updated for non existing game");

        //act & assert
        assertThrows(IllegalArgumentException.class, () -> {
            scoreBoard.updateScore(gameTwo, newHomeScore, illegalScore);
        }, "Updating score with a negative value should throw an IllegalArgumentException.");

    }

    @Test
    void finishGameTest() {

        //arrange
        scoreBoard.startGame(gameOne);
        Game gameNotInScoreboard = new Game("Japan", "Norway");


        //act
        boolean gameFinished = scoreBoard.finishGame(gameOne);
        boolean gameNotFinished = scoreBoard.finishGame(gameNotInScoreboard);

        //assert
        assertTrue(gameFinished, "Should return true as the existing game is removed");
        assertFalse(gameNotFinished, "Should return false as provided game does not exist in scoreboard");

    }


    @Test
    void getSummaryTest(){

        // Arrange
        scoreBoard.startGame(gameOne);
        scoreBoard.startGame(gameTwo);
        scoreBoard.startGame(gameThree);
        scoreBoard.startGame(gameFour);

        int expectedNumberOfGamesInTheList = 3;

        scoreBoard.updateScore(gameOne, 1, 0);
        scoreBoard.updateScore(gameTwo, 2, 0);
        scoreBoard.updateScore(gameThree, 0, 1);

        scoreBoard.finishGame(gameFour);

        // Act
        List<Game> sortedGames = scoreBoard.getSummary();

        // Assert
        assertEquals(expectedNumberOfGamesInTheList, sortedGames.size());

        assertEquals(gameTwo, sortedGames.get(0));
        assertEquals(gameOne, sortedGames.get(1));
        assertEquals(gameThree, sortedGames.get(2));
        }
    }

