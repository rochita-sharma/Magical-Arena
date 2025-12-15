package com.magical.arena.factories;

import com.magical.arena.models.Player;
import org.springframework.stereotype.Component;

@Component
public class PlayerFactory {
       public Player createPlayer(String name, Integer health, Integer strength, Integer attack ) {
           return new Player(name, health, strength, attack);
       }
}
