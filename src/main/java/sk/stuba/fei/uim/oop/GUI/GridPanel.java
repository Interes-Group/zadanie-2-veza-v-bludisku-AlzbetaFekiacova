package sk.stuba.fei.uim.oop.GUI;

import sk.stuba.fei.uim.oop.Game.Game;
import sk.stuba.fei.uim.oop.Game.Player;
import sk.stuba.fei.uim.oop.Maze.Maze;

import javax.swing.*;
import java.awt.*;

public class GridPanel extends JPanel {
    private int sizeX;
    private int sizeY;
    private Player player;
    private Maze maze;
    private MyCanvas canvas;
    private Game game;


    public GridPanel(Game game, MyCanvas myCanvas) {

        this.game = game;
        this.player = game.getPlayer();
        this.maze = game.getMaze();
        sizeX = 300;
        sizeY = 300;
        this.setBackground(Color.white);
        this.setBounds(0, 0, sizeX, sizeY);
        this.setLayout(null);

        this.canvas = myCanvas;
        canvas.setBounds(0, 0, 300, 300);
        this.add(canvas);


    }

}