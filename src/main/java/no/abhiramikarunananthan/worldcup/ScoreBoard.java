package no.abhiramikarunananthan.worldcup;

import java.util.*;
import java.util.stream.Collectors;

public class ScoreBoard {

    private List<Game> scoreBoard;



    public ScoreBoard() {
        this.scoreBoard = new ArrayList<Game>();
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
    public boolean finishGame(Game game) {
        return scoreBoard.remove(game);
    }

    public List<Game> getSummary() {
        return scoreBoard.stream()
                .sorted(Comparator.comparingInt(Game::getTotalScore).reversed()
                        .thenComparingInt(scoreBoard::indexOf))
                .collect(Collectors.toList());
    }
}
