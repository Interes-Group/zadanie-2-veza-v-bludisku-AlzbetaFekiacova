package sk.stuba.fei.uim.oop;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MouseClik extends MouseAdapter {

    private Game game;
    private MyCanvas canvas;

    public MouseClik(Game game, MyCanvas canvas){
        super();
        this.game = game;
        this.canvas = canvas;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Pos x mysky : " + e.getX() + " pozicia y mysky " + e.getY());
        System.out.println(game.getPlayer().getPosXonCanvas() + " " + game.getPlayer().getPosYonCanvas() );
        if (game.getPlayer().isPositionInRadius(e.getX(), e.getY()) ){

            ArrayList<Tile>availableTiles = game.getPlayer().availableMoves(game.getMaze());
            System.out.println(availableTiles.size());
            for(Tile t: availableTiles){
                System.out.println("Pos x = " + t.getX());
                System.out.println("Pos y = " + t.getY());
            }
            canvas.repaint();
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }

    }
}
