package sk.stuba.fei.uim.oop.Game;

import sk.stuba.fei.uim.oop.Exceptions.GameEnded;
import sk.stuba.fei.uim.oop.GUI.MyCanvas;
import sk.stuba.fei.uim.oop.Maze.Maze;
import sk.stuba.fei.uim.oop.GUI.MyWindow;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class Game {
    private Player player;
    private Maze maze;
    private int successfulGames;
    private JLabel numberOfGamesText;

    public Game() {

        maze = new Maze(11, 11);
        player = new Player(maze);
        successfulGames = 0;
        MyWindow myWindow = new MyWindow(this);
        numberOfGamesText = myWindow.getNumberOfGamesText();

    }

    public Player getPlayer() {
        return player;
    }

    public Maze getMaze() {
        return maze;
    }

    public void setMaze(Maze maze) {
        this.maze = maze;
    }

    public JLabel getNumberOfGamesText() {
        return numberOfGamesText;
    }

    public int getSuccessfulGames() { return successfulGames; }

    public void resetSuccessfulGames() {
        this.successfulGames = 0;
    }

    public void incrementSuccessfulGames() {
        successfulGames += 1;
    }

    public void oneMove(int code) throws GameEnded {
        if (code == KeyEvent.VK_UP) {
            player.moveUp(maze);
        }
        if (code == KeyEvent.VK_RIGHT) {
            player.moveRight(maze);

        }
        if (code == KeyEvent.VK_DOWN) {
            player.moveDown(maze);

        }
        if (code == KeyEvent.VK_LEFT) {
            player.moveLeft(maze);

        }

        if (player.getPositionTile().isEnd()) {
            throw new GameEnded(this, false);
        }

        player.setTilesNotAvailable();
        player.clearAvailableMoves();

    }

    public void oneRound(int numberOfMoves, MyCanvas canvas, int direction){
        for (int i = 0; i < numberOfMoves; i++) {
            try {
                oneMove(direction);

            } catch (GameEnded gameEnded) {

            }
        }
        canvas.repaint();

    }
}
