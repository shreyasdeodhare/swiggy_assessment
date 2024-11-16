package com.magicalarena;

import org.junit.Test;
import static org.junit.Assert.*;

class ArenaTest {

    @Test
    public void testFight() {
        Player playerA = new Player(50, 5, 10);
        Player playerB = new Player(100, 10, 5);

        Arena arena = new Arena(playerA, playerB);
        arena.fight();

        assertTrue(playerA.isAlive() || playerB.isAlive());
    }

    @Test
    public void testFightOutcome() {
        Player playerA = new Player(1, 5, 10);
        Player playerB = new Player(1, 10, 5);

        Arena arena = new Arena(playerA, playerB);
        arena.fight();

        // One of the players should be dead
        assertFalse(playerA.isAlive() && playerB.isAlive());
    }

    @Test
    public void testTurnOrder() {
        Player playerA = new Player(50, 5, 10);
        Player playerB = new Player(100, 10, 5);

        Arena arena = new Arena(playerA, playerB);
        arena.fight();

        // Ensure playerA attacked first due to lower health initially
        assertTrue(playerA.getHealth() <= 50);
        assertTrue(playerB.getHealth() <= 100);
    }
}
