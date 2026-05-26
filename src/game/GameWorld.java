package game;

public class GameWorld {
    
    private Tile[][] map = new Tile[5][5];

    public GameWorld()
    {
        for (int i = 0; i < map.length; i++)
        {
            for (int j = 0; j < map[0].length; j++)
            {
                map[i][j] = new Tile();
            }
        }
    }

    public void printMap()
    {
        for (int row = 0; row < map.length; row++)
        {
            for (int col = 0; col < map[0].length; col++)
            {
                System.out.println(map[row][col]);
            }
        }
    }
    
    private class Tile {
        
        private static final String[] tileGrass = {"\"\"\"\"\"", "\"\"\"\"\"", "\"\"\"\"\"", "\"\"\"\"\"", "\"\"\"\"\""};
        private static final String[] tileWater = {"~~~~~", "~~~~~", "~~~~~", "~~~~~", "~~~~~"};
        private final String[] tile;
    
        public Tile()
        {
            int tileType = (int)(Math.random() * 2);
    
            if (tileType == 0)
            {
                tile = tileGrass;
            }
            else if (tileType == 1)
            {
                tile = tileWater;
            }
            else
            {
                tile = tileGrass;
            }

        }
        public String toString()
        {
            String print = "";
            for (String thing : tile)
            {
                print += thing + "\n";
            }
            return print;
        }
    }
}


