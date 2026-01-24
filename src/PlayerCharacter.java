public class PlayerCharacter extends Entity {
    
    private String charClass;
    private int charMana;

    public PlayerCharacter(String name, String playerClass, int health)
    {
        super(name, 1, health);
        charClass = playerClass;
    }
}


