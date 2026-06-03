package game;
public class PlayerCharacter extends Entity {
    
    private String charClass;
    private int mana;
    private Inventory inventory;

    public PlayerCharacter(String name, String playerClass, int health, int mana)
    {
        super(name, 1, health);
        charClass = playerClass;
        this.mana = mana;
        inventory = new Inventory();
    }

    public String getPCclass()
    {
        return charClass;
    }

    public int getMana()
    {
        return mana;
    }

    public String drinkHealthPotion()
    {
        if (charClass.equals("fighter") && inventory.getHealingPotions() > 0)
        {
            changeHealth(10);
            if (getHealth() > 75)
            {
                setHealth(75);
            }
            inventory.changeHealingPotions(-1);
            return  "\u001b[3m GULP \u001b[0m " + getName() + "'s health is now: " + getHealth();
        }
        else if (charClass.equals("bard") && inventory.getHealingPotions() > 0)
        {
            changeHealth(10);
            if (getHealth() > 50)
            {
                setHealth(50);
            }
            inventory.changeHealingPotions(-1);
            return  "\u001b[3m GULP \u001b[0m " + getName() + "'s health is now: " + getHealth();
        }
        else if (charClass.equals("cleric") && inventory.getHealingPotions() > 0)
        {
            changeHealth(10);
            if (getHealth() > 50)
            {
                setHealth(50);
            }
            inventory.changeHealingPotions(-1);
            return  "\u001b[3m GULP \u001b[0m " + getName() + "'s health is now: " + getHealth();
        }
        else if (charClass.equals("wizard") && inventory.getHealingPotions() > 0)
        {
            changeHealth(10);
            if (getHealth() > 25)
            {
                setHealth(25);
            }
            inventory.changeHealingPotions(-1);
            return  "\u001b[3m GULP \u001b[0m " + getName() + "'s health is now: " + getHealth();
        }
        else
        {
            return "No mana potions in inventory";
        }
    }

    
    public String drinkManaPotion()
    {
        if (charClass.equals("fighter"))
        {
            return "No mana pool";
        }
        else if (charClass.equals("Bard") && inventory.getManaPotions() > 0)
        {
            mana += 10;
            if (mana > 25)
            {
                mana -= mana - 25;
            }
            inventory.changeManaPotions(-1);
            return "\u001b[3m GULP \u001b[0m " + getName() + "'s mana is now: " + getMana();
        }
        else if (charClass.equals("cleric") && inventory.getManaPotions() > 0)
        {
            mana += 10;
            if (mana > 50)
            {
                mana -= mana - 50;
            }
            inventory.changeManaPotions(-1);
            return "\u001b[3m GULP \u001b[0m " + getName() + "'s mana is now: " + getMana();
        }
        else if (charClass.equals("wizard") && inventory.getManaPotions() > 0)
        {
            mana += 10;
            if (mana > 75)
            {
                mana -= mana - 75;
            }
            inventory.changeManaPotions(-1);
            return "\u001b[3m GULP \u001b[0m " + getName() + "'s mana is now: " + getMana();
        }
        else
        {
            return "No mana potions in inventory";
        }
    }

    public String useItem(String use)
    {
        if (use.equals("Healing Potion"))
        {
            return drinkHealthPotion();
        }
        else if (use.equals("Mana Potion"))
        {
            return drinkManaPotion();
        }
        else if (use.equals("Gold"))
        {
            return "not implemented yet";
        }
        else if (use.equals("Rope"))
        {
            return "not implemented yet";
        }
        else if (use.equals("-1"))
        {
            return "Cancelled";
        }
        else
        {
            return "Invalid selection";
        }
    }

    public Inventory getInventory()
    {
        return inventory;
    }

    public String playerActionList()
    {
        return "1: Use Item";
    }

    public String toString()
    {
        return "Name: " + getName() + "\nLevel: " + getLevel() + "\nClass: " + charClass + "\nHealth: " + getHealth() + "\nMana: " + mana;
    }
}


