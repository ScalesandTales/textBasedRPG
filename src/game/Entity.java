package game;
public class Entity {
    
    private String name;
    private int level;
    private int health;

    public Entity(String name, int level, int health)
    {
        this.name = name;
        this.level = level;
        this.health = health;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String newName)
    {
        name = newName;
    }

    public void setLevel(int newLevel)
    {
        level = newLevel;
    }

    public int getLevel()
    {
        return level;
    }

    public void changeLevel(int change)
    {
        level += change;
    }

    public void setHealth(int newHealth)
    {
        health = newHealth;
    }

    public int getHealth()
    {
        return health;
    }

    public void changeHealth(int change)
    {
        health += change;
    }
}
