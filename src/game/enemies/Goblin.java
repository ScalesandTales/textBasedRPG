package game.enemies;
import game.Enemy;
import game.Encounter;

public class Goblin extends Enemy{
    
    public Goblin(int level)
    {
        super("goblin", level);
    }

    public int attack(Encounter encounter)
    {
        System.out.println("The goblin attacks!");
        return -10;
    }
}
