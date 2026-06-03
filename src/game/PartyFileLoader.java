package game;

import game.characters.Bard;
import game.characters.Cleric;
import game.characters.Fighter;
import game.characters.Wizard;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PartyFileLoader {

    public static Party loadParty(String filePath) throws IOException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        List<String> lines = new ArrayList<>();
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }
        scanner.close();

        String partyName = lines.get(0);

        Party party = new Party(partyName, lines.size() - 1);
        
        for (int i = 1; i < lines.size(); i++) 
        {
            String[] parts = lines.get(i).split(",");
            String name = parts[0].trim();
            String characterClass = parts[1].trim().toLowerCase();
            
            if (characterClass.equals("fighter"))
            {
                party.addCharacter(new Fighter(name));
            } 
            else if (characterClass.equals("wizard")) 
            {
                party.addCharacter(new Wizard(name));
            } 
            else if (characterClass.equals("bard")) 
            {
                party.addCharacter(new Bard(name));
            } 
            else if ((characterClass.equals("cleric"))) 
            {
                party.addCharacter(new Cleric(name));
            }
        }
        return party;
    }
}
