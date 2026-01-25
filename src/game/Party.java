package game;
public class Party {
    
    private String partyName;
    private int partySize;
    private PlayerCharacter[] charList;
    private int counter = 0;
    private boolean inCombat;
    
    public Party(String inName, int size)
    {
        partyName = inName;
        partySize = size;
        inCombat = false;
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

    public boolean getStatus()
    {
        return inCombat;
    }

    public void setStatus(boolean set)
    {
        inCombat = set;
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
        if (getStatus())
        {
            return ""; // TODO: combat actions to be implemented
        }
        else
        {
            return "1: Inspect character"; // TODO: other options to be implemented
        }
    }

    public void partyList()
    {
        for(int i = 0; i < charList.length; i++)
        {
            System.out.println(i + ". " + charList[i].getName());
        }
    }
}
