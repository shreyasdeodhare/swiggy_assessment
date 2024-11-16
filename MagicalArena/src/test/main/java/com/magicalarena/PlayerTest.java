package com.magicalarena;

import org.junit.Test;
import static org.junit.Assert.*;

class PlayerTest {

    @Test
    public void testPlayerHealthReduction() {
        Player player = new Player(50, 5, 10);
        player.reduceHealth(20);
        assertEquals(30, player.getHealth());

        player.reduceHealth(50);
        assertEquals(0, player.getHealth());
    }

    @Test
    public void testPlayerIsAlive() {
        Player player = new Player(50, 5, 10);
        assertTrue(player.isAlive());

        player.reduceHealth(50);
        assertFalse(player.isAlive());
    }
}
