package sk.stuba.fei.uim.oop;

import java.awt.*;


import static java.lang.Math.abs;

public class Player {
    private int posX;
    private int posY;

    private int posXonCanvas;
    private int posYonCanvas;

    public Player() {
        posX = 0;
        posY = 0;
        posXonCanvas = 23;
        posYonCanvas = 23;
    }


    public boolean isPositionInRadius(int x, int y){
        int a = abs(posXonCanvas - x);
        int b = abs(posYonCanvas - y);
        return a < 4 && b < 9;
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

    public void moveUp() {
        posY -= 1;
        posYonCanvas -= 23;
    }

    public void moveDown() {
        posY += 1;
        posYonCanvas+=23;
    }

    public void moveRight() {
        posX += 1;
        posXonCanvas+=23;
    }

    public void moveLeft() {
        posX -= 1;
        posXonCanvas-=23;
    }

    public void isValidMoveUP(Maze maze) {
        if ((posY - 1) >= 0) {
            if (!maze.getGrid().get(posX).get(posY).isTopWall()) {
                moveUp();

            }
        }


    }

    public void isValidMoveRight(Maze maze) {
        if ((posX + 1) < maze.getCols()) {
            if (!maze.getGrid().get(posX).get(posY).isRightWall()) {
                moveRight();

            }

        }

    }

    public void isValidMoveDown(Maze maze) {
        if ((posY + 1) < maze.getRows()) {
            if (!maze.getGrid().get(posX).get(posY).isBottomWall()) {
                moveDown();

            }

        }

    }

    private int availableGoUp(Maze maze){
        int posTileX = posX;
        while (!maze.getGrid().get(posX).get(posY).isTopWall()){
            posTileX -= 1;
        }
        return posTileX;
    }
    private int availableGoRight(Maze maze){
        int posTileY = posY;
        while (!maze.getGrid().get(posX).get(posY).isTopWall()){
            posTileY += 1;
        }
        return posTileY;
    }

    private int availableGoDown(Maze maze){
        int posTileX = posX;
        while (!maze.getGrid().get(posX).get(posY).isTopWall()){
            posTileX += 1;
        }
        return posTileX;
    }
    private int availableGoLeft(Maze maze){
        int posTileY = posX;
        while (!maze.getGrid().get(posX).get(posY).isTopWall()){
            posTileY -= 1;
        }
        return posTileY;
    }






}

