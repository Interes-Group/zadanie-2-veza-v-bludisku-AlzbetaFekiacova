package sk.stuba.fei.uim.oop;

import java.util.ArrayList;

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


    public ArrayList<Tile> checkNeighbours(Maze maze) {
        ArrayList<Tile> neighbours = new ArrayList<>();
        Tile right = null;
        Tile left = null;
        Tile bottom = null;
        Tile top = null;
        if (isValidXRight(maze)) {
            right = maze.getGrid().get(x + 1).get(y);
        }
        if (isValidXLeft(maze)) {
            left = maze.getGrid().get(x - 1).get(y);
        }
        if (isValidYTop(maze)) {
            top = maze.getGrid().get(x).get(y - 1);
        }
        if (isValidYBottom(maze)) {
            bottom = maze.getGrid().get(x).get(y + 1);
        }
        if (top != null) {
            if (!top.isVisited()) {
                neighbours.add(top);
            }
        }
        if (right != null) {
            if (!right.isVisited()) {
                neighbours.add(right);
            }
        }
        if (bottom != null) {
            if (!bottom.isVisited()) {
                neighbours.add(bottom);
            }
        }
        if (left != null) {
            if (!left.isVisited()) {
                neighbours.add(left);
            }
        }
        return neighbours;
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
