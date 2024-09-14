package no.abhiramikarunananthan.worldcup;

import java.util.*;
import java.util.stream.Collectors;

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


    // er det dumt at den itirerer gjennom mens jeg remove?
    public boolean finishGame(String homeTeam, String awayTeam) {
        for(Game game: scoreBoard){
            if (game.getHomeTeam().equals(homeTeam.toLowerCase())&& game.getAwayTeam()
                    .equals(awayTeam.toLowerCase())){
                scoreBoard.remove(game);
                return true;
            }
        }
        return false;

    }

    public List<Game> getSummary() {
        summary = new ArrayList<>(scoreBoard);
        return summary.stream()
                .sorted(Comparator.comparingInt(Game::getTotalScore).reversed()
                        .thenComparingInt(Game::getId))
                .collect(Collectors.toList());
    }
}
