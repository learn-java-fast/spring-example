package com.fidelity.rps;

import java.util.ArrayList;

public class MyConfiguration {

    public ArrayList<Game> getBlankArrayList() {
        return new ArrayList<Game>();
    }

    public Score getTheDarnScore() {
        Score score = new Score();
        score.wins = 100;
        score.losses = 100;
        score.ties = 100;
        return score;
    }
}
