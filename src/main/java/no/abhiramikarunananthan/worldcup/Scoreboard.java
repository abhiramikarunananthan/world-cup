package no.abhiramikarunananthan.worldcup;

import java.util.*;
import java.util.stream.Collectors;


/**
 * Scoreboard class
 */
public class Scoreboard {

    private List<Game> scoreBoard;

    /**
     * Constructor for Scoreboard class
     */
    public Scoreboard() {
        this.scoreBoard = new ArrayList<>();
    }

    /**
     * Starts game and add to scoreboard
     * @param game that gets started and added
     * @return true if game is started and added into scoreboard or false if game is already started and inside scoreboard
     */
    public boolean startGame(Game game) {
        if (!scoreBoard.contains(game)) {
            scoreBoard.add(game);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Updates score of a game
     * @param game that gets updated
     * @param newHomeScore new updated home score
     * @param newAwayScore new updated away score
     * @return true if score updates successfully or false if scoreboard doesn't contain game
     * @throws IllegalArgumentException if new scores provided are negative
     */
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

    /**
     * Finishes game and removes game from scoreboard
     * @param game to be finished
     * @return true if game is successfully removed or false if provided game is not in scoreboard
     */
    public boolean finishGame(Game game) {
        return scoreBoard.remove(game);
    }

    /**
     * Gets summary of the games in progress ordered by total score
     * @return list of the games in progress
     */
    public List<Game> getSummary() {
        return scoreBoard.stream()
                .sorted(Comparator.comparingInt(Game::getTotalScore).reversed()
                        .thenComparingInt(scoreBoard::indexOf))
                .collect(Collectors.toList());
    }

    /**
     * toString method of games in scoreboard
     * @return list of games in scoreboard
     */
    @Override
    public String toString() {
        StringBuilder finalString = new StringBuilder();
        for (Game game : this.getSummary()) {
            finalString.append(this.getSummary().indexOf(game) + 1).append(". ").append(game.toString()).append("\n");
        }
        return finalString.toString();
    }

}
