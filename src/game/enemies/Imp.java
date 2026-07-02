package game.enemies;
import game.Enemy;
import game.Encounter;

public class Imp extends Enemy {

    public Imp(int level)
    {
        super("Imp", level);
    }

    public int attack(Encounter encounter)
    {
        System.out.println("The imp attacks!");
        return -5;
    }
}