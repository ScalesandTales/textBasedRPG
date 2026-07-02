package game;
import game.characters.Bard;
import game.characters.Cleric;
import game.characters.Fighter;
import game.characters.Wizard;
import game.enemies.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Encounter 
{
    
    private int tileType;
    private int enemyNum = (int)(Math.random() * 3 + 1);
    private ArrayList<Enemy> enemyList = new ArrayList<>();
    private ArrayList<PlayerCharacter> partyList = new ArrayList<>();
    private Entity[] turnList;
    private final Scanner scanner;
    private int input;
    
    
    public Encounter(Party party, Tile[][] map, int x, int y, Scanner scanner)
    {
        this.scanner = scanner;
        int input = 0;
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

        for (int i = 0; i < party.getSize(); i++)
        {
            partyList.add(party.getCharacter(i));
        }

        int entityNum = enemyList.size() + party.getSize();
        turnList = new Entity[entityNum];
        
        int i = 0;
        while (i < enemyNum)
        {
            int rand = (int)(Math.random() * entityNum);
            if (turnList[rand] == null)
            {
                turnList[rand] = enemyList.get(i);
                i++;
            }
        }

        int g = 0;
        while (g < party.getSize())
        {
            int rand = (int)(Math.random() * entityNum);
            if (turnList[rand] == null)
            {
                turnList[rand] = party.getCharacter(g);
                g++;
            }
        }
    }

    public int getKoboldAmount()
    {
        int amount = 0;
        for (int i = 0; i < enemyList.size(); i++)
        {
            if (enemyList.get(i) instanceof Kobold)
            {
                amount++;
            }
        }
        return amount;
    }

    private void printTurnList(int turn)
    {
        int x = 0;
       for (int i = turn; i < turnList.length; i++)
        {
            System.out.println(x + ". " + turnList[i].getName());
            x++;
        }
        for (int i = 0; i < turn; i++)
        {
            System.out.println(x + ". " + turnList[i].getName());
            x++;
        }
    }

    private int targetList()
    {
        System.out.println("Choose target: ");
        for (int i = 0; i < enemyList.size(); i++)
        {
            System.out.println(i + ". " + enemyList.get(i).getName());
        }
        
        return GameRunner.readScanner(scanner);
    }

    public void playEncounter(Party party)
    {

        System.out.println("You encounter ");
    
        for (int i = 0; i < enemyList.size(); i++)
        {
            System.out.println(enemyList.get(i).getName());
        }

        System.out.println("-------------------------------");
        
        boolean combat = true;
        int turn = 0;
        while (combat)
        {
            if (turn == turnList.length)
            {
                turn = 0;
            }  
            
            printTurnList(turn);
            System.out.println("-------------------------------");
            System.out.println("It is " + turnList[turn].getName() + "'s turn.");
            System.out.println("-------------------------------");
                
            if (turnList[turn] instanceof PlayerCharacter)
            {
                PlayerCharacter activePC;
                activePC = (PlayerCharacter) turnList[turn];

                if (turnList[turn] instanceof Fighter && activePC.isDead() == false)
                {
                    Fighter actFighter = (Fighter) turnList[turn];
                    activePC.combatActionList();
                    input = GameRunner.readScanner(scanner);
                    
                    if (input == 1)
                    {
                        System.out.println("Which item do you want to use?\n" + activePC.getInventory());
                        scanner.nextLine();
                        String itemSelect = scanner.nextLine();
                        System.out.println(activePC.useItem(itemSelect));
                        System.out.println("-------------------------------");
                    }
                    else if (input == 2)
                    {
                        enemyList.get(targetList()).changeHealth(actFighter.attack(party));
                        System.out.println("-------------------------------");
                    }
                    else if (input == 3)
                    {
                        enemyList.get(targetList()).changeHealth(actFighter.spell(party));
                        System.out.println("-------------------------------");
                    }
                    else
                    {
                        System.out.println("Invalid selection");
                    }
                }
                else if (turnList[turn] instanceof Wizard && activePC.isDead() == false)
                {
                    Wizard actWizard = (Wizard) activePC;
                    activePC.combatActionList();
                    input = GameRunner.readScanner(scanner);

                   if (input == 1)
                    {
                        System.out.println("Which item do you want to use?\n" + activePC.getInventory());
                        scanner.nextLine();
                        String itemSelect = scanner.nextLine();
                        System.out.println(activePC.useItem(itemSelect));
                        System.out.println("-------------------------------");
                    }
                    else if (input == 2)
                    {
                        enemyList.get(targetList()).changeHealth(actWizard.attack(party));
                        System.out.println("-------------------------------");
                    }
                    else if (input == 3)
                    {
                        enemyList.get(targetList()).changeHealth(actWizard.spell(party));
                        System.out.println("-------------------------------");
                    }
                    else
                    {
                        System.out.println("Invalid selection");
                    }
                }
                else if (turnList[turn] instanceof Bard)
                {
                    Bard actBard = (Bard) activePC;
                    activePC.combatActionList();
                    input = GameRunner.readScanner(scanner);

                    if (input == 1)
                    {
                        System.out.println("Which item do you want to use?\n" + activePC.getInventory());
                        scanner.nextLine();
                        String itemSelect = scanner.nextLine();
                        System.out.println(activePC.useItem(itemSelect));
                        System.out.println("-------------------------------");
                    }
                    else if (input == 2)
                    {
                        enemyList.get(targetList()).changeHealth(actBard.attack(party));
                        System.out.println("-------------------------------");
                    }
                    else if (input == 3)
                    {
                        actBard.spell(party);
                        System.out.println("-------------------------------");
                    }
                    else
                    {
                        System.out.println("Invalid selection");
                    }
                }
                else if (turnList[turn] instanceof Cleric && activePC.isDead() == false)
                {
                    Cleric actCleric = (Cleric) activePC;
                    activePC.combatActionList();
                    input = GameRunner.readScanner(scanner);

                    if (input == 1)
                    {
                        System.out.println("Which item do you want to use?\n" + activePC.getInventory());
                        scanner.nextLine();
                        String itemSelect = scanner.nextLine();
                        System.out.println(activePC.useItem(itemSelect));
                        System.out.println("-------------------------------");
                    }
                    else if (input == 2)
                    {
                        enemyList.get(targetList()).changeHealth(actCleric.attack(party));
                        System.out.println("-------------------------------");
                    }
                    else if (input == 3)
                    {
                        actCleric.spell(party);
                        System.out.println("-------------------------------");
                    }
                    else
                    {
                        System.out.println("Invalid selection");
                    }
                }
                else
                {
                    System.out.println(activePC.getName() + " is dead and cannot act.");
                }
            }
            else
            {
                Enemy actEnemy = (Enemy) turnList[turn];
                int rand = (int)(Math.random() * partyList.size());

                if (actEnemy instanceof Goblin && actEnemy.isDead() == false)
                {
                    Goblin goblin = (Goblin) actEnemy;
                    partyList.get(rand).changeHealth(goblin.attack(this));
                }
                else if (actEnemy instanceof Imp && actEnemy.isDead() == false)
                {
                    Imp imp = (Imp) actEnemy;
                    partyList.get(rand).changeHealth(imp.attack(this));
                }
                else if (actEnemy instanceof Kobold)
                {
                    Kobold kobold = (Kobold) actEnemy;
                    partyList.get(rand).changeHealth(kobold.attack(this));
                } 
            }

            for (int i = 0; i < enemyList.size(); i++)
            {
                if (enemyList.get(i).getHealth() <= 0)
                {
                    System.out.println(enemyList.get(i).getName() + " has been defeated!");
                    enemyList.get(i).setDead(true);
                    enemyList.remove(i);
                }
            }

            for (int i = 0; i < partyList.size(); i++)
            {
                if (partyList.get(i).getHealth() <= 0)
                {
                    System.out.println(partyList.get(i).getName() + " has been defeated!");
                    partyList.get(i).setDead(true);
                    partyList.remove(i);
                }
            }
                
            if (enemyList.size() == 0)
            {
                combat = false;
                System.out.println("Your party has defeated the enemies!");
                party.addXP(enemyNum * 3);
                party.levelUpIfAble();
                combat = false;
            }
            else if (party.getSize() == 0)
            {
                combat = false;
                System.out.println("Your party has been defeated!");
                System.exit(0);
            }
            turn++;
        }
    }
}
