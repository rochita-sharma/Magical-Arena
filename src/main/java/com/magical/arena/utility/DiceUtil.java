package com.magical.arena.utility;


import java.util.concurrent.ThreadLocalRandom;

public class DiceUtil {
    private DiceUtil() {}

    public static int rollDice() {
        return ThreadLocalRandom.current().nextInt(1, 7);
    }
}
