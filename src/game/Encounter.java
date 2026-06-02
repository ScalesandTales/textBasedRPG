package game;
public class Encounter {

    private int tileType;
    private int enemyNum = (int)(Math.random() * 53 + 1);
    private Enemy[] enemies;


    public Encounter(Party party, Tile[][] map, int x, int y)
    {
        tileType = map[x][y].getTileType();

        for(int i =0; i < enemyNum; i++)
        {
            int enemyType = (int)(Math.random() * 3 + 1);
        }
    }
}
