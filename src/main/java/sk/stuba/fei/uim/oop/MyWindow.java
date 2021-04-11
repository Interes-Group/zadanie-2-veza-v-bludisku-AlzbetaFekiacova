package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class MyWindow {
    private int sizeX = 300;
    private int sizeY = 300;

    public MyWindow(Maze maze, Player player) {
        JFrame window = new JFrame();
        window.setSize(sizeX, sizeY);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setLayout(new BorderLayout());

        window.add(new MyCanvas(maze,player));

    }

}
