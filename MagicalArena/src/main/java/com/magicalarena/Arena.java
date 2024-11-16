package com.magicalarena;

public class Arena {
    private Player playerA;
    private Player playerB;
    private Dice dice;

    public Arena(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
        this.dice = new Dice();
    }

    public void fight() {

        Player attacker = (playerA.getHealth() <= playerB.getHealth()) ? playerA : playerB;
        Player defender = (attacker == playerA) ? playerB : playerA;

        while (playerA.isAlive() && playerB.isAlive()) {

            int attackRoll = dice.roll();
            int defendRoll = dice.roll();

            int attackDamage = attacker.getAttack() * attackRoll;
            int defendStrength = defender.getStrength() * defendRoll;

            int damage = Math.max(0, attackDamage - defendStrength);
            defender.reduceHealth(damage);

            System.out.printf("%s attacks %s for %d damage. %s's health is now %d%n",
                    attacker, defender, damage, defender, defender.getHealth());

            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }

        if (playerA.isAlive()) {
            System.out.println("Player A wins!");
        } else {
            System.out.println("Player B wins!");
        }
    }

    public static void main(String[] args) {
        Player playerA = new Player(50, 5, 10);
        Player playerB = new Player(100, 10, 5);

        Arena arena = new Arena(playerA, playerB);
        arena.fight();
    }
}