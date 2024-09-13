package no.abhiramikarunananthan.worldcup;

/**
 * Game class
 */
public class Game {

    private String homeTeam;
    private String awayTeam;
    private int homeScore;
    private int awayScore;
    private int id;
    private static int nextId = 1;

    /**
     * constructor for game class
     * @param homeTeam home team of the game
     * @param awayTeam away team of the game
     */
    public Game(String homeTeam, String awayTeam) {
        this.homeTeam = homeTeam.toLowerCase();
        this.awayTeam = awayTeam.toLowerCase();
        this.homeScore = 0;
        this.awayScore = 0;
        this.id = nextId++;
    }

    /**
     * get method to retrieve home team of the game
     */
    public String getHomeTeam() {
        return homeTeam;
    }

    /**
     * get method to retrieve away team of the game
     */
    public String getAwayTeam() {
        return awayTeam;
    }

    /**
     * get method to retrieve unique id of game
     * @return unique game id
     */
    public int getId() {
        return id;
    }

    /**
     * get method to retrieve score of the home team
     * @return home team's score
     */
    public int getHomeScore() {
        return homeScore;
    }

    /**
     * get method to retrieve score of the away team
     * @return away team's score
     */
    public int getAwayScore() {
        return awayScore;
    }

    /**
     * set method to set score of the home team
     * @param homeScore home team's new score
     */
    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    /**
     * set method to set score of the away team
     * @param awayScore away team's new score
     */
    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }


}
