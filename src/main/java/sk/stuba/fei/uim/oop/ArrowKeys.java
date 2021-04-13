package sk.stuba.fei.uim.oop;

import javax.net.ssl.KeyManager;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ArrowKeys extends KeyAdapter {
    private Game game;
    private Canvas canvas;

    public ArrowKeys(Game game, Canvas canvas){
        super();
        this.canvas = canvas;
        this.game = game;
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
}
