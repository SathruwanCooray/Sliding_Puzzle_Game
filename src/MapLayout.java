/** STUDENT ID: 20220659,
 *  STUDENT NAME: K.S.H.Cooray
 */

public class MapLayout {
    // Instance variables to hold the grid, start node coordinates, and finish node coordinates
    private final int startNodeRow;
    private final int startNodeColumn;
    private final int finishNodeRow;
    private final int finishNodeColumn;
    private final char[][] grid;

    // Constructor to initialize MapLayout with grid and node coordinates
    public MapLayout(int startNodeRow, int startNodeColumn, int finishNodeRow, int finishNodeColumn,char[][] grid) {
        this.startNodeRow = startNodeRow; // Initialize start node row
        this.startNodeColumn = startNodeColumn; // Initialize start node column
        this.finishNodeRow = finishNodeRow; // Initialize finish node row
        this.finishNodeColumn = finishNodeColumn; // Initialize finish node column
        this.grid = grid; // Initialize grid
    }

    // Getter method for retrieving the grid
    public char[][] getGrid() {
        return grid;
    }

    // Getter method for retrieving the start node row
    public int getStartNodeRow() {
        return startNodeRow;
    }

    // Getter method for retrieving the start node column
    public int getStartNodeColumn() {
        return startNodeColumn;
    }

    // Getter method for retrieving the finish node row
    public int getFinishNodeRow() {
        return finishNodeRow;
    }

    // Getter method for retrieving the finish node column
    public int getFinishNodeColumn() {
        return finishNodeColumn;
    }
}
