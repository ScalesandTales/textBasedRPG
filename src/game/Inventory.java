package game;

public class Inventory {
    
    private int healingPotions;
    private int manaPotions;
    private int gold;
    private double ropeLength;
    
    public Inventory()
    {
        healingPotions = 2;
        manaPotions = 2;
        gold = 100;
        ropeLength = 30.0;
    }

    public int getHealingPotions()
    {
        return healingPotions;
    }

    public void changeHealingPotions(int change)
    {
        healingPotions += change;
    }

    public int getManaPotions()
    {
        return manaPotions;
    }

    public void changeManaPotions(int change)
    {
        manaPotions += change;
    }

    public int getGold()
    {
        return gold;
    }

    public void changeGold(int change)
    {
        gold += change;
    }

    public double getRopeLength()
    {
        return ropeLength;
    }

    public void changeRopeLength(double change)
    {
        ropeLength += change;
    }

    public String toString()
    {
        return "Healing Potions: " + healingPotions + "\nMana Potions: " + manaPotions + "\nGold: " + gold + "\nRope Length: " + ropeLength + " meters";
    }
}