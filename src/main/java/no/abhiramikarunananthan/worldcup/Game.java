package no.abhiramikarunananthan.worldcup;

public class Game {

    private String homeTeam;
    private String awayTeam;
    private int homeScore;
    private int awayScore;
    private int id;

    public Game(String homeTeam, String awayTeam, int id) {
        this.homeTeam = homeTeam.toLowerCase();
        this.awayTeam = awayTeam.toLowerCase();
        this.homeScore = 0;
        this.awayScore = 0;
        this.id = id;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }
}
