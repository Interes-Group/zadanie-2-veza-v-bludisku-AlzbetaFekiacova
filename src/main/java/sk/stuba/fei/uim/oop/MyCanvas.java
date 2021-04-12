package sk.stuba.fei.uim.oop;

import java.awt.*;

public class MyCanvas extends Canvas {
    private Game game;

    public MyCanvas(Game game) {

        this.game = game;
    }

    public void paint(Graphics g) {
        game.getMaze().drawMaze(g);
        game.getPlayer().drawPlayer(g);

    }

}
