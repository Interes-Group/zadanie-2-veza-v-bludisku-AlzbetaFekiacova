package sk.stuba.fei.uim.oop.Game;

import sk.stuba.fei.uim.oop.Maze.Maze;
import sk.stuba.fei.uim.oop.Maze.Tile;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class Player {

    private Tile positionTile;
    private Map<Tile, Integer> availableMovements;

    public Player(Maze maze) {

        this.availableMovements = new HashMap<>();
        setPositionTile(maze.getGrid().get(0).get(0));
    }


    public Tile getPositionTile() {
        return positionTile;
    }


    public void setPositionTile(Tile tile) {
        this.positionTile = tile;
    }

    public int getPosX() {
        return positionTile.getX();
    }

    public int getPosY() {
        return positionTile.getY();
    }


    public Map<Tile, Integer> getAvailableMovements() {
        return availableMovements;
    }

    public void drawPlayer(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect((getPosX() + 1) * 20 + 5, (getPosY() + 1) * 20 + 5, 10, 10);

    }
    public void moveUp(Maze maze) {

        if (isValidMoveUP(getPosY(), maze)) {
            setPositionTile(maze.getGrid().get(getPosX()).get(getPosY() - 1));
        }
    }

    public void moveRight(Maze maze) {

        if (isValidMoveRight(getPosX(), maze)) {
            setPositionTile(maze.getGrid().get(getPosX() + 1).get(getPosY()));
        }
    }



    public void moveDown(Maze maze) {

        if (isValidMoveDown(getPosY(), maze)) {
            setPositionTile(maze.getGrid().get(getPosX()).get(getPosY() + 1));
        }
    }


    public void moveLeft(Maze maze) {

        if (isValidMoveLeft(getPosX(), maze)) {
            setPositionTile(maze.getGrid().get(getPosX() - 1).get(getPosY()));
        }
    }

    private boolean isValidMoveUP(int y, Maze maze) {
        return maze.getGrid().get(getPosX()).get(y).isValidYTop() && !maze.getGrid().get(getPosX()).get(y).isTopWall();


    }

    private boolean isValidMoveRight(int x, Maze maze) {
        return maze.getGrid().get(x).get(getPosY()).isValidXRight(maze) && !maze.getGrid().get(x).get(getPosY()).isRightWall();


    }

    private boolean isValidMoveDown(int y, Maze maze) {
        return maze.getGrid().get(getPosX()).get(y).isValidYBottom(maze) && !maze.getGrid().get(getPosX()).get(y).isBottomWall();

    }

    private boolean isValidMoveLeft(int x, Maze maze) {
        return maze.getGrid().get(x).get(getPosY()).isValidXLeft() && !maze.getGrid().get(x).get(getPosY()).isLeftWall();

    }


    private void fillAvailableGoUp(Maze maze) {

        int posTileY = getPosY();
        while (true) {
            if (isValidMoveUP(posTileY, maze)) {
                posTileY -= 1;
                availableMovements.put(maze.getGrid().get(getPosX()).get(posTileY), KeyEvent.VK_UP);
            } else
                break;

        }

    }

    private void fillAvailableGoRight(Maze maze) {


        int posTileX = getPosX();
        while (true) {

            if (isValidMoveRight(posTileX, maze)) {
                posTileX += 1;
                availableMovements.put(maze.getGrid().get(posTileX).get(getPosY()), KeyEvent.VK_RIGHT);
            } else break;

        }
    }


    private void fillAvailableGoDown(Maze maze) {


        int posTileY = getPosY();
        while (true) {

            if (isValidMoveDown(posTileY, maze)) {
                posTileY += 1;
                availableMovements.put(maze.getGrid().get(getPosX()).get(posTileY), KeyEvent.VK_DOWN);
            } else break;

        }
    }


    private void fillAvailableGoLeft(Maze maze) {


        int posTileX = getPosX();
        while (true) {

            if (isValidMoveLeft(posTileX, maze)) {
                posTileX -= 1;
                availableMovements.put(maze.getGrid().get(posTileX).get(getPosY()), KeyEvent.VK_LEFT);
            } else break;

        }
    }



    public void fillAvailableMoves(Maze maze) {
        fillAvailableGoUp(maze);
        fillAvailableGoRight(maze);
        fillAvailableGoDown(maze);
        fillAvailableGoLeft(maze);

    }


    public void clearAvailableMoves() {
        availableMovements.clear();
    }

    public void setTilesNotAvailable(){
        for (Tile t : availableMovements.keySet()){
            t.setAvailable(false);
        }
    }

}





