package sk.stuba.fei.uim.oop;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;


import static java.lang.Math.abs;

public class Player {
    private int posX;
    private int posY;

    private int posXonCanvas;
    private int posYonCanvas;

    private Map<Tile, Integer> availableMovements;

    public Player() {
        posX = 0;
        posY = 0;
        posXonCanvas = 28;
        posYonCanvas = 28;
        this.availableMovements = new HashMap<>();
    }


    public boolean isPositionInRadius(int x, int y) {
        int a = abs(posXonCanvas - x);
        int b = abs(posYonCanvas - y);
        return a <= 5 && b <= 5;
    }

    public int getPosXonCanvas() {
        return posXonCanvas;
    }

    public int getPosYonCanvas() {
        return posYonCanvas;
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
            return !maze.getGrid().get(posX).get(y).isTopWall();
        }
        return false;

    }

    public boolean isValidMoveRight(int x, Maze maze) {
        if ((x + 1) < maze.getCols()) {
            return !maze.getGrid().get(x).get(posY).isRightWall();

        }
        return false;

    }

    public boolean isValidMoveDown(int y, Maze maze) {
        if ((y + 1) < maze.getRows()) {
            return !maze.getGrid().get(posX).get(y).isBottomWall();

        }
        return false;
    }

    public boolean isValidMoveLeft(int x, Maze maze) {
        if ((x - 1) >= 0) {
            return !maze.getGrid().get(x).get(posY).isLeftWall();

        }
        return false;

    }

    private void getAvailableUp(Maze maze) {
        Tile t = null;
        int u = availableGoUp(maze);
        if (u != posY) {
            t = maze.getGrid().get(posX).get(u);
            availableMovements.put(t, KeyEvent.VK_UP);
        }
    }

    private void getAvailableRight(Maze maze) {
        Tile t = null;
        int r = availableGoRight(maze);
        if (r != posX) {
            t = maze.getGrid().get(r).get(posY);
            availableMovements.put(t, KeyEvent.VK_RIGHT);
        }

    }

    private void getAvailableDown(Maze maze) {
        Tile t = null;
        int d = availableGoDown(maze);
        if (d != posY) {
            t = maze.getGrid().get(posX).get(d);
            availableMovements.put(t, KeyEvent.VK_DOWN);
        }

    }

    private void getAvailableLeft(Maze maze) {
        Tile t = null;
        int l = availableGoLeft(maze);
        if (l != posX) {
            t = maze.getGrid().get(l).get(posY);
            availableMovements.put(t, KeyEvent.VK_LEFT);
        }

    }


    public void fillAvailableMoves(Maze maze) {
        fillAvailableGoUp(maze);
        fillAvailableGoRight(maze);
        fillAvailableGoDown(maze);
        fillAvailableGoLeft(maze);
        /*
        getAvailableUp(maze);
        getAvailableRight(maze);
        getAvailableLeft(maze);
        getAvailableDown(maze);*/
    }

    private void fillAvailableGoUp(Maze maze){
        int posTileY = posY;
        while (true){
            if(isValidMoveUP(posTileY, maze)){
                posTileY -= 1;
                availableMovements.put(maze.getGrid().get(posX).get(posTileY), KeyEvent.VK_UP);
            }
            else break;
        }
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


    public void clearAvailableMoves(){
        availableMovements.clear();
    }


    public Map<Tile, Integer> getAvailableMovements() {
        return availableMovements;
    }
    private void fillAvailableGoRight(Maze maze){
        int posTileX = posX;
        while (true){
            if(isValidMoveRight(posTileX, maze)){
                posTileX += 1;
                availableMovements.put(maze.getGrid().get(posTileX).get(posY), KeyEvent.VK_RIGHT);
            }
            else break;
        }
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
    private void fillAvailableGoDown(Maze maze){
        int posTileY = posY;
        while (true){
            if(isValidMoveDown(posTileY, maze)){
                posTileY += 1;
                availableMovements.put(maze.getGrid().get(posX).get(posTileY), KeyEvent.VK_DOWN);
            }
            else break;
        }
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
    private void fillAvailableGoLeft(Maze maze){
        int posTileX = posX;
        while (true){
            if(isValidMoveLeft(posTileX, maze)){
                posTileX -= 1;
                availableMovements.put(maze.getGrid().get(posTileX).get(posY), KeyEvent.VK_LEFT);
            }
            else break;
        }
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

