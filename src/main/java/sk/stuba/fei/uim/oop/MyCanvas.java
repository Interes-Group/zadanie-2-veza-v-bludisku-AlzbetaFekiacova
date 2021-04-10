package sk.stuba.fei.uim.oop;

import java.awt.*;

public class MyCanvas extends Canvas {
    private Maze maze;
    public MyCanvas (Maze maze){

        this.maze = maze;
    }
    public void paint(Graphics g){
        maze.drawMaze(g);

    }

}
