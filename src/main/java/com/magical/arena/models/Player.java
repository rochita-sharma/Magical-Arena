package com.magical.arena.models;

import com.magical.arena.interfaces.IPlayer;


public class Player extends IPlayer {

    public Player(String name, Integer health, Integer strength, Integer attack) {
        super(name, health, strength, attack);
    }
    @Override
    public boolean isAlive() {
        return health > 0;
    }
}
