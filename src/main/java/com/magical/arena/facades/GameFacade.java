package com.magical.arena.facades;

import com.magical.arena.models.Arena;
import com.magical.arena.models.Player;
import com.magical.arena.services.ArenaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameFacade {
    private static Arena arena;
    private static final Logger log =  LoggerFactory.getLogger(GameFacade.class);

    public GameFacade(Player player1, Player player2) {
        this.arena = new Arena(player1, player2);
    }
    public static void startFight(){
        while(!arena.isFightOver()){
            List<Player> playerList = arena.getAttackerAndDefender();
            ArenaService.playRound(playerList.get(0), playerList.get(1));
            if(playerList.get(1).isAlive()){
                ArenaService.playRound(playerList.get(1), playerList.get(0));
            }
        }
        Player winner = arena.getPlayer1().isAlive() ? arena.getPlayer1() : arena.getPlayer2();
        log.info("Winner of this game is {}", winner.getName());
    }
}
