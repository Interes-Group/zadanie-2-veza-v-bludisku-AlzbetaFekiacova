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
        //int visited = 1;
        //int total = maze.getCols() * maze.getRows();
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



            /*
            ArrayList<Tile> neighs = current.checkNeighbours(maze);
            if (neighs.size() > 0) {
                Tile next = addRandomNeigh(neighs);
                isBottomNeigh(current, next);
                isLeftNeigh(current, next);
                isRightNeigh(current, next);
                isTopNeigh(current, next);
                stack.push(current);
                current = next;

            }
        }
*/}

        /*
        int visited = 0;
        this.maze = maze;
        rand = new Random();
        stack = new Stack<>();
        current = maze.getGrid().get(0).get(0);
        stack.push(current);
        Tile next = null;
        while (!stack.empty()) {

            next = stack.pop();
            isBottomNeigh(current, next);
            isLeftNeigh(current, next);
            isRightNeigh(current, next);
            isTopNeigh(current, next);
            ArrayList<Tile> neighs = next.checkNeighbours(maze);
            if (neighs.size() > 0) {
                next.setVisited(true);
                randomlyAddNodesToStack(neighs);
            }
            current = next;
        }


/*
*/
    }

    private Tile addRandomNeigh(ArrayList<Tile> tiles){
        int target = rand.nextInt(tiles.size());
        return tiles.get(target);
    }

    private void randomlyAddNodesToStack(ArrayList<Tile> tiles) {
        int targetIndex;
        while (!tiles.isEmpty()) {
            targetIndex = rand.nextInt(tiles.size());
            stack.push(tiles.remove(targetIndex));
        }
    }



}
