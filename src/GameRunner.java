import java.util.Scanner;

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
                System.out.println("Character name: ");
                String inName = input.nextLine();
                System.out.println("Character class: ");
                String inClass = input.nextLine();
                PlayerCharacter character = new PlayerCharacter(inName, inClass);

                System.out.println();
            }

            System.out.println();

            // TODO: insert lore and worldbuilding here

            
        }
        else
        {
            System.out.println("Shutting down");
        }
    }
}
