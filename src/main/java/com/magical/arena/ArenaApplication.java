package com.magical.arena;

import com.magical.arena.facades.GameFacade;
import com.magical.arena.factories.PlayerFactory;
import com.magical.arena.models.Player;
import com.magical.arena.services.ConsoleInputService;
import com.magical.arena.services.GameService;
import com.magical.arena.services.InputService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ArenaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =
                SpringApplication.run(ArenaApplication.class, args);
        GameService gameService = context.getBean(GameService.class);
        Player playerA = gameService.getPlayerInput(1);
        Player playerB = gameService.getPlayerInput(2);
        GameFacade game = new GameFacade(playerA, playerB);
        game.startFight();
	}

}
