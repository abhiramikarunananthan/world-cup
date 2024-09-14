package no.abhiramikarunananthan.worldcup;

import java.util.*;
import java.util.stream.Collectors;


public class Scoreboard {

    private List<Game> scoreBoard;

    public Scoreboard() {
        this.scoreBoard = new ArrayList<>();
    }


    public boolean startGame(Game game) {
        if (!scoreBoard.contains(game)) {
            scoreBoard.add(game);
            return true;
        } else {
            return false;
        }
    }

    public boolean updateScore(Game game, int newHomeScore, int newAwayScore) {
        if (newHomeScore < 0 || newAwayScore < 0) {
            throw new IllegalArgumentException("New score cannot be negative!");
        }
        if (scoreBoard.contains(game)) {
            game.setHomeScore(newHomeScore);
            game.setAwayScore(newAwayScore);
            return true;
        }
        return false;
    }


    public boolean finishGame(Game game) {
        return scoreBoard.remove(game);
    }

    public List<Game> getSummary() {
        return scoreBoard.stream()
                .sorted(Comparator.comparingInt(Game::getTotalScore).reversed()
                        .thenComparingInt(scoreBoard::indexOf))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder finalString = new StringBuilder();
        for (Game game : this.getSummary()) {
            finalString.append(this.getSummary().indexOf(game) + 1).append(". ").append(game.toString()).append("\n");
        }
        return finalString.toString();
    }


}
