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


}
