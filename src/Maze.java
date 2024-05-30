/** STUDENT ID: 20220659,
 *  STUDENT NAME: K.S.H.Cooray
 */

import java.util.*;

public class Maze {
    /**
     * Solves the maze and returns the shortest path as a list of strings.
     */
    public static List<String> Solve(MapLayout mapLayout) {
        List<String> shortestPath = new ArrayList<>(); // Initialize an array to store the shortest path
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Initializing 2d array with directions for UP,DOWN,LEFT,RIGHT for sliding
        int rowNumber = mapLayout.getGrid().length; // Retrieve number of row the map contain
        int columnNumber = mapLayout.getGrid()[0].length; // Retrieve number of columns the map contain

        // Initialize distances array with maximum values
        int[][] distances = new int[rowNumber][columnNumber];
        for (int i = 0; i < rowNumber; i++) {
            Arrays.fill(distances[i], Integer.MAX_VALUE);
        }

        // Distance from start node to itself is 0
        distances[mapLayout.getStartNodeRow()][mapLayout.getStartNodeColumn()] = 0;

        // Priority queue for managing nodes with the shortest distance
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        priorityQueue.offer(new int[]{mapLayout.getStartNodeRow(), mapLayout.getStartNodeColumn(), 0}); // Add the start node to the priority queue with 0 distance

        // Array to store the previous nodes for reconstructing the path
        int[][][] previousNodes = new int[rowNumber][columnNumber][2];
        previousNodes[mapLayout.getStartNodeRow()][mapLayout.getStartNodeColumn()] = new int[]{-1, -1}; // Making the previous node of start node (-1,-1) as start node don't have a previous node

        // Dijkstra's algorithm to find the shortest path
        while (!priorityQueue.isEmpty()) {
            int[] currentNode = priorityQueue.poll();
            int row = currentNode[0]; // Get the current node's row
            int column = currentNode[1]; // Get the current node's column

            // Break if reached finish node
            if (row == mapLayout.getFinishNodeRow() && column == mapLayout.getFinishNodeColumn()) {
                break;
            }

            // Explore neighbors by sliding
            slideToNextNode(mapLayout, row, column, distances, priorityQueue, previousNodes, directions);
        }

        // Reconstruct the shortest path
        int[] currentPosition = new int[]{mapLayout.getFinishNodeRow(), mapLayout.getFinishNodeColumn()};
        while (currentPosition[0] != -1 && currentPosition[1] != -1) {
            int[] previousNode = previousNodes[currentPosition[0]][currentPosition[1]];
            if (previousNode[0] == -1 && previousNode[1] == -1) {
                // If no path found, break
                break;
            }
            String move = getPathDirection(previousNode[0], previousNode[1], currentPosition[0], currentPosition[1]);
            shortestPath.add(0, move + " to (" + (currentPosition[0] + 1) + "," + (currentPosition[1] + 1) + ")");
            currentPosition = previousNode;
        }
        shortestPath.add(0, "Start at (" + (mapLayout.getStartNodeRow() + 1) + "," + (mapLayout.getStartNodeColumn() + 1) + ")");
        shortestPath.add("Done!");
        return shortestPath;
    }

    /**
     * Determines the direction of movement between two nodes. Used when
     */
    private static String getPathDirection(int fromRow, int fromCol, int toRow, int toCol) {
        if (toRow > fromRow) {
            return "Move down";
        }
        if (toRow < fromRow) {
            return "Move up";
        }
        if (toCol > fromCol) {
            return "Move right";
        }
        if (toCol < fromCol) {
            return "Move left";
        }
        return "Move";
    }

    /**
     * Explores the neighboring nodes from the current node by sliding until it hit a boundary or a rock.
     */
    private static void slideToNextNode(MapLayout mapLayout, int currentRow, int currentCol, int[][] distances, PriorityQueue<int[]> priorityQueue, int[][][] previousNodes, int[][] directions) {
        for (int[] direction : directions) {
            int nextRow = currentRow + direction[0];
            int nextCol = currentCol + direction[1];
            int distanceTraveled = 0;

            // Move as far as possible in the current direction
            while (isValidPosition(nextRow, nextCol, mapLayout) && mapLayout.getGrid()[nextRow][nextCol] != '0') {
                // Break the loop if the nextNode is finish node, rock or an invalid position in the grid
                if (mapLayout.getGrid()[nextRow][nextCol] == 'F'
                        || !isValidPosition(nextRow + direction[0], nextCol + direction[1], mapLayout)
                        || mapLayout.getGrid()[nextRow + direction[0]][nextCol + direction[1]] == '0') {
                    nextRow += direction[0];
                    nextCol += direction[1];
                    distanceTraveled++;
                    break;
                } else { // Continue sliding into the same direction if above condition is not met
                    nextRow += direction[0];
                    nextCol += direction[1];
                    distanceTraveled++;
                }
            }

            // Adjust to the last valid position
            nextRow -= direction[0];
            nextCol -= direction[1];
            int newDistance = distances[currentRow][currentCol] + distanceTraveled;

            // Update distance and add to priority queue if shorter path is found
            if (newDistance < distances[nextRow][nextCol]) {
                distances[nextRow][nextCol] = newDistance;
                priorityQueue.offer(new int[]{nextRow, nextCol, newDistance});
                previousNodes[nextRow][nextCol] = new int[]{currentRow, currentCol};
            }
        }
    }

    /**
     * Checks if the given position is valid within the maze grid.
     */
    private static boolean isValidPosition(int row, int column, MapLayout mapLayout) {
        return row >= 0 && row < mapLayout.getGrid().length && column >= 0 && column < mapLayout.getGrid()[0].length; // checks the boundary of the maze grid and returns a boolean value
    }
}
