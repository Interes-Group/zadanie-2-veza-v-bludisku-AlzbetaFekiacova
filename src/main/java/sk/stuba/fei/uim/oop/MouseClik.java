package sk.stuba.fei.uim.oop;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseClik extends MouseAdapter {

    private Game game;

    public MouseClik(Game game){
        super();
        this.game = game;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Pos x mysky : " + e.getX() + " pozicia y mysky " + e.getY());
        System.out.println(game.getPlayer().getPosXonCanvas() + " " + game.getPlayer().getPosYonCanvas() );
        if (game.getPlayer().isPositionInRadius(e.getX(), e.getY()) ){
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }

    }
}
