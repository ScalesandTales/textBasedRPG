package game.enemies;
import game.Enemy;
import game.Encounter;

public class Kobold extends Enemy {

    public Kobold(int level)
    {
        super("kobold", level);
    }

    public int attack(Encounter encounter)
    {
        System.out.println("The kobold attacks!");
        return -(2 + encounter.getKoboldAmount());
    }
}
