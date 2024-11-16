package com.magicalarena;

import org.junit.Test;
import static org.junit.Assert.*;

class DiceTest {

    @Test
    public void testDiceRoll() {
        Dice dice = new Dice();
        for (int i = 0; i < 1000; i++) {
            int roll = dice.roll();
            assertTrue(roll >= 1 && roll <= 6);
        }
    }

    @Test
    public void testDiceRollDistribution() {
        Dice dice = new Dice();
        int[] counts = new int[6];
        int rolls = 6000;

        for (int i = 0; i < rolls; i++) {
            int roll = dice.roll();
            counts[roll - 1]++;
        }

        for (int count : counts) {
            assertTrue(count > 900 && count < 1100);
        }
    }
}
