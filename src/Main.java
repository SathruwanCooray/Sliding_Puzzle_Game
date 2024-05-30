/** STUDENT ID: 20220659,
 *  STUDENT NAME: K.S.H.Cooray
 */

import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    /**
     * Main Method
     */
    public static void main(String[] args) {
        long startTime = System.nanoTime(); // Record the start time
        try {
            // Create a grid layout by reading from a text file
            MapLayout mapLayout = ReadingFile.createGridFromTextFile("Puzzles/maze10_1.txt");

            // Get the grid from the map layout
            char[][] grid = mapLayout.getGrid();
            // Print the grid
            for (char[] row : grid) {
                for (char column : row) {
                    System.out.print(column);
                }
                System.out.println();
            }

            // Solve the maze using the provided map layout
            List<String> result = Maze.Solve(mapLayout);

            // Check if a path was found
            if (!result.isEmpty()) {
                System.out.println("\nMaze Result Shortest Path: ");
                // Print the result path
                printResultPath(result);
            } else {
                System.out.println("\nNo path found.");
            }

            long endTime = System.nanoTime(); // Record the end time
            long duration = (endTime - startTime) / 1_000_000; // Calculate duration in milliseconds
            System.out.println("\nExecution Time: " + duration + " milliseconds");

        } catch (FileNotFoundException e) {
            // Handle file not found exception
            System.err.println("File not found: " + e);
        }
    }

    /**
     * Print Result Path
     */
    private static void printResultPath(List<String> result) {
        int i = 1;
        for (String direction : result) {
            System.out.println(i + ". " + direction);
            i++;
        }
    }
}
