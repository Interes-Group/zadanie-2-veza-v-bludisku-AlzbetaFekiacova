package sk.stuba.fei.uim.oop.Maze;

import java.util.Random;
import java.util.Stack;

public class GenerateMaze {
    private Maze maze;
    private Random rand;

    private void breakWalls(Tile current, Tile next, String dirrection) {
        if (dirrection.equals("top")) {
            current.breakTopWall();
            next.breakBottomWall();
        } else if (dirrection.equals("right")) {
            current.breakRightWall();
            next.breakLeftWall();
        } else if (dirrection.equals("bottom")) {
            current.breakBottomWall();
            next.breakTopWall();
        } else {
            current.breakLeftWall();
            next.breakRightWall();
        }

    }

    private String getDirection(Tile current, Tile next) {
        for (Tile t : current.getUnvisitedNeighbours().keySet()) {
            if (t.equals(next)) {
                return current.getUnvisitedNeighbours().get(t);
            }
        }
        return null;
    }


    public GenerateMaze(Maze maze) {
        Stack<Tile> stack;
        stack = new Stack<>();
        rand = new Random();
        this.maze = maze;
        maze.makeGrid();
        Tile current = maze.getGrid().get(0).get(0);
        current.setVisited(true);
        stack.push(current);
        while (!stack.empty()) {
            current = stack.pop();
            current.clearNeighbours();
            current.fillNeighbours(maze);
            if (current.getUnvisitedNeighbours().size() > 0) {
                stack.push(current);
                Tile next = getRandomTile(current);
                breakWalls(current, next, getDirection(current, next));
                next.setVisited(true);
                stack.push(next);

            }
        }
        setEndTile();


    }

    private Tile getRandomTile(Tile tile) {
        int randomIndex = rand.nextInt(tile.getUnvisitedNeighbours().size());
        int i = 0;
        for (Tile t : tile.getUnvisitedNeighbours().keySet()) {
            if (i == randomIndex) {
                return t;
            }
            i++;
        }
        return null;
    }


    private void setEndTile() {
        int x = rand.nextInt(maze.getRows());
        while (x == 0) {
            x = rand.nextInt(maze.getRows());
        }

        int y = rand.nextInt(maze.getCols());
        while (y == 0) {
            y = rand.nextInt(maze.getCols());
        }

        maze.getGrid().get(x).get(y).setEnd(true);

    }


}