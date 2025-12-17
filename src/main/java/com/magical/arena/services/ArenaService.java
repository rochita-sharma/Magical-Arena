package com.magical.arena.services;

import com.magical.arena.interfaces.IPlayer;
import com.magical.arena.models.Player;
import com.magical.arena.utility.DiceUtil;
import com.magical.arena.utility.LoggerUtil;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;


@Service
public class ArenaService {

    private static final Logger log = LoggerUtil.getLogger(ArenaService.class);

    public static void playRound(IPlayer attacker, IPlayer defender) {
        final int attackRoll = DiceUtil.rollDice();
        final int defenceRoll = DiceUtil.rollDice();
        int attackValue = attacker.getAttack() * attackRoll;
        int defenceValue = defender.getStrength() * defenceRoll;

        int damage = attackValue-defenceValue;
        log.info("{} attacks! Rolls {}, dealing {} damage",
                attacker.getName(), attackRoll, attackValue);
        log.info("{} defends! Rolls {}, defending {} damage ",
                defender.getName(), defenceRoll, defenceValue);
        if(damage > 0) {
            defender.setHealth(defender.getHealth()-damage);

            log.info("{} takes {} damage, health now {}",
                    defender.getName(), damage, defender.getHealth());
        }else{
            log.info("{} fully defends the attack.",
                    defender.getName());
        }
    }
}
