package game;

public class GameWorld 
{
    private static final Tile[][] map = new Tile[5][5];
    private static Tile[][] trackMap;

    public GameWorld() 
    {
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) 
            {
                map[row][col] = new Tile();
            }
        }
    }

    public static Tile[][] getMap()
    {
        return map;
    }

    public static void printMap(int x, int y)
    {
        trackMap = new Tile[map.length][map[0].length];

        for (int row = 0; row < map.length; row++)
        {  
            for (int col = 0; col < map[row].length; col++)
            {
                trackMap[row][col] = map[row][col];
            }
        }

        trackMap[x][y] = new Tile(map[x][y].getTileType());

        for (int mapRow = 0; mapRow < trackMap.length; mapRow++) 
        {
            for (int tileLine = 0; tileLine < 5; tileLine++) 
            {
                for (int mapCol = 0; mapCol < map[mapRow].length; mapCol++) 
                {
                    System.out.print(trackMap[mapRow][mapCol].getTile()[tileLine]);
                }
                System.out.println();
            }
        }
    }
}