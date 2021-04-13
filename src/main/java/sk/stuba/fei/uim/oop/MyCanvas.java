package sk.stuba.fei.uim.oop;

import java.awt.*;
import java.awt.event.MouseListener;

public class MyCanvas extends Canvas  {
    private Game game;


    public MyCanvas(Game game) {

        this.game = game;
        this.setFocusable(false);
        this.addMouseListener(new MouseClik(game, this));
    }

    public void paint(Graphics g) {
        game.getMaze().drawMaze(g);
        game.getPlayer().drawPlayer(g);

    }

}
