package com.fidelity.rps;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

public class RoshamboApplication implements CommandLineRunner {

	GameService gameService;

	public static void main(String[] args) {
		System.setProperty("java.awt.headless", "false");
		SpringApplication.run(RoshamboApplication.class);
	}

	public void run(String... args) throws Exception {
		gameService.playTheGame();
	}
}

