package game.characters;
import game.PlayerCharacter;
import game.Party;

public class Fighter extends PlayerCharacter {
    
    public Fighter(String name)
    {
        super(name, "fighter", 75, 0);
    }

    public int spell(Party party)
    {
        System.out.println(getName() + " looks confused at the command and grunts!\n This fighter is confused by rocks, he certainly can't cast spells!");
        return 0;
    }

    public int attack(Party party)
    {
        System.out.println(getName() + " swings their sword and attacks!");
        return -(12 + party.getPartyBonus());
    }
}
