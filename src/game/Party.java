package game;
public class Party {
    
    private String partyName;
    private int partySize;
    private PlayerCharacter[] charList;
    private int counter = 0;
    
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
        return "1: Character Select\n2: Map\n3: Move"; // TODO: other options to be implemented
    }

    public void partyList()
    {
        for(int i = 0; i < charList.length; i++)
        {
            System.out.println(i + ". " + charList[i].getName());
        }
    }
}
