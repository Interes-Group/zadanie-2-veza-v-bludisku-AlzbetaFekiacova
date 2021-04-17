package sk.stuba.fei.uim.oop.GUI;

import sk.stuba.fei.uim.oop.Game.Game;
import sk.stuba.fei.uim.oop.IO.ArrowKeys;

import javax.swing.*;
import java.awt.*;

public class MyWindow {


    public MyWindow(Game game, JLabel numberOfGames) {
        final int SIZE_X = 600;
        final int SIZE_Y = 300;

        MyCanvas myCanvas = new MyCanvas(game);
        JFrame window = new JFrame();
        window.setSize(SIZE_X, SIZE_Y);

        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLayout(new BorderLayout());
        window.setTitle("TOWER IN A MAZE GAME");
        window.setLayout(null);
        window.setFocusable(true);

        GridPanel gridPanel = new GridPanel(game, myCanvas);
        GamePanel gamePanel = new GamePanel(game, myCanvas, numberOfGames);
        window.add(gamePanel);
        window.add(gridPanel);
        ArrowKeys arrowKeys = new ArrowKeys(game, myCanvas);
        window.addKeyListener(arrowKeys);


    }

}