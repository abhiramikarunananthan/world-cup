package no.abhiramikarunananthan.worldcup;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ScoreBoardTest {

    private ScoreBoard scoreBoard;
    private Game gameOne;
    private Game gameTwo;
    private Game gameThree;


    @BeforeEach
//arrange
    public void setUp() {
        scoreBoard = new ScoreBoard();
        gameOne = new Game("Canada", "USA");
        gameTwo = new Game("Spain", "Norway");
        gameThree = new Game("Sweden", "Denmark");

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
        String homeTeam = gameOne.getHomeTeam();
        String awayTeam = gameOne.getAwayTeam();
        String testForCapitalLetterHomeTeamName = gameOne.getHomeTeam().toUpperCase();
        int newScore = 3;
        int illegalScore = -4;

        //act
        boolean trueScore = scoreBoard.updateScore(homeTeam, awayTeam, newScore, newScore);
        boolean trueTeamName = scoreBoard.updateScore(testForCapitalLetterHomeTeamName, awayTeam, newScore, newScore);


        //assert
        assertTrue(trueScore, "Score should be updated successfully for valid input.");
        assertTrue(trueTeamName, "Score should be updated successfully for valid input.");

        //act & assert
        assertThrows(IllegalArgumentException.class, () -> {
            scoreBoard.updateScore(homeTeam, awayTeam, newScore, illegalScore);
        }, "Updating score with a negative value should throw an IllegalArgumentException.");

    }

    @Test
    void finishGameTest() {

        //arrange
        scoreBoard.startGame(gameOne);
        scoreBoard.startGame(gameTwo);
        scoreBoard.startGame(gameThree);

        String existingHomeTeamGameOne = gameOne.getHomeTeam();
        String existingAwayTeamGameOne = gameOne.getAwayTeam();
        String existingAwayTeamGameTwo = gameTwo.getAwayTeam();
        String checkCapitalLettersHomeTeam = gameThree.getHomeTeam().toUpperCase();
        String existingAwayTeamGameThree = gameThree.getAwayTeam();
        String nonExistingHomeTeam = "japan";


        //act
        boolean gameFinishedTrue = scoreBoard.finishGame(existingHomeTeamGameOne, existingAwayTeamGameOne);
        boolean gameNotFinishedNonExistingTeam = scoreBoard.finishGame(nonExistingHomeTeam, existingAwayTeamGameTwo);
        boolean checkCapitalLettersGameFinishedTrue = scoreBoard.finishGame(checkCapitalLettersHomeTeam, existingAwayTeamGameThree);

        assertTrue(gameFinishedTrue);
        assertFalse(gameNotFinishedNonExistingTeam);
        assertTrue(checkCapitalLettersGameFinishedTrue);

    }




}