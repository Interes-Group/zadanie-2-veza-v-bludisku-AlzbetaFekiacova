package sk.stuba.fei.uim.oop;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.abs;

public class Mouse implements MouseListener, MouseMotionListener {

    private Game game;
    private MyCanvas canvas;
    private Map<Tile, Integer> availableTiles;
    private boolean clicked = false;
    private boolean onPosition = false;
    private Tile tile;

    public Mouse(Game game, MyCanvas canvas){
        super();
        this.game = game;
        this.canvas = canvas;
        this.availableTiles = new HashMap<>();
        this.tile = null;
    }

    private void mouseClick(MouseEvent e){
        System.out.println("Pos x mysky : " + e.getX() + " pozicia y mysky " + e.getY());
        System.out.println(game.getPlayer().getPosXonCanvas() + " " + game.getPlayer().getPosYonCanvas() );
        if (game.getPlayer().isPositionInRadius(e.getX(), e.getY()) ){
            clicked = true;
            availableTiles = game.getPlayer().availableMoves(game.getMaze());
            System.out.println(availableTiles.size());
            /*
            for(Tile t: availableTiles){
                System.out.println("Pos x = " + t.getX());
                System.out.println("Pos y = " + t.getY());
            }*/
            //canvas.repaint();
            System.out.println("Yes");
        }
        else if(clicked && onPosition){
            int direction = availableTiles.get(tile);
            int numbOfMoves = abs(game.getPlayer().getPosX() - tile.getX()) + abs(game.getPlayer().getPosY() - tile.getY());

            for (int i = 0; i < numbOfMoves; i++) {
                try {
                    game.playerMove(direction);

                } catch (GameEnded gameEnded) {

                }
            }
            game.getMaze().getGrid().get(tile.getX()).get(tile.getY()).setAvailable(false);
            availableTiles.clear();
            canvas.repaint();
            clicked = false;
            onPosition = false;
        }
        else {
            System.out.println("No");
        }


    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Click");
       mouseClick(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Press");
        mouseClick(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("realesed");

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //System.out.println("mouse mooved");
        if(availableTiles.size()!=0) {
            System.out.println("uz si klikol");
            for (Tile t : availableTiles.keySet()) {
                int posXSelected = -1;
                int posYSelected = -1;
                //System.out.println("Myska x = " + e.getX());
                int posX = ((t.getX()) * 20) + 28;
                //System.out.println(posX);
                //System.out.println("Myska y = " + e.getY());

                int posY = ((t.getY()) * 20) + 28;
                //System.out.println(posY);

                if (abs(e.getX() - posX) <= 5 && abs(e.getY() - posY) <= 5) {
                    //System.out.println("je");
                    game.getMaze().getGrid().get(t.getX()).get(t.getY()).setAvailable(true);
                    onPosition = true;
                    tile = t;

                } else {
                    game.getMaze().getGrid().get(t.getX()).get(t.getY()).setAvailable(false);

                }
                canvas.repaint();

            }
        }

    }
}
