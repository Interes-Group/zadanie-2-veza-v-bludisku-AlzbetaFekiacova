package sk.stuba.fei.uim.oop.IO;

import sk.stuba.fei.uim.oop.GUI.MyCanvas;
import sk.stuba.fei.uim.oop.Game.Game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ArrowKeys extends KeyAdapter {
    private Game game;
    private MyCanvas canvas;

    public ArrowKeys(Game game, MyCanvas canvas){
        super();
        this.canvas = canvas;
        this.game = game;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        game.oneRound(1, this.canvas, e.getKeyCode());
    }
}
