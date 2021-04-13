package sk.stuba.fei.uim.oop;

import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


public class GamePanel extends JPanel implements ActionListener {
    private int sizeX;
    private int sizeY;
    private MyCanvas canvas;
    private JButton reset;
    private JButton up;
    private JButton right;
    private JButton down;
    private JButton left;
    private JLabel games;
    private Game game;
    private GridPanel gridPanel;
    public GamePanel(Game game, MyCanvas canvas, JLabel numberOfGames, GridPanel grid) {

        this.canvas = canvas;
        this.game = game;
        this.sizeX = 300;
        this.sizeY = 300;
        this.setBackground(Color.cyan);
        this.setBounds(300, 0, sizeX, sizeY);
        this.setLayout(null);
        this.setFocusable(false);

        reset = new JButton("RESET");
        reset.setBounds(100, 10, 100, 25);
        reset.addActionListener(this);
        reset.setFocusable(false);
        up = new JButton("UP");
        up.addActionListener(this);
        up.setFocusable(false);
        up.setBounds(100, 60, 100, 25);
        right = new JButton("RIGHT");
        right.addActionListener(this);
        right.setBounds(200, 90, 100, 25);
        right.setFocusable(false);
        down = new JButton("DOWN");
        down.addActionListener(this);
        down.setBounds(100, 130, 100, 25);
        down.setFocusable(false);

        left = new JButton("LEFT");
        left.setBounds(0, 90, 100, 25);
        left.addActionListener(this);
        left.setFocusable(false);
        games = numberOfGames;
        games.setBounds(20, 170, 2000, 25);

        this.add(reset);

        this.add(up);
        this.add(right);
        this.add(down);
        this.add(left);
        this.add(games);
        gridPanel = grid;

    }


    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == up) {
                game.playerMove(KeyEvent.VK_UP);
            } else if (e.getSource() == right) {
                game.playerMove(KeyEvent.VK_RIGHT);
            } else if (e.getSource() == down) {
                game.playerMove(KeyEvent.VK_DOWN);
            } else if (e.getSource() == left) {
                game.playerMove(KeyEvent.VK_LEFT);
            } else if (e.getSource() == reset) {
                throw new GameEnded(game, true, games);
            }
        } catch (GameEnded gameEnded) {
        }

        canvas.repaint();
    }
}
