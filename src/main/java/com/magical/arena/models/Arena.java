package com.magical.arena.models;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class Arena {
     Player player1;
     Player player2;
     public Arena(Player player1, Player player2) {
         this.player1 = player1;
         this.player2 = player2;
     }
    public List<Player> getAttackerAndDefender(){
        List<Player> playerList = new ArrayList<>();
        if(this.player1.getHealth() <= this.player2.getHealth()) {
            playerList.add(this.player1);
            playerList.add(this.player2);
            return playerList;
        }
        playerList.add(this.player2);
        playerList.add(this.player1);
        return playerList;
    }

    public boolean isFightOver(){
        return !this.player1.isAlive() || !this.player2.isAlive();
    }
}
