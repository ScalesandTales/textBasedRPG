package game;

public class GameWorld 
{
    private Tile[][] map = new Tile[5][5];

    public GameWorld() 
    {
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) 
            {
                map[row][col] = new Tile();
            }
        }
    }

    public void printMap()
    {
        for (int mapRow = 0; mapRow < map.length; mapRow++) 
        {
            for (int tileLine = 0; tileLine < 5; tileLine++) 
            {
                for (int mapCol = 0; mapCol < map[mapRow].length; mapCol++) 
                {
                    System.out.print(map[mapRow][mapCol].tile[tileLine]);
                }
                System.out.println();
            }
        }
    }

    private class Tile 
    {

        private static String[] tileGrass = 
        {
            "...........",
            "...........",
            "...........",
            "...........",
            "..........."
        };

        private static String[] tileWater = 
        {
            "~~~~~~~~~~~",
            "~~~~~~~~~~~",
            "~~~~~~~~~~~",
            "~~~~~~~~~~~",
            "~~~~~~~~~~~"
        };

        private static String[] tileForest =
        {
            "# # # # # #",
            "| | | | | |",
            "           ",
            "# # # # # #",
            "| | | | | |"

        };

        private final String[] tile;

        public Tile() {

            int tileType = (int) (Math.random() * 3);

            if (tileType == 0) 
            {
                tile = tileGrass;
            } 
            else if (tileType == 2) 
            {
                tile = tileWater;
            }
            else
            {
                tile = tileForest;
            }
        }
    }
}


