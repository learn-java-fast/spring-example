package com.fidelity.rps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import javax.swing.*;
import java.util.ArrayList;

@Service
public class GameService {

    Score score;
    ArrayList<Game> history;
    @Autowired
    @Qualifier("swing")
    Summarizer summarizer;

    public GameService(ArrayList<Game> h, @Qualifier("benjamins")Score s) {
        this.history =h;
        this.score = s;
    }

    public void playTheGame(){

        String prompt = "Will it be rock, paper or scissors?";
        String input = JOptionPane.showInputDialog(prompt);
        String result = "error";

        while (!input.equalsIgnoreCase("Q")) {
            if (input.equalsIgnoreCase("scissors")) {
                result = "loss";
                score.losses++;
            }
            if (input.equalsIgnoreCase("rock")) {
                result = "tie";
                score.ties++;
            }
            if (input.equalsIgnoreCase("paper")) {
                result = "win";
                score.wins++;
            }
            Game game = new Game(input, "rock", result);
            history.add(game);
            summarizer.printSummary();
            JOptionPane.showMessageDialog(null, result);
            input = JOptionPane.showInputDialog(prompt);
        }

    }


}
