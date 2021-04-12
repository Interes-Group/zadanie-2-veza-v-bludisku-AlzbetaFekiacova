package sk.stuba.fei.uim.oop;

import java.awt.*;
import java.awt.event.KeyEvent;

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
        posY -= 1;
    }

    public void moveDown() {
        posY += 1;
    }

    public void moveRight() {
        posX += 1;
    }

    public void moveLeft() {
        posX -= 1;
    }

    public void isValidMoveUP(Maze maze) {
        if ((posY - 1) >= 0) {
            Tile t = maze.getGrid().get(posX).get(posY);
            System.out.println("Stena hore: " + t.isTopWall());
            System.out.println("Stena vpravo: " + t.isRightWall());
            System.out.println("Stena dole: " + t.isBottomWall());
            System.out.println("Stena vlavo: " + t.isLeftWall());
            if (!maze.getGrid().get(posX).get(posY).isTopWall()) {
                moveUp();

            }
        }


    }

    public void isValidMoveRight(Maze maze) {
        if ((posX + 1) < maze.getCols()) {
            Tile t = maze.getGrid().get(posX).get(posY);
            System.out.println("Stena hore: " + t.isTopWall());
            System.out.println("Stena vpravo: " + t.isRightWall());
            System.out.println("Stena dole: " + t.isBottomWall());
            System.out.println("Stena vlavo: " + t.isLeftWall());
            if (!maze.getGrid().get(posX).get(posY).isRightWall()) {
                moveRight();

            }

        }

    }

    public void isValidMoveDown(Maze maze) {
        if ((posY + 1) < maze.getRows()) {
            Tile t = maze.getGrid().get(posX).get(posY);
            System.out.println("Stena hore: " + t.isTopWall());
            System.out.println("Stena vpravo: " + t.isRightWall());
            System.out.println("Stena dole: " + t.isBottomWall());
            System.out.println("Stena vlavo: " + t.isLeftWall());
            if (!maze.getGrid().get(posX).get(posY).isBottomWall()) {
                moveDown();

            }

        }

    }


}

