package com.fidelity.rps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.swing.*;

@SpringBootApplication
public class RpsApplication implements CommandLineRunner {

	@Autowired
	Score score;

	public static void main(String[] args) {
		System.setProperty("java.awt.headless", "false");
		SpringApplication.run(RpsApplication.class, args);
		//ApplicationContext spring = SpringApplication.run(RpsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		String prompt = "Will it be rock, paper or scissors?";
		String input = JOptionPane.showInputDialog(prompt);
		String result = "error";
		while (!input.equalsIgnoreCase("Q")) {
			//Score score = spring.getBean(Score.class);

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
			System.out.printf("Wins: %s, Losses: %s, Ties: %s", score.wins, score.losses, score.ties);
			JOptionPane.showMessageDialog(null, result);
			input = JOptionPane.showInputDialog(prompt);
		}

	}
}


class GameCartridge {

	void welcomeMessage(){
		System.out.print("Would you like to play a game?");
	}
}

class AtariGameConsole {
	@Autowired
	GameCartridge game;

	AtariGameConsole(GameCartridge game) {
		this.game = game;
	}

	void splashScreen() {
		game.welcomeMessage();
	}
}