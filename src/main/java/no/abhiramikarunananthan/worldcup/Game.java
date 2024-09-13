package no.abhiramikarunananthan.worldcup;

public class Game {

    private String homeTeam;
    private String awayTeam;
    private int homeScore;
    private int awayScore;
    private int id;
    private static int nextId = 1;


    public Game(String homeTeam, String awayTeam) {
        this.homeTeam = homeTeam.toLowerCase();
        this.awayTeam = awayTeam.toLowerCase();
        this.homeScore = 0;
        this.awayScore = 0;
        this.id = nextId++;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public int getId() {
        return id;
    }

    public int getHomeScore() {
        return homeScore;
    }
    public int getAwayScore() {
        return awayScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }


}
