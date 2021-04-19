package sk.stuba.fei.uim.oop.Maze;

import java.awt.*;
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
    private int wallLength;
    private boolean isAvailable;
    private Map<Tile, String> unvisitedNeighbours;


    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        visited = false;
        topWall = true;
        rightWall = true;
        leftWall = true;
        bottomWall = true;
        isEnd = false;
        wallLength = 20;
        isAvailable = false;
        unvisitedNeighbours = new HashMap<>();
    }

    public Map<Tile, String> getUnvisitedNeighbours() {
        return unvisitedNeighbours;
    }

    public int posXonCanvas() {
        return (x * wallLength) + 28;
    }

    public int posYonCanvas() {
        return (y * wallLength) + 28;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }


    public int getX() {
        return x;
    }


    public int getY() {
        return y;
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


    public boolean isRightWall() {
        return rightWall;
    }



    public boolean isLeftWall() {
        return leftWall;
    }


    public boolean isBottomWall() {
        return bottomWall;
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

    public void breakRightWall() { this.rightWall = false; }

    public void breakLeftWall() {
        this.leftWall = false;
    }

    public void breakBottomWall() {
        this.bottomWall = false;
    }

    public boolean isValidXRight(Maze maze) {
        return (x + 1) < maze.getCols();
    }

    public boolean isValidXLeft() {
        return x - 1 >= 0;
    }

    public boolean isValidYTop() {
        return (y - 1) >= 0;
    }

    public boolean isValidYBottom(Maze maze) {
        return (y + 1) < maze.getCols();
    }


    public void fillNeighbours(Maze maze) {

        if (isValidYTop()) {
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
        if (isValidXLeft()) {
            if (!maze.getGrid().get(x - 1).get(y).isVisited()) {
                unvisitedNeighbours.put(maze.getGrid().get(x - 1).get(y), "left");
            }
        }
    }

    public void clearNeighbours(){
        this.unvisitedNeighbours.clear();
    }

    public void drawTile(Graphics g) {


        int posX = x + 1;
        if (posX > 0) {
            posX = posX * wallLength;
        }
        int posY = y + 1;
        if (posY > 0) {
            posY = posY * wallLength;
        }


        if (isAvailable()){
            g.setColor(Color.YELLOW);
            g.fillOval(posX + 5, posY + 5, 10, 10);
        }

        if (isEnd()) {
            g.setColor(Color.BLUE);
            g.fillRect(posX + 5, posY + 5, 10, 10);
        }
        g.setColor(Color.black);
        if (isBottomWall()) {
            drawBottomWall(g, posX, posY);
        }
        if (isTopWall()) {
            drawTopWall(g, posX, posY);
        }
        if (isLeftWall()) {
            drawLeftWall(g, posX, posY);
        }
        if (isRightWall()) {
            drawRightWall(g, posX, posY);
        }
    }

    public void drawRightWall(Graphics g, int posX, int posY) {

        g.drawLine(posX + wallLength, posY, posX + wallLength, posY + wallLength);
    }

    public void drawTopWall(Graphics g, int posX, int posY) {

    g.drawLine(posX, posY, posX + wallLength, posY);
    }

    public void drawBottomWall(Graphics g, int posX, int posY) {
        g.drawLine(posX, posY + wallLength, posX + wallLength, posY + wallLength);

    }

    public void drawLeftWall(Graphics g, int posX, int posY) {
        g.drawLine(posX, posY, posX, posY + wallLength);
    }
}
