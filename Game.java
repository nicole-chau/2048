/**
 * Name: Nicole Chau
 * Pennkey: nicolewl
 * Recitation: 218
 * Execution: java Game
 * 
 * Program Description: Executes 2048 game; use 'w', 'a', 's', 'd' keys 
 * for up, left, down and right. When game finishes, press 'r' to restart.
 */

public class Game {
    
    /**
     * Description: clears screen and draws 3 lines to form 4x4 grid
     * Input: n/a
     * Output: n/a
     */
    public static void drawGrid() {
        PennDraw.clear();
        
        PennDraw.line(0.25, 0, 0.25, 1);
        PennDraw.line(0.5, 0, 0.5, 1);
        PennDraw.line(0.75, 0, 0.75, 1);        
        PennDraw.line(0, 0.25, 1, 0.25);
        PennDraw.line(0, 0.5, 1, 0.5);
        PennDraw.line(0, 0.75, 1, 0.75);
    }
    
    public static void main(String[] args) {
        
        boolean firstTime = true;
        
        //this while loop helps to restart the game when it ends
        while (true) {
            //create 2D array of type Tile
            Tile[][] grid = Tile.createTileArray();
            
            //start game if first time opening or if 'r' is pressed (restart)
            if (firstTime || PennDraw.hasNextKeyTyped() && 
                PennDraw.nextKeyTyped() == 'r') {
                //draw the grid for the game
                drawGrid();

                //generate random 2 tiles with either 2 or 4 to start game
                for (int i = 0; i < 2; i++) {
                    Operations.randomTile(grid);
                }

                //counter for total number of moves
                int moves = 0;
                
                boolean gameEnd = false;  
                
                PennDraw.enableAnimation(30);   
                
                //this while loop goes through 1 round of the game
                while (!gameEnd) {
                    
                    if (PennDraw.hasNextKeyTyped()) {
                        char key = PennDraw.nextKeyTyped();
                        
                        if (key == 'w' || key == 's' || key == 'd' || key == 'a') {  
                            
                            /**
                             * create copy of grid numbers to use in 
                             * Operations.updated method later
                             */
                            Tile[][] storeArr = Operations.copyArray(grid);
                            
                            //clear screen and redraw grid
                            drawGrid();                
                            
                            if (key == 'w') {
                                //move up
                                Operations.shiftUp(grid);
                                Operations.mergeUp(grid);
                                Operations.shiftUp(grid);
                            } else if (key == 's') {
                                //move down
                                Operations.shiftDown(grid);
                                Operations.mergeDown(grid);
                                Operations.shiftDown(grid);
                            } else if (key == 'd') {
                                //move right
                                Operations.shiftRight(grid);
                                Operations.mergeRight(grid);
                                Operations.shiftRight(grid);
                            } else if (key == 'a') {
                                //move left
                                Operations.shiftLeft(grid);
                                Operations.mergeLeft(grid);
                                Operations.shiftLeft(grid);
                            }
                            
                            /**
                             * if pressing a key resulted in a valid move
                             * (i.e. board has been updated), then generate 
                             * a new random tile and increment number of moves
                             */
                            if (Operations.updated(grid, storeArr)) {
                                Operations.randomTile(grid);
                                moves++;
                            }
                            
                            //print out the updated board 
                            Operations.printBoard(grid);                            
                        }
                        
                        //winning condition
                        if (Operations.win(grid)) {
                            gameEnd = true;
                            PennDraw.setPenColor(255, 255, 255, 180);
                            PennDraw.filledSquare(0.5, 0.5, 0.5);
                            PennDraw.setPenColor();
                            PennDraw.text(0.5, 0.53, "You win!");
                            PennDraw.text(0.5, 0.46, "Moves: " + moves);
                            PennDraw.setFontSize(15);
                            PennDraw.text(0.5, 0.4, "Press 'r' to restart");
                        }
                        
                        //losing condition
                        if (!Operations.canMove(grid)) {
                            gameEnd = true;
                            PennDraw.setPenColor(255, 255, 255, 180);
                            PennDraw.filledSquare(0.5, 0.5, 0.5);
                            PennDraw.setPenColor();
                            PennDraw.text(0.5, 0.53, "Game over!");
                            PennDraw.text(0.5, 0.46, "Moves: " + moves);
                            PennDraw.setFontSize(15);
                            PennDraw.text(0.5, 0.42, "Press 'r' to restart");
                        }
                    }
                    PennDraw.advance();
                }
                firstTime = false;                
            }
        }      
    }
    
}