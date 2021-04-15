package sk.stuba.fei.uim.oop.Game;

import sk.stuba.fei.uim.oop.Exceptions.GameEnded;
import sk.stuba.fei.uim.oop.Maze.Maze;
import sk.stuba.fei.uim.oop.GUI.MyWindow;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class Game {
    private Player player;
    private Maze maze;
    private int successfulGames;
    private JLabel numberOfGames;

    public Game() {

        player = new Player();
        maze = new Maze(11, 11);
        successfulGames = 0;
        numberOfGames = new JLabel("Number of successful games played: " + getSuccessfulGames());
        MyWindow window = new MyWindow(this, numberOfGames);

    }



    public int getSuccessfulGames() {

        return successfulGames;
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

        if (maze.getGrid().get(player.getPosX()).get(player.getPosY()).isEnd()) {
            throw new GameEnded(this, false, numberOfGames);
        }
        player.clearAvailableMoves();

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
}
