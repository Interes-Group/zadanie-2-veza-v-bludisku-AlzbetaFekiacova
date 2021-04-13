package sk.stuba.fei.uim.oop;

import java.awt.*;
import java.util.ArrayList;


import static java.lang.Math.abs;

public class Player {
    private int posX;
    private int posY;

    private int posXonCanvas;
    private int posYonCanvas;

    public Player() {
        posX = 0;
        posY = 0;
        posXonCanvas = 27;
        posYonCanvas = 27;
    }


    public boolean isPositionInRadius(int x, int y) {
        int a = abs(posXonCanvas - x);
        int b = abs(posYonCanvas - y);
        return a <= 8 && b <= 8;
    }

    public int getPosXonCanvas() {
        return posXonCanvas;
    }

    public int getPosYonCanvas() {
        return posYonCanvas;
    }

    public void drawPlayer(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect((posX + 1) * 20 + 5, (posY + 1) * 20 + 5, 5, 5);

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
            posYonCanvas -= 20;
        }
    }

    public void moveDown(Maze maze) {
        if (isValidMoveDown(posY, maze)) {
            posY += 1;
            posYonCanvas += 20;
        }
    }

    public void moveRight(Maze maze) {
        if (isValidMoveRight(posX, maze)) {
            posX += 1;
            posXonCanvas += 20;
        }
    }

    public void moveLeft(Maze maze) {
        if (isValidMoveLeft(posX, maze)) {
            posX -= 1;
            posXonCanvas -= 20;
        }
    }

    public boolean isValidMoveUP(int y, Maze maze) {
        if ((y - 1) >= 0) {
            if (!maze.getGrid().get(posX).get(y).isTopWall()) {
                return true;

            }
        }
        return false;

    }

    public boolean isValidMoveRight(int x, Maze maze) {
        if ((x + 1) < maze.getCols()) {
            if (!maze.getGrid().get(x).get(posY).isRightWall()) {
                return true;

            }

        }
        return false;

    }

    public boolean isValidMoveDown(int y, Maze maze) {
        if ((y + 1) < maze.getRows()) {
            if (!maze.getGrid().get(posX).get(y).isBottomWall()) {
                return true;

            }

        }
        return false;
    }

    public boolean isValidMoveLeft(int x, Maze maze) {
        if ((x - 1) >= 0) {
            if (!maze.getGrid().get(x).get(posY).isLeftWall()) {
                return true;

            }

        }
        return false;

    }

    private Tile getAvailableUp(Maze maze) {
        Tile t = null;
        int u = availableGoUp(maze);
        if (u != posY) {
            t = maze.getGrid().get(posX).get(u);
        }
        return t;
    }

    private Tile getAvailableRight(Maze maze) {
        Tile t = null;
        int r = availableGoRight(maze);
        if (r != posX) {
            t = maze.getGrid().get(r).get(posY);
        }
        return t;
    }

    private Tile getAvailableDown(Maze maze) {
        Tile t = null;
        int d = availableGoDown(maze);
        if (d != posY) {
            t = maze.getGrid().get(posX).get(d);
        }
        return t;
    }

    private Tile getAvailableLeft(Maze maze) {
        Tile t = null;
        int l = availableGoLeft(maze);
        if (l != posX) {
            t = maze.getGrid().get(l).get(posY);
        }
        return t;
    }


    public ArrayList<Tile> availableMoves(Maze maze) {
        ArrayList<Tile> availableTiles = new ArrayList<>();
        Tile t = getAvailableUp(maze);
        if (t != null) {
            t.setAvailable(true);
            availableTiles.add(t);
        }
        t = getAvailableRight(maze);
        if (t != null) {
            t.setAvailable(true);
            availableTiles.add(t);
        }
        t = getAvailableDown(maze);
        if (t != null) {
            t.setAvailable(true);
            availableTiles.add(t);
        }
        t = getAvailableLeft(maze);
        if (t != null) {
            t.setAvailable(true);
            availableTiles.add(t);
        }


        /*
        if (maze.getGrid().get(posX).get(availableGoUp(maze)) != maze.getGrid().get(posX).get(posY)){
            availableTiles.add(maze.getGrid().get(getPosX()).get(availableGoUp(maze)));
            maze.getGrid().get(posX).get(availableGoUp(maze)).setAvailable(true);
        }
        if( maze.getGrid().get(availableGoRight(maze)).get(posY) != maze.getGrid().get(posX).get(posY)){
            availableTiles.add(maze.getGrid().get(availableGoRight(maze)).get(posY));
            maze.getGrid().get(availableGoRight(maze)).get(posY).setAvailable(true);
        }
        if( maze.getGrid().get(posX).get(availableGoDown(maze)) != maze.getGrid().get(posX).get(posY)) {
            availableTiles.add(maze.getGrid().get(posX).get(availableGoDown(maze)));
            maze.getGrid().get(posX).get(availableGoDown(maze)).setAvailable(true);
        }
        if( maze.getGrid().get(availableGoLeft(maze)).get(posY) != maze.getGrid().get(posX).get(posY)){
            availableTiles.add(maze.getGrid().get(availableGoLeft(maze)).get(posY));
            maze.getGrid().get(availableGoLeft(maze)).get(posY).setAvailable(true);
        }*/
        return availableTiles;
    }


    private int availableGoUp(Maze maze) {
        int posTileY = posY;
        while (true) {
            if (isValidMoveUP(posTileY, maze)) {
                posTileY -= 1;
            } else break;
        }
        return posTileY;
    }

    private int availableGoRight(Maze maze) {
        int posTileX = posX;
        while (true) {
            if (isValidMoveRight(posTileX, maze)) {
                posTileX += 1;
            } else break;
        }
        return posTileX;
    }

    private int availableGoDown(Maze maze) {
        int posTileY = posY;
        while (true) {
            if (isValidMoveDown(posTileY, maze)) {
                posTileY += 1;
            } else break;
        }
        return posTileY;
    }

    private int availableGoLeft(Maze maze) {
        int posTileX = posX;
        while (true) {
            if (isValidMoveLeft(posTileX, maze)) {
                posTileX -= 1;
            } else break;
        }
        return posTileX;
    }


}

