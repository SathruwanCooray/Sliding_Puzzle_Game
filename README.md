# Sliding Puzzles Gmae

This project is designed to solve sliding puzzles using Dijkstra's algorithm to find the shortest path from the starting point ("S") to the finish ("F"). In this type of puzzle, the player navigates a grid where movement is influenced by frictionless ice except for walls and rocks (labelled "0").

## Overview

Sliding puzzles involve navigating from "S" to "F" while encountering walls and rocks that affect movement. The algorithm used here ensures efficient pathfinding by considering all possible movements and obstacles.

## Functionality

### Puzzle Grid

The grid consists of:
- **S**: Starting point
- **F**: Finish point
- **0**: Rocks that block movement
- **.**: Frictionless ice where movement continues until blocked by a wall or rock

### Dijkstra's Algorithm

Dijkstra's algorithm is employed to:
1. **Initialize**: Start from "S" and explore adjacent tiles.
2. **Priority Queue**: Use a priority queue to prioritize paths based on distance.
3. **Shortest Path Calculation**: Calculate the shortest path considering movement constraints (walls and rocks).

### Output

The application outputs:
- **Path Steps**: Displaying all steps from "S" to "F".
- **Benchmark Puzzles**: Sample puzzles provided in the project folder for testing and benchmarking.

## Usage

To use the Sliding Puzzles Solver:
1. **Input Puzzle**: Provide the puzzle grid where:
   - 'S' marks the starting point.
   - 'F' marks the finish point.
   - '0' marks rocks that block movement.
   - '.' represents frictionless ice.
   
2. **Run the Algorithm**: Execute the solver which employs Dijkstra's algorithm to find the shortest path.
   
3. **View Results**: Check the console or output file for the steps taken from "S" to "F".
![Results](https://imgur.com/Xb0GJpJ.png)

## Benchmark Puzzles

Included in the project folder are benchmark puzzles to test the efficiency and accuracy of the solver. These puzzles vary in complexity to ensure robust performance across different scenarios.

## Author

[Sathruwan Hansith] - [20220659]

## License

This project is licensed under MIT License. Permission is hereby granted to use, modify, and distribute the software as per the terms of the license.

## Acknowledgments

Special thanks to contributors and resources that aided in the development and understanding of pathfinding algorithms in puzzle-solving contexts.
