package com.magical.arena.interfaces;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public abstract class IPlayer {
    protected final String name;
    protected Integer health;
    protected final Integer strength;
    protected final Integer attack;

    public IPlayer(String name, Integer health, Integer strength, Integer attack) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.attack = attack;
    }

    public abstract boolean isAlive();

}
