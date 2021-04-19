package sk.stuba.fei.uim.oop.GUI;
import sk.stuba.fei.uim.oop.Game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;


public class GamePanel extends JPanel {

    public GamePanel(Game game, MyCanvas canvas, JLabel numberOfGames) {
        super();
        this.setBackground(Color.cyan);
        this.setBounds(300, 0, 300, 300);
        this.setLayout(null);
        this.setFocusable(false);


        MyButton reset = new MyButton("RESET", 100, 40, 80, 25, -1, game, canvas);
        MyButton up = new MyButton("UP", 100, 90, 80, 25, KeyEvent.VK_UP, game, canvas);
        MyButton right = new MyButton("RIGHT", 185, 120, 80, 25, KeyEvent.VK_RIGHT, game, canvas);
        MyButton down = new MyButton("DOWN", 100, 120, 80, 25, KeyEvent.VK_DOWN, game, canvas);
        MyButton left = new MyButton("LEFT", 15, 120, 80, 25, KeyEvent.VK_LEFT, game, canvas);


        numberOfGames.setBounds(30, 170, 270, 25);

        this.add(reset);
        this.add(up);
        this.add(right);
        this.add(down);
        this.add(left);
        this.add(numberOfGames);
    }
}
