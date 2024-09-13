package no.abhiramikarunananthan.worldcup;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {

    private List<Game> scoreBoard;

    private List<Game> summary;


    public ScoreBoard() {
        this.scoreBoard = new ArrayList<Game>();
        this.summary = new ArrayList<Game>();
    }


    public boolean startGame(Game game){
        if(!scoreBoard.contains(game)){
            scoreBoard.add(game);
            return true;
        } else {
            return false;
        }
    }

    public boolean updateScore(String homeTeam, String awayTeam, int newHomeScore, int newAwayScore) {
        return scoreBoard.stream()
                .filter(game -> game.getHomeTeam().equalsIgnoreCase(homeTeam)
                        && game.getAwayTeam().equalsIgnoreCase(awayTeam))
                .findFirst()
                .map(game -> {
                    game.setHomeScore(newHomeScore);
                    game.setAwayScore(newAwayScore);
                    return true;
                })
                .orElse(false);
    }

}
