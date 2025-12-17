package com.magical.arena.models;

import com.magical.arena.interfaces.IPlayer;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
public class Arena {
     private final IPlayer player1;
     private final IPlayer player2;
     public Arena(IPlayer player1, IPlayer player2) {
         this.player1 = player1;
         this.player2 = player2;
     }
    public List<IPlayer> getAttackerAndDefender(){
        List<IPlayer> playerList = new ArrayList<>();
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
