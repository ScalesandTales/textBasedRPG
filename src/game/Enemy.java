package game;
public class Enemy extends Entity
{
    private Boolean dead = false;

    public Enemy(String name, int level)
    {
        super(name, level, 0);
        
        if (level <= 5)
        {
            setHealth(10);
        }
        else if (level <= 10)
        {
            setHealth(15);
        }
        else
        {
            setHealth(25);
        }
    }

    public Boolean isDead()
    {
        return dead;
    }

    public void setDead(Boolean dead)
    {
        this.dead = dead;
    }
}