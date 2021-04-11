package sk.stuba.fei.uim.oop;

import java.awt.*;

public class MyCanvas extends Canvas {
    private Maze maze;
    private Player player;
    public MyCanvas (Maze maze, Player player){

        this.maze = maze;
        this.player = player;
    }
    public void paint(Graphics g){
        maze.drawMaze(g);
        player.drawPlayer(g);

    }

}
