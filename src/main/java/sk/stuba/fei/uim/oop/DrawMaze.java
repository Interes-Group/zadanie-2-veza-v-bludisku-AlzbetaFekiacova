package sk.stuba.fei.uim.oop;

import java.awt.*;

public class DrawMaze {
    private Maze maze;
    public DrawMaze(Maze maze, Graphics g){
        this.maze = maze;
                for (int i = 0; i< maze.getRows(); i++){
            for (int j = 0; j <maze.getCols(); j++){
                Tile t = maze.getGrid().get(i).get(j);
                drawTile(t, g);
            }
        }
    }


    public void drawTile(Tile tile, Graphics g){


        int posX = tile.getX() + 1;
        if(posX > 0){
            posX = posX *20;
        }
        int posY = tile.getY()+1;
        if(posY >0){
            posY = posY*20;
        }

        if (tile.isEnd()){
            g.setColor(Color.BLUE);
            g.fillRect(posX+5, posY+5, 5, 5);
        }
        g.setColor(Color.black);
        if(tile.isBottomWall()){
            drawBottomWall(g, posX, posY);
        }
        if(tile.isTopWall()){
            drawTopWall(g, posX, posY);
        }
        if(tile.isLeftWall()){
            drawLeftWall(g, posX, posY);
        }
        if(tile.isRightWall()){
            drawRightWall(g, posX, posY);
        }
    }

    public void drawRightWall(Graphics g,int  posX, int posY){

        g.drawLine(posX+20,posY,posX+20,posY+20);
    }

    public void drawTopWall(Graphics g,int posX, int posY){
        g.drawLine(posX,posY,posX+20,posY);
    }
    public void drawBottomWall(Graphics g, int posX, int posY){
        g.drawLine(posX,posY+20,posX+20,posY+20);

    }
    public void drawLeftWall(Graphics g, int posX, int posY){
        g.drawLine(posX,posY,posX,posY+20);
    }
}
