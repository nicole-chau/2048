/**
 * Name: Nicole Chau
 * Pennkey: nicolewl
 * Recitation: 218
 * Execution: N/A (methods called on in other classes)
 * 
 * Program Description: Constructor for Tile object and methods that involve Tile
 * (includes printing and coloring Tile and creating a 2D array of type Tile to 
 * represent the whole game board (4x4 grid))
 */

public class Tile {

    private double xPos;
    private double yPos;
    //number to be displayed in a grid
    private int num;

    /**
     * Description: constructs an object of type tile (a tile is each grid in game);
     * note that tiles with num 0 are essentially "empty" tiles
     * Input: x coordinate and y coordinate of tile on screen (double)
     */
    public Tile(double xPos, double yPos) {       
        this.xPos = xPos;
        this.yPos = yPos;
        this.num = 0;
    }

    /**
     * Description: getter for num
     * Input: n/a
     * Output: num (int)
     */
    public int getNum() {
        return this.num;
    }
    
    /**
     * Description: setter for num
     * Input: integer to assign to num variable
     * Output: n/a
     */
    public void setNum(int num) {
        this.num = num;
    }
    
    /**
     * Description: draws Tile's num
     * Input: n/a
     * Output: n/a
     */
    public void printNum() {
        PennDraw.setFontSize(22);
        PennDraw.text(xPos, yPos, "" + this.num);
    }
    
    
    /**
     * Description: colors each tile/grid based on number
     * Input: n/a
     * Output: n/a
     */
    public void colorTile() {
        if (this.num == 2) {
            PennDraw.setPenColor(238, 228, 219);
        } else if (this.num == 4) {
            PennDraw.setPenColor(237, 224, 201);
        } else if (this.num == 8) {
            PennDraw.setPenColor(241, 177, 125);
        } else if (this.num == 16) {
            PennDraw.setPenColor(243, 149, 104);
        } else if (this.num == 32) {
            PennDraw.setPenColor(244, 125, 100);
        } else if (this.num == 64) {
            PennDraw.setPenColor(244, 97, 68);
        } else if (this.num == 128 || this.num == 256) {
            PennDraw.setPenColor(236, 206, 120);
        } else if (this.num == 512 || this.num == 1024) {
            PennDraw.setPenColor(236, 194, 74);
        } else if (this.num == 2048) {
            PennDraw.setPenColor(236, 181, 59);
        }
        PennDraw.filledSquare(this.xPos, this.yPos, 0.125);
        PennDraw.setPenColor();
    }
    
     /**
     * Description: creates a 2D array (4x4) of type Tile and assigns each Tile with
     * xPos and yPos as the coordinates of center of each Tile's square 
     * (e.g. Tile at Tile[0][0] is at top left hand corner and has
     * xPos = 0.125 and yPos = 0.875)
     * 2D array basically represents the game's 4x4 grid
     * Input: n/a
     * Output: 2D array of type Tile with corresponding x and y coordinates assigned
     */
    public static Tile[][] createTileArray() {
        Tile[][] arr = new Tile[4][4];
        
        //assigns coordinates to each grid
        double xCoordinate;
        double yCoordinate = 0.875;
        for (int row = 0; row < arr.length; row++) {
            xCoordinate = 0.125;
            for (int col = 0; col < arr[row].length; col++) {
                arr[row][col] = new Tile(xCoordinate, yCoordinate);               
                //increment xCoordinate; move over one grid to the right
                xCoordinate = xCoordinate + 0.25;
            }
            yCoordinate = yCoordinate - 0.25;
        }
        return arr;
    }
    

}