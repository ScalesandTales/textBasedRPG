package game.characters;
import game.PlayerCharacter;
import game.Party;

public class Cleric extends PlayerCharacter {
    public Cleric(String name)
    {
        super(name, "cleric", 50, 50);
    }

    public void spell(Party party)
    {
        System.out.println(getName() + " casts a healing spell on the party!");
        changeMana(-10);
        party.partyAffect(5 + party.getPartyBonus());
    }

    public int attack(Party party)
    {
        System.out.println(getName() + " swings their mace and attacks!");
        return -(7 + party.getPartyBonus());
    }
}