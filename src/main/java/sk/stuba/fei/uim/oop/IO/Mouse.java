package sk.stuba.fei.uim.oop.IO;

import sk.stuba.fei.uim.oop.Game.Game;
import sk.stuba.fei.uim.oop.Maze.Tile;
import sk.stuba.fei.uim.oop.GUI.MyCanvas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import static java.lang.Math.abs;

public class Mouse extends MouseAdapter implements MouseMotionListener {

    private Game game;
    private MyCanvas canvas;
    private boolean clicked;
    private boolean onPosition;
    private Tile tile;

    public Mouse(Game game, MyCanvas canvas){

        super();
        this.game = game;
        this.canvas = canvas;
        this.tile = null;
        this.onPosition = false;
        this.clicked = false;
    }


    private boolean isPositionInRadius(int x, int y, MouseEvent e) {
        int a = abs(e.getX() - x);
        int b = abs(e.getY() - y);
        return a <= 5 && b <= 5;
    }


    @Override
    public void mouseClicked(MouseEvent e) {

        if(isPositionInRadius(game.getPlayer().getPositionTile().posXonCanvas(), game.getPlayer().getPositionTile().posYonCanvas(), e) && !clicked){

            clicked = true;

        } else if (clicked && onPosition) {

            if (isPositionInRadius(tile.posXonCanvas(), tile.posYonCanvas(), e)) {

                int direction = game.getPlayer().getAvailableMovements().get(tile);
                int numberOfMoves = abs(game.getPlayer().getPosX() - tile.getX()) + abs(game.getPlayer().getPosY() - tile.getY());
                game.move(numberOfMoves, canvas, direction);
                clicked = false;
                onPosition = false;
            }

        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if(clicked){
            game.getPlayer().fillAvailableMoves(game.getMaze());
            for(Tile t: game.getPlayer().getAvailableMovements().keySet()) {

                if(isPositionInRadius(t.posXonCanvas(), t.posYonCanvas(), e)){
                    game.getMaze().getGrid().get(t.getX()).get(t.getY()).setAvailable(true);
                    onPosition = true;
                    tile = t;

                }
                else {
                    game.getMaze().getGrid().get(t.getX()).get(t.getY()).setAvailable(false);

                }
                if (onPosition) {
                    canvas.repaint();
                }
            }

        }

    }

}


