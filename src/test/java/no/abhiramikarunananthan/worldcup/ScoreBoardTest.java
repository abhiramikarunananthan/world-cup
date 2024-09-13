package no.abhiramikarunananthan.worldcup;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class ScoreBoardTest {

    private ScoreBoard scoreBoard;
    private Game gameOne;
    private Game gameTwo;


@BeforeEach
//arrange
    public void setUp(){
    scoreBoard = new ScoreBoard();
    gameOne = new Game("Canada", "USA");
    gameTwo = new Game("Spain", "Norway");
}

@Test
    void startGameTest() {

    //act
    boolean firstGameStarted = scoreBoard.startGame(gameOne);
    boolean secondGameStarted = scoreBoard.startGame(gameTwo);
    boolean sameAsFirstGameStarted = scoreBoard.startGame(gameOne);


    //assert
    assertTrue(firstGameStarted);
    assertTrue(secondGameStarted);
    assertFalse(sameAsFirstGameStarted);

}

@Test
    void updateScoreTest(){

    //arrange
    String homeTeam = gameOne.getHomeTeam();
    String awayTeam = gameOne.getAwayTeam();
    int newScore = 3;
    int illegalScore = -4;

    //act
    boolean trueScore = scoreBoard.updateScore(homeTeam, awayTeam, newScore, newScore);
    boolean falseScore = scoreBoard.updateScore(homeTeam, awayTeam, newScore, illegalScore);

    //
    assertTrue(trueScore);
    assertFalse(falseScore);

}



}