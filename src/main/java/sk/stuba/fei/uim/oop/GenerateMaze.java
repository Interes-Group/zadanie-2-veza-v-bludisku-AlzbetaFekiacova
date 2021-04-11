package sk.stuba.fei.uim.oop;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class GenerateMaze {
    private Maze maze;
    private Random rand;
    private Stack<Tile> stack;
    private Tile current;


    private void isTopNeigh(Tile current, Tile next) {
        if (next.getY() < current.getY()) {
            next.breakBottomWall();
            current.breakTopWall();
        }
    }

    private void isRightNeigh(Tile current, Tile next) {
        if (next.getX() > current.getX()) {
            next.breakLeftWall();
            current.breakRightWall();
        }
    }

    private void isBottomNeigh(Tile current, Tile next) {
        if (next.getY() > current.getY()) {
            next.breakTopWall();
            current.breakBottomWall();
        }

    }

    private void isLeftNeigh(Tile current, Tile next) {
        if (next.getX() < current.getX()) {
            next.breakRightWall();
            current.breakLeftWall();
        }
    }




    public GenerateMaze(Maze maze) {
        stack = new Stack<>();
        rand = new Random();
        this.maze = maze;
        current = maze.getGrid().get(0).get(0);
        stack.push(current);

        while (!stack.empty()) {
            Tile next = stack.pop();
            if(!next.isVisited()){
                isBottomNeigh(current, next);
                isLeftNeigh(current, next);
                isRightNeigh(current, next);
                isTopNeigh(current, next);
                stack.push(current);

                next.setVisited(true);
                ArrayList<Tile> neighs = next.checkNeighbours(maze);
                randomlyAddNodesToStack(neighs);
            }
            current = next;
        }
        setEndTile();

    }


    private void setEndTile(){
        maze.getGrid().get(maze.getRows() - 1).get(maze.getCols()-1).setEnd(true);

    }

    private void randomlyAddNodesToStack(ArrayList<Tile> tiles) {
        int targetIndex;
        while (!tiles.isEmpty()) {
            targetIndex = rand.nextInt(tiles.size());
            stack.push(tiles.remove(targetIndex));
        }
    }



}
