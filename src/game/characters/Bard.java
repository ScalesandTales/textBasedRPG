package game.characters;
import game.PlayerCharacter;
import game.Party;

public class Bard extends PlayerCharacter{

    public Bard(String name)
    {
        super(name, "bard", 50, 25);
    }

    public void spell(Party party)
    {
        System.out.println(getName() + " performs a song to inspire allies!");
        changeMana(-5);
        party.partyMod(5 + party.getPartyLevel());
    }

    public int attack(Party party)
    {
        System.out.println(getName() + " swings their lute and attacks!");
        return -(5 + party.getPartyBonus());
    }
}
