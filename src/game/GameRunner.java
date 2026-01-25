package game;
import java.util.Scanner;
import game.characters.*;
import game.enemies.*;

public class GameRunner
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("New Game? y/n ");

        if (input.nextLine().equals("y"))
        {
            System.out.println("Party name: ");
            String partName = input.nextLine();
            System.out.println("Party size: ");
            int partSize = input.nextInt();
            input.nextLine();
            Party party = new Party(partName, partSize);

            System.out.println();

            for (int i = 0; i < party.getSize(); i++)
            {
                PlayerCharacter character;
                System.out.println("Character name: ");
                String inName = input.nextLine();
                while (true)
                {
                    System.out.println("Character class: ");
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

            System.out.println();

            // TODO: insert lore and worldbuilding here

            System.out.println();
            System.out.println("Select: \n" + party.actionList());
            int select = input.nextInt();
            if (select == 1)
            {
                System.out.println("\nSelect character:");
                party.partyList();
                System.out.println();
                select = input.nextInt();
                System.out.println(party.getCharacter(select));
                System.out.println("\nActions:\n" + party.getCharacter(select).playerActionList());
                select = input.nextInt();
                if (select == 1)
                {
                    // Move action
                }
                else if (select == 2)
                {
                    // Attack action
                }
                else if (select == 3)
                {
                    // Defend action
                }
                else if (select == 4)
                {
                    System.out.println();
                }
                else if (select == 5)
                {

                }
                else if (select == 6)
                {

                }
                else
                {
                    System.out.println("Invalid action");
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
