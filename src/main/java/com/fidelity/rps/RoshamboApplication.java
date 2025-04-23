package com.fidelity.rps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RoshamboApplication implements CommandLineRunner {

	@Autowired
	GameService gameService;

	public static void main(String[] args) {
		System.setProperty("java.awt.headless", "false");
		SpringApplication.run(RoshamboApplication.class);
	}

	@Override
	public void run(String... args) throws Exception {
		gameService.playTheGame();
	}
}

