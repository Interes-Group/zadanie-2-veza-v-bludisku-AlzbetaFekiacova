package sk.stuba.fei.uim.oop.Game;

import sk.stuba.fei.uim.oop.Maze.Maze;
import sk.stuba.fei.uim.oop.Maze.Tile;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class Player {
    private int posX;
    private int posY;

    private Map<Tile, Integer> availableMovements;

    public Player() {
        posX = 0;
        posY = 0;
        this.availableMovements = new HashMap<>();
    }


    public int posXonCanvas() {
        return (posX * 20) + 28;
    }

    public int posYonCanvas() {
        return (posY * 20) + 28;
    }


    public void drawPlayer(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect((posX + 1) * 20 + 5, (posY + 1) * 20 + 5, 10, 10);

    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void moveUp(Maze maze) {
        if (isValidMoveUP(posY, maze)) {
            posY -= 1;
        }
    }

    public void moveDown(Maze maze) {
        if (isValidMoveDown(posY, maze)) {
            posY += 1;
        }
    }

    public void moveRight(Maze maze) {
        if (isValidMoveRight(posX, maze)) {
            posX += 1;
        }
    }

    public void moveLeft(Maze maze) {
        if (isValidMoveLeft(posX, maze)) {
            posX -= 1;
        }
    }

    private boolean isValidMoveUP(int y, Maze maze) {
        if ((y - 1) >= 0) {
            return !maze.getGrid().get(posX).get(y).isTopWall();
        }
        return false;

    }

    private boolean isValidMoveRight(int x, Maze maze) {
        if ((x + 1) < maze.getCols()) {
            return !maze.getGrid().get(x).get(posY).isRightWall();

        }
        return false;

    }

    private boolean isValidMoveDown(int y, Maze maze) {
        if ((y + 1) < maze.getRows()) {
            return !maze.getGrid().get(posX).get(y).isBottomWall();

        }
        return false;
    }

    private boolean isValidMoveLeft(int x, Maze maze) {
        if ((x - 1) >= 0) {
            return !maze.getGrid().get(x).get(posY).isLeftWall();

        }
        return false;

    }


    public void fillAvailableMoves(Maze maze) {
        fillAvailableGoUp(maze);
        fillAvailableGoRight(maze);
        fillAvailableGoDown(maze);
        fillAvailableGoLeft(maze);

    }

    private void fillAvailableGoUp(Maze maze) {
        int posTileY = posY;
        while (true) {
            if (isValidMoveUP(posTileY, maze)) {
                posTileY -= 1;
                availableMovements.put(maze.getGrid().get(posX).get(posTileY), KeyEvent.VK_UP);
            } else break;
        }
    }


    public void clearAvailableMoves() {
        availableMovements.clear();
    }


    public Map<Tile, Integer> getAvailableMovements() {
        return availableMovements;
    }

    private void fillAvailableGoRight(Maze maze) {
        int posTileX = posX;
        while (true) {
            if (isValidMoveRight(posTileX, maze)) {
                posTileX += 1;
                availableMovements.put(maze.getGrid().get(posTileX).get(posY), KeyEvent.VK_RIGHT);
            } else break;
        }
    }

    private void fillAvailableGoDown(Maze maze) {
        int posTileY = posY;
        while (true) {
            if (isValidMoveDown(posTileY, maze)) {
                posTileY += 1;
                availableMovements.put(maze.getGrid().get(posX).get(posTileY), KeyEvent.VK_DOWN);
            } else break;
        }
    }

    private void fillAvailableGoLeft(Maze maze) {
        int posTileX = posX;
        while (true) {
            if (isValidMoveLeft(posTileX, maze)) {
                posTileX -= 1;
                availableMovements.put(maze.getGrid().get(posTileX).get(posY), KeyEvent.VK_LEFT);
            } else break;
        }
    }


}

