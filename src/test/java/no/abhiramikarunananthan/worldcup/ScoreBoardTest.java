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



}