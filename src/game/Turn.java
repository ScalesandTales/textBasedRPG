package game;
import java.util.Scanner;

public class Turn
{   
    public static void turn(Party party, Scanner input)
    {
        System.out.println("Select: \n" + party.actionList());
        int select = input.nextInt();
        int characterSelect = select;
        if (select == 1)
        {
            System.out.println("Select character:");
            party.partyList();
            System.out.println();
            characterSelect = input.nextInt();
            System.out.println(party.getCharacter(characterSelect));
            System.out.println("\nActions:\n" + party.getCharacter(characterSelect).playerActionList());
            select = input.nextInt();
            if (select == 1)
            {
                // Attack action
            }
            else if (select == 2)
            {
                // Defend action
            }
            else if (select == 3)
            {
                System.out.println("Which item do you want to use?\n" + party.getCharacter(characterSelect).getInventory());
                input.nextLine();
                String itemSelect = input.nextLine();
                System.out.println(party.getCharacter(characterSelect).useItem(itemSelect));
            }
            else if (select == 4)
            {

            }
            else if (select == 5)
            {

            }
            else
            {
                System.out.println("Invalid action");
            }
        }
        else if (select == 2)
        {
            System.out.println("Map:");
            GameWorld.printMap(party.getX(), party.getY());
        }
        else if (select == 3)
        {
            input.nextLine();
            System.out.println("Left: < | Right > | Up: ^ | Down: v");
            String moveSelect = input.nextLine();
            party.moveParty(moveSelect);
            GameWorld.printMap(party.getX(), party.getY());
        }
    }
}