package sk.stuba.fei.uim.oop.IO;

import sk.stuba.fei.uim.oop.Exceptions.GameEnded;
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


    private void mouseClick(MouseEvent e) {

        if(isPositionInRadius(game.getPlayer().posXonCanvas(), game.getPlayer().posYonCanvas(), e) && !clicked){

            clicked = true;

        } else if (clicked && onPosition && game.getPlayer().getAvailableMovements().size() != 0) {

            if (isPositionInRadius(tile.posXonCanvas(), tile.posYonCanvas(), e)) {


                int direction = game.getPlayer().getAvailableMovements().get(tile);
                int numbOfMoves = abs(game.getPlayer().getPosX() - tile.getX()) + abs(game.getPlayer().getPosY() - tile.getY());


                for (int i = 0; i < numbOfMoves; i++) {
                    try {
                        game.oneMove(direction);

                    } catch (GameEnded gameEnded) {

                    }
                }
                game.getMaze().getGrid().get(tile.getX()).get(tile.getY()).setAvailable(false);
                clicked = false;
                onPosition = false;
                canvas.repaint();
            }

        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        mouseClick(e);
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


