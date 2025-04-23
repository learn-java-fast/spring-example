package com.fidelity.rps;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.ArrayList;

@Configuration
public class MyConfiguration {

    @Bean
    public ArrayList<Game> getBlankArrayList() {
        return new ArrayList<Game>();
    }

    @Bean("benjamins")
    public Score getTheDarnScore() {
        Score score = new Score();
        score.wins = 100;
        score.losses = 100;
        score.ties = 100;
        return score;
    }
}
