package sk.stuba.fei.uim.oop;

import java.awt.*;

public class Player {
    private int posX;
    private int posY;

    public Player() {
        posX = 0;
        posY = 0;
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
        posY = (posY - 1) * 20;
    }

    public void moveDown() {
        posY = (posY + 1) * 20;
    }

    public void moveRight() {
        posX = (posX + 1) * 20;
    }

    public void moveLeft() {
        posX = (posX - 1) * 20;
    }

    public void isValidMoveUP(Maze maze) {
        if ((posY - 1) >= 0) {
            if (!maze.getGrid().get(posY).get(posX).isTopWall()) {
                moveUp();

            }
        }


    }

    public void isValidMoveRight(Maze maze){
        if((posX + 1) < maze.getCols()){
            if(!maze.getGrid().get(posY).get(posX).isRightWall()){
                moveRight();

            }

        }

    }
    public void isValidMoveDown(Maze maze){
        if((posY + 1) < maze.getRows()){
            if(!maze.getGrid().get(posY).get(posX).isRightWall()){
                moveDown();

            }

        }

    }
    public void isValidMoveLeft(Maze maze){
        if((posX - 1) >= 0){
            if(!maze.getGrid().get(posY).get(posX).isRightWall()){
                moveLeft();

            }

        }

    }

}

