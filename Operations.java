/**
 * Name: Nicole Chau
 * Pennkey: nicolewl
 * Recitation: 218
 * Execution: N/A (methods called on in other classes)
 * 
 * Program Description: This class includes all operations needed for the game, 
 * including moving (merging and shifting tiles), generating a random tile, 
 * checking for win/lose conditions and printing the board.
 */

public class Operations {
    
    /**
     * Description: merges 2 tiles that are the same in the upward direction
     * Input: 2D array of type Tile
     * Output: n/a; updates arr
     */
    public static void mergeUp(Tile[][] arr) {
        for (int row = 1; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                /**
                 * if tile directly above current tile and current tile
                 * have same number then merge by adding two values
                 */
                if (arr[row][col].getNum() == arr[row - 1][col].getNum()) {
                    arr[row - 1][col].setNum(arr[row - 1][col].getNum() + 
                                             arr[row][col].getNum());
                    arr[row][col].setNum(0);
                }
            }
        }
        return;
    }
    
    /**
     * Description: merges 2 tiles that are the same in the downward direction
     * Input: 2D array of type Tile
     * Output: n/a; updates arr
     */
    public static void mergeDown(Tile[][] arr) {
        for (int row = arr.length - 1; row > 0; row--) {
            for (int col = 0; col < arr[row].length; col++) {
                /**
                 * if tile directly below current tile and current tile
                 * have same number then merge by adding two values
                 */
                if (arr[row][col].getNum() == arr[row - 1][col].getNum()) {
                    arr[row - 1][col].setNum(arr[row][col].getNum() + 
                                             arr[row - 1][col].getNum());
                    arr[row][col].setNum(0);
                }
            }
        } 
        return;
    }
    
    /**
     * Description: merges 2 tiles that are the same in the rightward direction
     * Input: 2D array of type Tile
     * Output: n/a; updates arr
     */
    public static void mergeRight(Tile[][] arr) {
        for (int row = 0; row < arr.length; row++) {
            for (int col = arr[row].length - 1; col > 0; col--) {
                /**
                 * if tile directly to right of current tile and current
                 * tile have same number then merge by adding two values
                 */
                if (arr[row][col].getNum() == arr[row][col - 1].getNum()) {
                    arr[row][col - 1].setNum(arr[row][col].getNum() + 
                                             arr[row][col - 1].getNum());
                    arr[row][col].setNum(0);
                }
            }
        }
        return;
    }
    
    /**
     * Description: merges 2 tiles that are the same in the leftward direction
     * Input: 2D array of type Tile
     * Output: n/a; updates arr
     */
    public static void mergeLeft(Tile[][] arr) {
        for (int row = 0; row < arr.length; row++) {
            for (int col = 1; col < arr[row].length; col++) {
                /**
                 * if tile directly to left of current tile and current
                 * tile have same number then merge by adding two values
                 */
                if (arr[row][col].getNum() == arr[row][col - 1].getNum()) {
                    arr[row][col - 1].setNum(arr[row][col].getNum() + 
                                             arr[row][col - 1].getNum());
                    arr[row][col].setNum(0);
                }
            }
        }
        return;
    }
    
    /**
     * Description: shifts tiles upwards if possible
     * Input: 2D array of type Tile
     * Output: n/a; updates arr
     */
    public static void shiftUp(Tile[][] arr) {
        for (int counter = arr.length - 1; counter > 0; counter--) {
            for (int row = arr.length - 1; row > 0; row--) {
                for (int col = 0; col < arr[row].length; col++) {
                    //if empty tile above current tile then move current tile up 
                    if (arr[row][col].getNum() != 0 && 
                        arr[row - 1][col].getNum() == 0) {
                        arr[row - 1][col].setNum(arr[row][col].getNum());
                        arr[row][col].setNum(0);
                    } 
                }
            }
        }
        return;
    }
    
    /**
     * Description: shifts tiles downwards if possible
     * Input: 2D array of type Tile
     * Output: n/a; updates arr
     */
    public static void shiftDown(Tile[][] arr) {
        for (int counter = 0; counter < arr.length - 1; counter++) {
            for (int row = 0; row < arr.length - 1; row++) {
                for (int col = 0; col < arr[row].length; col++) {
                    //if empty tile below current tile then move current tile down 
                    if (arr[row][col].getNum() != 0 && 
                        arr[row + 1][col].getNum() == 0) {
                        arr[row + 1][col].setNum(arr[row][col].getNum());
                        arr[row][col].setNum(0);
                    }
                }
            }
        }
        return;
    }
    
    /**
     * Description: shifts tiles right if possible
     * Input: 2D array of type Tile
     * Output: n/a; updates arr
     */
    public static void shiftRight(Tile[][] arr) {
        for (int row = 0; row < arr.length; row++) {
            for (int counter = 0; counter < arr[row].length - 1; counter++) {
                for (int col = 0; col < arr[row].length - 1; col++) {
                    //if empty tile right of current tile, move current tile right 
                    if (arr[row][col].getNum() != 0 && 
                        arr[row][col + 1].getNum() == 0) {
                        arr[row][col + 1].setNum(arr[row][col].getNum());
                        arr[row][col].setNum(0);
                    }
                }
            }
        }
        return;
    }
    
    /**
     * Description: shifts tiles left if possible
     * Input: 2D array of type Tile
     * Output: n/a; updates arr
     */
    public static void shiftLeft(Tile[][] arr) {
        for (int row = 0; row < arr.length; row++) {
            for (int counter = 0; counter < arr[row].length - 1; counter++) {
                for (int col = arr[row].length - 1; col > 0; col--) {
                    //if empty tile left of current tile, move current tile left 
                    if (arr[row][col].getNum() != 0 && 
                        arr[row][col - 1].getNum() == 0) {
                        arr[row][col - 1].setNum(arr[row][col].getNum());
                        arr[row][col].setNum(0);
                    }
                }
            }
        }
        return;
    }    
    
    /**
     * Description: generates a random tile with either 2 or 4 on the board
     * Input: 2D array of type Tile
     * Output: n/a
     */
    public static void randomTile(Tile[][] arr) {
        //if board already full don't generate new Tile
        if (isFull(arr)) {
            return;
        } else {
            //chooses random position on grid
            int row = (int) (Math.random() * 4);
            int col = (int) (Math.random() * 4);
            
            /**
             * check to make sure randomly chosen position is not already occupied
             * if already occupied, then generate a new position
             */
            while (!isEmpty(arr, row, col)) {
                row = (int) (Math.random() * 4);
                col = (int) (Math.random() * 4);
            }
            
            //new block has either 2 or 4
            if (Math.random() < 0.5) {
                arr[row][col].setNum(2);
            } else {
                arr[row][col].setNum(4);
            }
            
            //print onto grid
            arr[row][col].colorTile();
            arr[row][col].printNum();
        }
    }
    
    /**
     * Description: helper function for randomTile; checks if a grid is empty or not
     * Input: 2D array of type Tile, int for specific row and column to check
     * Output: boolean value - true is Tile is empty; false otherwise
     */
    private static boolean isEmpty(Tile[][] arr, int row, int col) {
        //if Tile num is 0 then it is considered empty
        if (arr[row][col].getNum() == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Description: prints all Tiles on game board
     * Input: 2D array of type tile
     * Output: n/a
     */
    public static void printBoard(Tile[][] arr) {
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                //if Tile has num = 0, don't print anything because it's empty
                if (arr[row][col].getNum() != 0) {
                    arr[row][col].colorTile();
                    arr[row][col].printNum();
                }
            }
        }
    }
    
    /**
     * Description: creates a copy of a 2D array of type Tile
     * Input: 2D array of type Tile
     * Output: copy of input 
     */
    public static Tile[][] copyArray(Tile[][] arr) {
        //create a Tile 2D array to store the initial values of arr
        Tile[][] storeArr = Tile.createTileArray();
        //for loop to copy values of arr to storeArr
        for (int row = 0; row < storeArr.length; row++) {
            for (int col = 0; col < storeArr[row].length; col++) {
                storeArr[row][col].setNum(arr[row][col].getNum());
            }
        }
        //return copy of input
        return storeArr;
    }
    
    /**
     * Description: checks if two 2D arrays of type Tile are the same 
     * (used to check if board has been updated)
     * Input: two 2D arrays of type Tile
     * Output: boolean value - true if board updated, false otherwise
     */
    public static boolean updated(Tile[][] arr, Tile[][] storeArr) {
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                //if values are different then that means board has been updated
                if (storeArr[row][col].getNum() != arr[row][col].getNum()) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Description: checks if player has won by creating a Tile with 2048
     * Input: 2D array of type Tile
     * Output: n/a
     */
    public static boolean win(Tile[][] arr) {
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if (arr[row][col].getNum() == 2048) {
                    return true;
                }
            }
        }
        return false; 
    }
    
    /**
     * Description: checks if there is a possible move
     * Input: 2D array of type Tile
     * Output: n/a
     */
    public static boolean canMove(Tile[][] arr) {
        //if board is not full then definitely can move
        if (!isFull(arr)) {
            return true;
        } else {
            //create 2 copies of arr so that arr is not modified within this method
            Tile[][] storeArr1 = copyArray(arr);
            Tile[][] storeArr2 = copyArray(arr);
            
            /**
             * merge up or merge right (covers case of being able to move 
             * vertically or horizontally)
             */
            mergeUp(storeArr2);
            mergeRight(storeArr2);
            
            /**
             * if after merging in either direction array is different, then 
             * there must be a possible move
             */
            return updated(storeArr1, storeArr2);
        }
    }    
        
    /**
     * Description: helper function called for randomTile and canMove; checks if
     * all grids are occupied (i.e. no Tile has num of 0)
     * Input: 2D array of type Tile
     * Output: boolean value - true if board is full; false otherwise
     */
    private static boolean isFull(Tile[][] arr) {
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if (arr[row][col].getNum() == 0) {
                    return false;
                }
            }
        }
        return true; 
    }
}
