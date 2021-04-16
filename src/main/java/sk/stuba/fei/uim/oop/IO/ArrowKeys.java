package sk.stuba.fei.uim.oop.IO;

import sk.stuba.fei.uim.oop.Exceptions.GameEnded;
import sk.stuba.fei.uim.oop.Game.Game;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
            game.oneMove(code);

        } catch (GameEnded gameEnded) {

        }
        canvas.repaint();
    }
}
