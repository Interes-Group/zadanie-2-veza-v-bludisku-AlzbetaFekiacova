package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class MyWindow {
    private int sizeX = 600;
    private int sizeY = 300;

    public MyWindow(Game game, JLabel numberOfGames) {

        MyCanvas myCanvas = new MyCanvas(game);
        JFrame window = new JFrame();
        window.setSize(sizeX, sizeY);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false); // prevent from being resized
        window.setLayout(new BorderLayout());
        window.setTitle("Maze Game");
        window.setLayout(null);

        window.setFocusable(true);

        GridPanel gridPanel = new GridPanel(game, myCanvas);
        GamePanel gamePanel = new GamePanel(game, myCanvas, numberOfGames, gridPanel);
        window.add(gamePanel);
        window.add(gridPanel);
        ArrowKeys arrowKeys = new ArrowKeys(game,myCanvas);
        window.addKeyListener(arrowKeys);


        //window.addKeyListener(gridPanel);


    }

}