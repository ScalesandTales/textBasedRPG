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
        System.out.println(charList.length);
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
}
