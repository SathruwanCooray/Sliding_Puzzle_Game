/** STUDENT ID: 20220659,
 *  STUDENT NAME: K.S.H.Cooray
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadingFile {
    /**
     * Method to create a character 2d array grid from a text file
     * This method returns a Map layout object
     */
    public static MapLayout createGridFromTextFile(String filename) throws FileNotFoundException {
        ArrayList<String> textFileLines = new ArrayList<>(); // Store lines of the text file
        char[][] mapArray; // 2D array to hold the grid
        int rowNumber = 0; // Number of rows in the grid
        int columnNumber = 0; // Number of columns in the grid
        int startNodeRow = 0; // Row index of the start node 'S'
        int startNodeColumn = 0; // Column index of the start node 'S'
        int finishNodeRow = 0; // Row index of the finish node 'F'
        int finishNodeColumn = 0; // Column index of the finish node 'F'
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String textLine;
            // Read each line of the text file
            while ((textLine = reader.readLine()) != null) {
                textFileLines.add(textLine); // Store the line
                rowNumber++; // Increment row count
                if (textLine.length() > columnNumber) {
                    columnNumber = textLine.length(); // Update column count if a longer line is found
                }
            }
            // Initialize the mapArray based on the number of rows and columns
            mapArray = new char[rowNumber][columnNumber];

            // Populate the mapArray with characters from the text file
            for (int i = 0; i < rowNumber; i++) {
                String line = textFileLines.get(i);
                for (int j = 0; j < columnNumber && j < line.length(); j++) {
                    mapArray[i][j] = line.charAt(j); // Assign each character to the mapArray
                    // Record the positions of the start and finish nodes
                    if (line.charAt(j) == 'S'){
                        startNodeRow = i;
                        startNodeColumn = j;
                    } else if (line.charAt(j) == 'F'){
                        finishNodeRow = i;
                        finishNodeColumn = j;
                    }
                }
            }

            // Return a new MapLayout object initialized with the mapArray and node positions
            return new MapLayout(startNodeRow,startNodeColumn,finishNodeRow,finishNodeColumn,mapArray);
        } catch (IOException e) {
            // Handle file reading error
            throw new RuntimeException(e);
        }
    }
}
