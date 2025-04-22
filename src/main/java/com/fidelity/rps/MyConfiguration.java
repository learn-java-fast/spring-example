package com.fidelity.rps;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {
    @Bean
    public Score getTheDarnScore() {
        Score score = new Score();
        score.wins = 100;
        return score;
    }
}
