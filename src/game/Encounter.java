package game;
import game.enemies.*;
import java.util.ArrayList;

public class Encounter {

    private int tileType;
    private int enemyNum = (int)(Math.random() * 3 + 1);
    private ArrayList<Enemy> enemyList = new ArrayList<>();


    public Encounter(Party party, Tile[][] map, int x, int y)
    {
        tileType = map[x][y].getTileType();

        for(int i = 0; i < enemyNum; i++)
        {
            int enemyType = (int)(Math.random() * 3 + 1);
            if (enemyType == 1)
            {
                Kobold kobold = new Kobold(GameRunner.getTurnCount());
                enemyList.add(kobold);
            }
            else if (enemyType == 2)
            {
                
                Goblin goblin = new Goblin(GameRunner.getTurnCount());
                enemyList.add(goblin);
            }
            else
            {
                Imp imp = new Imp(GameRunner.getTurnCount());
                enemyList.add(imp);
            }
        }
    }

    public void playEncounter(Party party)
    {
        if (enemyList.isEmpty())
        {
            System.out.println("You found no enemies in this area.");
            return;
        }

        System.out.println("You encounter " + enemyList.size() + " enemies!");

        for (int i = 0; i < enemyList.size(); i++)
        {
            Enemy enemy = enemyList.get(i);
            System.out.println((i + 1) + ". " + enemy.getName()
                    + " (Level " + enemy.getLevel()
                    + ", Health " + enemy.getHealth() + ")");
        }

        System.out.println("Battle begins!\n");

        while (!enemyList.isEmpty())
        {
            boolean partyStillAlive = false;

            for (int i = 0; i < party.getSize(); i++)
            {
                if (enemyList.isEmpty())
                {
                    break;
                }

                PlayerCharacter hero = party.getCharacter(i);
                if (hero == null || hero.getHealth() <= 0)
                {
                    continue;
                }

                partyStillAlive = true;

                Enemy target = enemyList.get(0);
                int damage = 1 + hero.getLevel() + (int) (Math.random() * 3);
                target.changeHealth(-damage);

                System.out.println(hero.getName() + " attacks " + target.getName()
                        + " for " + damage + " damage.");
                System.out.println(target.getName() + " health: " + target.getHealth());

                if (target.getHealth() <= 0)
                {
                    System.out.println(target.getName() + " is defeated!");
                    enemyList.remove(0);
                }
            }

            if (!partyStillAlive)
            {
                System.out.println("All party members are defeated. The enemies win.");
                return;
            }

            if (enemyList.isEmpty())
            {
                break;
            }

            for (Enemy enemy : enemyList)
            {
                int targetIndex = (int) (Math.random() * party.getSize());
                PlayerCharacter hero = party.getCharacter(targetIndex);

                if (hero == null || hero.getHealth() <= 0)
                {
                    continue;
                }

                int damage = 1 + enemy.getLevel() + (int) (Math.random() * 2);
                hero.changeHealth(-damage);

                System.out.println(enemy.getName() + " hits " + hero.getName()
                        + " for " + damage + " damage.");
                System.out.println(hero.getName() + " health: " + hero.getHealth());

                if (hero.getHealth() <= 0)
                {
                    System.out.println(hero.getName() + " is knocked out!");
                }
            }
        }

        System.out.println("The battle is over. " + (enemyList.isEmpty() ? "You win!" : "The enemies win."));
        party.addXP(enemyNum * 3);
        party.levelUpIfAble();
    }
}