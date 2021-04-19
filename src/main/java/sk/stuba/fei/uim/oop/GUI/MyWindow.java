package sk.stuba.fei.uim.oop.GUI;

import sk.stuba.fei.uim.oop.Game.Game;
import sk.stuba.fei.uim.oop.IO.ArrowKeys;

import javax.swing.*;
import java.awt.*;

public class MyWindow {

    public MyWindow(Game game, JLabel numberOfGames) {

        JFrame window = new JFrame();
        window.setSize(600, 300);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLayout(new BorderLayout());
        window.setTitle("A TOWER IN A MAZE GAME");
        window.setLayout(null);
        window.setFocusable(true);

        MyCanvas myCanvas = new MyCanvas(game);
        GridPanel gridPanel = new GridPanel(myCanvas);
        GamePanel gamePanel = new GamePanel(game, myCanvas, numberOfGames);
        window.add(gamePanel);
        window.add(gridPanel);
        ArrowKeys arrowKeys = new ArrowKeys(game, myCanvas);
        window.addKeyListener(arrowKeys);
        window.setVisible(true);
    }
}