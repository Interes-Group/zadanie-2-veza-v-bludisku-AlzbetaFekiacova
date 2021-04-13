package sk.stuba.fei.uim.oop;

import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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

    public MyCanvas getCanvas() {
        return canvas;
    }

}