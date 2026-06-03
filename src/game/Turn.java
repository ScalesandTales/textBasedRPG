package game;
import java.util.Scanner;

public class Turn
{   
    public static void turn(Party party, Scanner input)
    {
        System.out.println("Select: \n" + party.actionList());
        int select = GameRunner.readScanner(input);
        int characterSelect = select;
        if (select == 1)
        {
            GameRunner.setLastTurnAction(1);
            System.out.println("Party Select: (-1 to cancel)");
            party.partyList();
            System.out.println(party.getSize() + ". List characters in need of healing");
            System.out.println();
            characterSelect = GameRunner.readScanner(input);
            if (characterSelect == party.getSize())
            {
                party.listCharactersByHealthAscending();
            }
            else if (characterSelect == -1)
            {
                Turn.turn(party, input);
                return;
            }
            else
            {
                System.out.println(party.getCharacter(characterSelect));
                System.out.println("\nActions: (-1 to cancel)\n" + party.getCharacter(characterSelect).playerActionList());
                select = GameRunner.readScanner(input);
                
                if (select == 1)
                {
                    System.out.println("Which item do you want to use?\n" + party.getCharacter(characterSelect).getInventory());
                    input.nextLine();
                    String itemSelect = input.nextLine();
                    System.out.println(party.getCharacter(characterSelect).useItem(itemSelect));
                }
                else if (select == -1)
                {
                    Turn.turn(party, input);
                }
                else
                {
                    System.out.println("Invalid action");
                }
            }
        }
        else if (select == 2)
        {
            GameRunner.setLastTurnAction(2);
            System.out.println("Map:");
            GameWorld.printMap(party.getX(), party.getY());
            Turn.turn(party, input);
        }
        else if (select == 3)
        {
            GameRunner.setLastTurnAction(3);
            input.nextLine();
            System.out.println("Left: < | Right > | Up: ^ | Down: v");
            String moveSelect = input.nextLine();
            party.moveParty(moveSelect);
            GameWorld.printMap(party.getX(), party.getY());
        }
        else
        {
            System.out.println("Invalid action");
            Turn.turn(party, input);
        }
    }
}