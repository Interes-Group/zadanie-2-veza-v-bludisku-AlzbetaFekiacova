package sk.stuba.fei.uim.oop.GUI;
import sk.stuba.fei.uim.oop.Game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;


public class GamePanel extends JPanel {

    private MyCanvas canvas;
    private MyButton reset;
    private MyButton up;
    private MyButton right;
    private MyButton down;
    private MyButton left;
    private JLabel games;
    private Game game;
    private GridPanel gridPanel;

    public GamePanel(Game game, MyCanvas canvas, JLabel numberOfGames, GridPanel grid) {

        this.canvas = canvas;
        this.game = game;
        this.setBackground(Color.cyan);
        this.setBounds(300, 0, 300, 300);
        this.setLayout(null);
        this.setFocusable(false);


        reset = new MyButton("RESET", 100, 40, 80, 25, -1, game, canvas, games);
        up = new MyButton("UP", 100, 90, 80, 25, KeyEvent.VK_UP, game, canvas, games);
        right = new MyButton("RIGHT", 185, 120, 80, 25, KeyEvent.VK_RIGHT, game, canvas, games);

        down = new MyButton("DOWN", 100, 120, 80, 25, KeyEvent.VK_DOWN, game, canvas, games);


        left = new MyButton("LEFT", 15, 120, 80, 25, KeyEvent.VK_LEFT, game, canvas, games);


        games = numberOfGames;
        games.setBounds(30, 170, 270, 25);

        this.add(reset);

        this.add(up);
        this.add(right);
        this.add(down);
        this.add(left);
        this.add(games);
        gridPanel = grid;

    }
}
