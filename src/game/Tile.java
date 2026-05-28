package game;

class Tile 
{

    private String[] tileGrass = 
    {
        "............",
        "............",
        "............",
        "............",
        "............"
    };

    private String[] tileGrassParty = 
    {
        "............",
        "...//////...",
        "...//////...",
        "...//////...",
        "............"
    };

    private String[] tileWater = 
    {
        "~~~~~~~~~~~~",
        "~~~~~~~~~~~~",
        "~~~~~~~~~~~~",
        "~~~~~~~~~~~~",
        "~~~~~~~~~~~~"
    };

    private String[] tileWaterParty =
    {
        "~~~~~~~~~~~~",
        "~~~//////~~~",
        "~~~//////~~~",
        "~~~//////~~~",
        "~~~~~~~~~~~~"
    };

    private String[] tileForest =
    {
        " # # # # # #",
        " | | | | | |",
        "            ",
        " # # # # # #",
        " | | | | | |"

    };

    private String[] tileForestParty =
    {
        " # # # # # #",
        " | //////| |",
        "   //////   ",
        " # //////# #",
        " | | | | | |"
    };

    private String[] tile;
    private int tileType;

    public Tile() 
    {
        int tileType = (int) (Math.random() * 3);

        if (tileType == 0) 
        {
            tile = tileGrass;
            this.tileType = tileType;
        } 
        else if (tileType == 2) 
        {
            tile = tileWater;
            this.tileType = tileType;

        }
        else
        {
            tile = tileForest;
            this.tileType = tileType;

        }
    }

    public Tile(int x)
    {
        if (x == 0) 
        {
            tile = tileGrassParty;
            tileType = x;
        } 
        else if (x == 2) 
        {
            tile = tileWaterParty;
            tileType = x;
        }
        else
        {
            tile = tileForestParty;
            tileType = x;
        }
    }

    public int getTileType()
    {
        return tileType;
    }

    public String[] getTile()
    {
        return tile;
    }
}