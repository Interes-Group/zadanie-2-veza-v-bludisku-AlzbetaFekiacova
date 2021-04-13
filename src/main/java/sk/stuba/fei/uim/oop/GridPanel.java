package sk.stuba.fei.uim.oop;

import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GridPanel extends JPanel implements KeyListener {
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
        canvas.setBounds(0, 10, 300, 300);
        this.add(canvas);

    }

    public MyCanvas getCanvas() {
        return canvas;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }


    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        try {
            game.playerMove(code);

        } catch (GameEnded gameEnded) {

        }
        canvas.repaint();
        System.out.println("repainted");

    }


    @Override
    public void keyReleased(KeyEvent e) {

    }
}