package sk.stuba.fei.uim.oop.Maze;

import java.util.HashMap;
import java.util.Map;

public class Tile {
    private int x;
    private int y;
    private boolean visited;
    private boolean topWall;
    private boolean rightWall;
    private boolean leftWall;
    private boolean bottomWall;
    private boolean isEnd;
    private int size;
    private boolean isAvailable;
    private Map<Tile, String> unvisitedNeighbours;


    public Map<Tile, String> getUnvisitedNeighbours() {
        return unvisitedNeighbours;
    }

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        visited = false;
        topWall = true;
        rightWall = true;
        leftWall = true;
        bottomWall = true;
        isEnd = false;
        size = 20;
        isAvailable = false;
        unvisitedNeighbours = new HashMap<>();
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    public void breakTopWall() {
        this.topWall = false;
    }

    public void breakRightWall() {
        this.rightWall = false;

    }

    public void clearNeighbours(){
        this.unvisitedNeighbours.clear();
    }

    public void breakLeftWall() {
        this.leftWall = false;
    }

    public void breakBottomWall() {
        this.bottomWall = false;
    }

    private boolean isValidXRight(Maze maze) {
        return (x + 1) < maze.getCols();
    }

    private boolean isValidXLeft(Maze maze) {
        return x - 1 >= 0;
    }

    private boolean isValidYTop(Maze maze) {
        return (y - 1) >= 0;
    }

    private boolean isValidYBottom(Maze maze) {
        return (y + 1) < maze.getCols();
    }


    //public ArrayList<Tile> checkNeighbours(Maze maze) {
    public void fillNeighbours(Maze maze) {

        if (isValidYTop(maze)) {
            if (!maze.getGrid().get(x).get(y - 1).isVisited()) {
                unvisitedNeighbours.put(maze.getGrid().get(x).get(y - 1), "top");
            }
        }
        if (isValidXRight(maze)) {
            if (!maze.getGrid().get(x + 1).get(y).isVisited()) {
                unvisitedNeighbours.put(maze.getGrid().get(x + 1).get(y), "right");
            }
        }
        if (isValidYBottom(maze)) {
            if (!maze.getGrid().get(x).get(y + 1).isVisited()) {
                unvisitedNeighbours.put(maze.getGrid().get(x).get(y + 1), "bottom");
            }
        }
        if (isValidXLeft(maze)) {
            if (!maze.getGrid().get(x - 1).get(y).isVisited()) {
                unvisitedNeighbours.put(maze.getGrid().get(x - 1).get(y), "left");
            }
        }
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isTopWall() {
        return topWall;
    }

    public void setTopWall(boolean topWall) {
        this.topWall = topWall;
    }

    public boolean isRightWall() {
        return rightWall;
    }

    public void setRightWall(boolean rightWall) {
        this.rightWall = rightWall;
    }

    public boolean isLeftWall() {
        return leftWall;
    }

    public void setLeftWall(boolean leftWall) {
        this.leftWall = leftWall;
    }

    public boolean isBottomWall() {
        return bottomWall;
    }

    public void setBottomWall(boolean bottomWall) {
        this.bottomWall = bottomWall;
    }
}
