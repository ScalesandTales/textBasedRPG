package game;
public class Party 
{
    
    private String partyName;
    private int partySize;
    private PlayerCharacter[] charList;
    private int counter = 0;
    private int partyX = 2;
    private int partyY = 2;
    private int partyXP = 0;
    private int partyLevel = 1;
    private int partyModifer = 0;
    
    public Party(String inName, int size)
    {
        partyName = inName;
        partySize = size;
        charList  = new PlayerCharacter[size];
    }
    
    public String getName()
    {
        return partyName;
    }

    public int getSize()
    {
        return partySize;
    }

    public void addCharacter(PlayerCharacter pc)
    {
        charList[counter] = pc;
        counter++;
    }

    public PlayerCharacter getCharacter(int num)
    {
        return charList[num];
    }

    public String actionList()
    {
        return "1: Party Select\n2: Map\n3: Move"; // TODO: other options to be implemented
    }

    public void partyList()
    {
        for(int i = 0; i < charList.length; i++)
        {
            System.out.println(i + ". " + charList[i].getName());
        }
    }

    public void getInfo()
    {
        System.out.println("Party Name: " + partyName);
        System.out.println("Party Level: " + partyLevel);
        System.out.println("Party XP: " + partyXP);
        System.out.println("Characters:");
        partyList();
    }

    public void partyMod(int mod)
    {
        partyModifer += mod;
    }

    public int getPartyMod()
    {
        return partyModifer;
    }

    public void listCharactersByHealthAscending()
    {
        PlayerCharacter[] sorted = charList.clone();

        for (int i = 0; i < sorted.length - 1; i++)
        {
            int minIndex = i;

            for (int j = i + 1; j < sorted.length; j++)
            {
                if (sorted[j] != null && (sorted[minIndex] == null || sorted[j].getHealth() < sorted[minIndex].getHealth()))
                {
                    minIndex = j;
                }
            }

            PlayerCharacter temp = sorted[i];
            sorted[i] = sorted[minIndex];
            sorted[minIndex] = temp;
        }

        for (int i = 0; i < sorted.length; i++)
        {
            if (sorted[i] != null)
            {
                System.out.println((i + 1) + ". " + sorted[i].getName()
                        + " - " + sorted[i].getHealth() + " HP");
            }
        }
    }

    public int getX()
    {
        return partyX;
    }

    public int getY()
    {
        return partyY;
    }

    public void moveParty(String in)
    {
        if (in.equals("^") && partyX - 1 > -1)
        {
            partyX -= 1;
        }
        else if (in.equals("v") && partyX + 1 < 5)
        {
            partyX += 1;
        }
        else if (in.equals("<") && partyY - 1 > -1)
        {
            partyY -= 1;
        }
        else if (in.equals(">") && partyY + 1 < 5)
        {
            partyY += 1;
        }
        else
        {
            System.out.println("Invalid move");
        }
    }

    public void partyAffect(int effect)
    {
        for (int i = 0; i < charList.length; i++)
        {
            charList[i].changeHealth(effect);
        }
    }

    public int getXP()
    {
        return partyXP;
    }

    public void addXP(int xp)
    {
        partyXP += xp;
    }

    public void levelUpIfAble()
    {
        if (partyXP >= partyLevel * 10)
        {
            partyLevel++;
            System.out.println("Your party leveled up to level " + partyLevel + "!");
            for (int i = 0; i < charList.length; i++)
            {
                charList[i].setLevel(partyLevel);
            }
        }
    }

    public int getPartyLevel()
    {
        return partyLevel;
    }

    public int getPartyBonus()
    {
        return partyLevel + partyModifer;
    }
}
