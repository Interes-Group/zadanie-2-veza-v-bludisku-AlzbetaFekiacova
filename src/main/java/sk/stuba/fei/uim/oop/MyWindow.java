package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class MyWindow {
    private int sizeX = 600;
    private int sizeY = 300;

    public MyWindow(Game game) {
        JFrame window = new JFrame();
        window.setSize(sizeX, sizeY);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false); // prevent from being resized
        window.setLayout(new BorderLayout());
        window.setTitle("Maze Game");
        window.setLayout(null);

        window.setFocusable(true);
        //window.requestFocusInWindow();
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        GridPanel gridPanel = new GridPanel(game);
        window.add(gridPanel);

        window.addKeyListener(gridPanel);

    }

}
