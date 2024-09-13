package no.abhiramikarunananthan.worldcup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Game gameOne;
    private Game gameTwo;
    private Game gameThree;
    private Game gameFour;


    @BeforeEach
    //arrange
    public void setUp(){
        gameOne = new Game("Canada", "USA", 1);
        gameTwo = new Game("Spain", "Norway", 2);
        gameThree = new Game("Sweden", "England", 3);
        gameFour = new Game("Croatia", "Denmark", 4);
    }

    @Test
    void getHomeTeam(){
        //act
        String homeTeamOne = gameOne.getHomeTeam();
        String homeTeamThree = gameThree.getHomeTeam();

        //assert
        assertEquals(homeTeamOne, "canada");
        assertEquals(homeTeamThree, "sweden");
    }

    @Test
    void getAwayTeam(){
        //act
        String awayTeamTwo = gameTwo.getAwayTeam();
        String awayTeamFour = gameFour.getAwayTeam();

        //assert
        assertEquals(awayTeamTwo, "norway");
        assertEquals(awayTeamFour, "denmark");
    }
    @Test
    void getId() {
        //act
        int gameOneId = gameOne.getId();
        int gameThreeId = gameThree.getId();

        //assert
        assertEquals(gameOneId, 1);
        assertEquals(gameThreeId, 3);

    }

    @Test
    void setHomeScore(){

        //act
       gameTwo.setHomeScore(3);
       gameFour.setHomeScore(6);

        //assert
        assertEquals(gameTwo.getHomeScore(), 3);
        assertEquals(gameFour.getHomeScore(), 6);


    }
    @Test
    void setAwayScore(){

        //act
        gameOne.setAwayScore(3);
        gameThree.setAwayScore(6);

        //assert
        assertEquals(gameOne.getAwayScore(), 2);
        assertEquals(gameThree.getAwayScore(), 8);


    }

    @Test
    void getHomeScore(){
        //arrange
        gameOne.setHomeScore(1);
        gameTwo.setHomeScore(2);

        //act
        int homeScoreGameOne = gameOne.getHomeScore();
        int homeScoreGameTwo = gameTwo.getHomeScore();

        //assert
        assertEquals(homeScoreGameOne, 1);
        assertEquals(homeScoreGameTwo, 2);

    }

    @Test
    void getAwayScore(){
        //arrange
        gameThree.setAwayScore(3);
        gameFour.setAwayScore(4);

        //act
        int awayScoreGameThree = gameThree.getAwayScore();
        int awayScoreGameFour = gameFour.getAwayScore();

        //assert
        assertEquals(awayScoreGameThree, 3);
        assertEquals(awayScoreGameFour, 4);

    }
}