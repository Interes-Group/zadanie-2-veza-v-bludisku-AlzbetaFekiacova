package sk.stuba.fei.uim.oop.GUI;

import sk.stuba.fei.uim.oop.Game.Game;
import sk.stuba.fei.uim.oop.IO.Mouse;

import java.awt.*;

public class MyCanvas extends Canvas {
    private Game game;


    public MyCanvas(Game game) {

        this.game = game;
        this.setFocusable(false);
        Mouse mouse = new Mouse(game, this);
        this.addMouseListener(mouse);
        this.addMouseMotionListener(mouse);
    }

    public void paint(Graphics g) {
        game.getMaze().drawMaze(g);
        game.getPlayer().drawPlayer(g);

    }

}
