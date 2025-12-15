package com.magical.arena.models;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Player {
    private String name;
    private Integer health;
    private Integer strength;
    private Integer attack;

    public Player() {

    }

    public Player(String name, Integer health, Integer strength, Integer attack) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.attack = attack;
    }

    public boolean isAlive() {
        return this.health > 0;
    }
}
