package game;
import game.characters.*;
import java.util.Scanner;

public class GameRunner
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("New Game? y/n ");

        if (input.nextLine().equals("y"))
        {
            // System.out.println("Party name: ");
            // String partName = input.nextLine();
            // System.out.println("Party size (max 4): ");
            // int partSize = input.nextInt();
            // if (partSize > 4)
            // {
            //     partSize = 4;
            // }
            // input.nextLine();
            // Party party = new Party(partName, partSize);
            
            Party party = new Party("Gays", 2); // Default party for dev purposes
            party.addCharacter(new Bard("Apollo"));
            party.addCharacter(new Wizard("Skye"));
            
            System.out.println();

            // for (int i = 0; i < party.getSize(); i++)
            // {
            //     PlayerCharacter character;
            //     System.out.println("Character name: ");
            //     String inName = input.nextLine();
            //     while (true)
            //     {
            //         System.out.println("Character class: ");
            //         String inClass = input.nextLine();
            //         if (inClass.equals("fighter"))
            //         {
            //             character = new Fighter(inName);
            //             break;
            //         }
            //         else if (inClass.equals("wizard"))
            //         {
            //             character =  new Wizard(inName);
            //             break;
            //         }
            //         else if (inClass.equals("bard"))
            //         {
            //             character = new Bard(inName);
            //             break;
            //         }
            //         else if ((inClass.equals("cleric")))
            //         {
            //             character = new Cleric(inName);
            //             break;
            //         }
            //         else
            //         {
            //             System.out.println("Invalid class");
            //         }
            //     }
            //     party.addCharacter(character);

            //     System.out.println();
            // }

            System.out.println();
            
            System.out.println("The Map:");
            new GameWorld();
            GameWorld.printMap(2, 2);
            
            // TODO: insert lore and worldbuilding here

            System.out.println();
            
            Turn.turn(party, input);

            System.out.println();

            while(true)
            {
                boolean randomEncounter = Math.random() > .5;
                if (randomEncounter)
                {
                    // Encounter.encounter(party, input);
                }
                else
                {
                    Turn.turn(party, input);
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