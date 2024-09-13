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
}