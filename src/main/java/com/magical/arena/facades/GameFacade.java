package com.magical.arena.facades;

import com.magical.arena.interfaces.IPlayer;
import com.magical.arena.models.Arena;
import com.magical.arena.services.ArenaService;
import com.magical.arena.services.GameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameFacade {
    private static GameService gameService;
    private static final Logger log =  LoggerFactory.getLogger(GameFacade.class);

    public GameFacade(GameService gameService) {
        this.gameService = gameService;
    }
    public static void startFight(){
        IPlayer playerA = gameService.getPlayerInput(1);
        IPlayer playerB = gameService.getPlayerInput(2);

        Arena arena = new Arena(playerA, playerB);
        while(!arena.isFightOver()){
            List<IPlayer> playerList = arena.getAttackerAndDefender();
            ArenaService.playRound(playerList.get(0), playerList.get(1));
            if(playerList.get(1).isAlive()){
                ArenaService.playRound(playerList.get(1), playerList.get(0));
            }
        }
        IPlayer winner = arena.getPlayer1().isAlive() ? arena.getPlayer1() : arena.getPlayer2();
        log.info("Winner of this game is {}", winner.getName());
    }
}
