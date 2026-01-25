package game;
public class PlayerCharacter extends Entity {
    
    private String charClass;
    private int mana; 

    public PlayerCharacter(String name, String playerClass, int health, int mana)
    {
        super(name, 1, health);
        charClass = playerClass;
        this.mana = mana;
    }

    public String getPCclass()
    {
        return charClass;
    }

    public int getMana()
    {
        return mana;
    }

    public String toString()
    {
        return "Name: " + getName() + "\nClass: " + charClass + "\nHealth: " + getHealth() + "\nMana: " + mana;
    }

    public String actionList()
    {
        return "1: Move\n2: Attack\n3: Defend\n4: Use Item\n5: Cast Spell"; // TODO: implement spell and item systems
    }
}


