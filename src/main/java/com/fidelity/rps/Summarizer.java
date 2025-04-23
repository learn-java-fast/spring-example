package com.fidelity.rps;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public interface Summarizer {
    public void printSummary();
}

class ConsoleSummarizer implements Summarizer {
    Score score;
    ArrayList<Game> history;
    ConsoleSummarizer(ArrayList<Game> history, Score score) {
        this.history =history;
        this.score = score;
    }

    public void printSummary() {
        System.out.println("=====================================");
        System.out.println("              GAME SUMMARY           ");
        System.out.println("=====================================");
        System.out.printf("Wins   : %d%n", score.wins);
        System.out.printf("Losses : %d%n", score.losses);
        System.out.printf("Ties   : %d%n", score.ties);
        System.out.println("-------------------------------------");

        if (history.isEmpty()) {
            System.out.println("No games played yet.");
            return;
        }

        System.out.printf("%-20s %-20s %-10s %-20s%n", "Client Move", "Server Move", "Result", "Date");
        System.out.println("----------------------------------------------------------------------------------------");

        for (Game game : history) {
            System.out.printf(
                    "%-20s %-20s %-10s %-20s%n",
                    game.clientGesture,
                    game.serverGesture,
                    game.result,
                    game.date.toString()
            );
        }

        System.out.println("----------------------------------------------------------------------------------------");
    }

}

class SwingSummarizer implements Summarizer {

    Score score;
    ArrayList<Game> history;
    SwingSummarizer(ArrayList<Game> history, Score score) {
        this.history =history;
        this.score = score;
    }

    public void printSummary() {
        JFrame frame = new JFrame("Game Summary");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 400);
        frame.setLayout(new BorderLayout(10, 10));

        // ======= Score Panel =======
        JPanel scorePanel = new JPanel();
        scorePanel.setLayout(new BoxLayout(scorePanel, BoxLayout.Y_AXIS));
        scorePanel.setBorder(BorderFactory.createTitledBorder("Score Summary"));

        JLabel winsLabel = new JLabel("Wins: " + score.wins);
        JLabel lossesLabel = new JLabel("Losses: " + score.losses);
        JLabel tiesLabel = new JLabel("Ties: " + score.ties);

        winsLabel.setFont(new Font("Arial", Font.BOLD, 14));
        lossesLabel.setFont(new Font("Arial", Font.BOLD, 14));
        tiesLabel.setFont(new Font("Arial", Font.BOLD, 14));

        scorePanel.add(winsLabel);
        scorePanel.add(lossesLabel);
        scorePanel.add(tiesLabel);

        // ======= History Table =======
        String[] columnNames = {"Client Move", "Server Move", "Result", "Date"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        for (Game game : history) {
            Object[] rowData = {
                    game.clientGesture,
                    game.serverGesture,
                    game.result,
                    game.date.toString()
            };
            tableModel.addRow(rowData);
        }

        JTable gameTable = new JTable(tableModel);
        gameTable.setFillsViewportHeight(true);
        gameTable.setRowHeight(24);
        JScrollPane scrollPane = new JScrollPane(gameTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Game History"));

        // ======= Footer Panel (optional) =======
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> frame.dispose());
        footerPanel.add(closeButton);

        // ======= Add components to frame =======
        frame.add(scorePanel, BorderLayout.WEST);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(footerPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }


}