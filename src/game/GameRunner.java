package game;
import game.characters.*;
import java.io.IOException;
import java.util.Scanner;

public class GameRunner
{
    private static int turnCount;
    private static int lastTurnAction;

    public static int getLastTurnAction()
    {
        return lastTurnAction;
    }

    public static void setLastTurnAction(int action)
    {
        lastTurnAction = action;
    }

    public static int getTurnCount()
    {
        return turnCount;
    }

    public static int readScanner(Scanner input)
    {
        int select;
        try
        {
            select = input.nextInt();
        }
        catch (Exception e)
        {
            input.nextLine();
            return -1;
        }
        return select;
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("New Game? y/n ");

        if (input.nextLine().equals("y"))
        {
            Party party;
            System.out.println("Load party from a text file? y/n");
            if (input.nextLine().equals("y"))
                {
                    System.out.println("Enter the file path (example: src/game/CharacterSheet.txt):");
                    String filePath = input.nextLine().trim();
                    try
                    {
                        party = PartyFileLoader.loadParty(filePath);
                        System.out.println("Loaded party from " + filePath);
                    }
                    catch (IOException | IllegalArgumentException ex)
                    {
                        System.out.println("Could not load party file: " + ex.getMessage());
                        System.out.println("Falling back to the default party.");
                        party = new Party("Gays", 2);
                        party.addCharacter(new Bard("Apollo"));
                        party.addCharacter(new Wizard("Skye"));
                    }
                }
                else
                    {
                        System.out.println("Party name: ");
                        String partName = input.nextLine();
                        System.out.println("Party size (max 4): ");
                        int partSize = input.nextInt();
                        if (partSize > 4)
                        {
                            partSize = 4;
                        }
                        input.nextLine();
                        party = new Party(partName, partSize);

                        for (int i = 0; i < party.getSize(); i++)
                        {
                            PlayerCharacter character;
                            System.out.println("Character name: ");
                            String inName = input.nextLine();
                            while (true)
                            {
                                System.out.println("Character class: ");
                                System.out.println("Options: fighter, wizard, bard, cleric");
                                String inClass = input.nextLine();
                                if (inClass.equals("fighter"))
                                {
                                    character = new Fighter(inName);
                                    break;
                                }
                                else if (inClass.equals("wizard"))
                                {
                                    character =  new Wizard(inName);
                                    break;
                                }
                                else if (inClass.equals("bard"))
                                {
                                    character = new Bard(inName);
                                    break;
                                }
                                else if ((inClass.equals("cleric")))
                                {
                                    character = new Cleric(inName);
                                    break;
                                }
                                else
                                {
                                    System.out.println("Invalid class");
                                }
                            }
                            party.addCharacter(character);
            
                            System.out.println();
                        }
                    }
                    
            System.out.println();
            System.out.println();
            party.getInfo();
            System.out.println();
            
            System.out.println("The Map:");
            new GameWorld();
            GameWorld.printMap(party.getX(), party.getY());

            System.out.println();
            
            System.out.println("""
            A party of adventurers sets out on a journey across the kingdom after reports of 
            dangerous monsters begin appearing in every region. Traveling through forests, 
            mountains, deserts, and swamps, they face goblin warbands, giant spiders, trolls, 
            wyverns, and other fearsome creatures threatening towns and trade routes. Along 
            the way, they grow stronger, uncover ancient secrets, and form close bonds 
            through their shared battles. Their travels eventually reveal that the monsters 
            are being driven from their habitats by a powerful beast gathering an army in 
            the far north. The party embarks on one final quest to confront the creature, 
            defeat its forces, and restore peace to the land.""");

            System.out.println();
            
            Turn.turn(party, input);

            System.out.println();

            while(true)
            {
                Turn.turn(party, input);
                
                int randomEncounter = (int) (Math.random() * 2) + 1;
                
                if (randomEncounter == 1 && GameRunner.getLastTurnAction() == 3)
                {
                    Encounter encounter = new Encounter(party, GameWorld.getMap(), party.getX(), party.getY(), input);
                    encounter.playEncounter(party);
                }
                else
                {
                    Turn.turn(party, input);
                }
                turnCount++;
                
                if (turnCount > 5)
                {
                    System.out.println("You have reached the end of the demo. Thank you for playing!");
                    break;
                }
            }
        }
        else
        {
            System.out.println("Shutting down");
        }
        input.close();
    }
}