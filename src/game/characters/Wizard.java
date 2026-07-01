package game.characters;
import game.PlayerCharacter;
import game.Party;

public class Wizard extends PlayerCharacter {
    
    public Wizard(String name)
    {
        super(name, "wizard", 25, 75);
    }

    public int spell(Party party)
    {
        System.out.println(getName() + " casts a fireball at the enemy!");
        changeMana(-10);
        return -(12 + party.getPartyBonus());
    }

    public int attack(Party party)
    {
        System.out.println(getName() + " swings with their staff!");
        return -(2 + party.getPartyBonus());
    }
}
