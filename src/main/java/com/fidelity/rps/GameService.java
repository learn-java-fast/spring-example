package com.fidelity.rps;
import javax.swing.*;
import java.util.ArrayList;

public class GameService {

    Score score;
    ArrayList<Game> history;
    Summarizer summarizer;

    public GameService(ArrayList<Game> h, Score s) {
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
