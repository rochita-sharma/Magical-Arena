package com.magical.arena.services;

import com.magical.arena.factories.PlayerFactory;
import com.magical.arena.models.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    @Autowired
    private final InputService inputService;
    @Autowired
    private final PlayerFactory playerFactory;

    public GameService(InputService inputService, PlayerFactory playerFactory) {
        this.inputService = inputService;
        this.playerFactory = playerFactory;
    }

    public Player getPlayerInput(int playerNumber) {
        String name = inputService.readString("Enter name for Player " + playerNumber + ": ");
        Integer health = inputService.readPositiveInt("Enter health for " + name +": ");
        Integer strength = inputService.readPositiveInt("Enter Strength for " + name +": ");
        Integer attack = inputService.readPositiveInt("Enter attack for " + name +": ");

        return playerFactory.createPlayer(name, health, strength, attack);
    }
}
