package no.abhiramikarunananthan.worldcup;

import java.util.Objects;

/**
 * Game class
 */
public class Game {

    private String homeTeam;
    private String awayTeam;
    private int homeScore;
    private int awayScore;


    /**
     * Constructor for game class
     * @param homeTeam home team of the game
     * @param awayTeam away team of the game
     */
    public Game(String homeTeam, String awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = 0;
        this.awayScore = 0;
    }

    /**
     *Retrieves home team of the game
     */
    public String getHomeTeam() {
        return homeTeam;
    }

    /**
     *Retrieves away team of the game
     */
    public String getAwayTeam() {
        return awayTeam;
    }


    /**
     * Retrieves score of the home team
     * @return home team's score
     */
    public int getHomeScore() {
        return homeScore;
    }

    /**
     * Retrieves score of the away team
     * @return away team's score
     */
    public int getAwayScore() {
        return awayScore;
    }

    /**
     * Retrieves total score of the home team and away team
     * @return total score of home team and away team
     */
    public int getTotalScore() {
        return awayScore + homeScore;
    }

    /**
     * Sets score of the home team
     * @param homeScore home team's new score
     */
    public void setHomeScore(int homeScore) {
        if (homeScore < 0){
            throw new IllegalArgumentException("Score cannot be negative");
        }
        this.homeScore = homeScore;
    }

    /**
     * Sets score of the away team
     * @param awayScore away team's new score
     */
    public void setAwayScore(int awayScore) {
        if (awayScore < 0){
            throw new IllegalArgumentException("Score cannot be negative");
        }
        this.awayScore = awayScore;
    }

    /**
     * toString method to display game information
     * @return string of game information
     */
    @Override
    public String toString() {
        return homeTeam + " "+ homeScore + " - " + awayTeam + " " + awayScore;
    }
}
