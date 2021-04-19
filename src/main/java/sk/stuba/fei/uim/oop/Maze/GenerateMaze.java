package sk.stuba.fei.uim.oop.Maze;

import java.util.Random;
import java.util.Stack;

public class GenerateMaze {
    private Maze maze;
    private Random rand;

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



    private String getDirection(Tile current, Tile next) {
        Tile t;
        String s = "";
        for (Tile tile : current.getUnvisitedNeighbours().keySet()) {
            t = tile;
            if (t.equals(next)) {
                s = current.getUnvisitedNeighbours().get(t);
                break;
            }
        }
        return s;
    }

    private Tile getRandomTile(Tile tile) {
        int randomIndex = rand.nextInt(tile.getUnvisitedNeighbours().size());
        int i = 0;
        Tile t = new Tile(-1, -1);


        for (Tile value : tile.getUnvisitedNeighbours().keySet()) {
            if (i == randomIndex) {
                t = value;
                break;
            }
            i++;
        }

        return t;

    }

    private void breakWalls(Tile current, Tile next, String direction) {
        switch (direction) {
            case "top":
                current.breakTopWall();
                next.breakBottomWall();
                break;
            case "right":
                current.breakRightWall();
                next.breakLeftWall();
                break;
            case "bottom":
                current.breakBottomWall();
                next.breakTopWall();
                break;
            default:
                current.breakLeftWall();
                next.breakRightWall();
                break;
        }

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