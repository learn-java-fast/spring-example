package com.fidelity.rps;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Score {
    int wins;
    int losses;
    int ties;
}
