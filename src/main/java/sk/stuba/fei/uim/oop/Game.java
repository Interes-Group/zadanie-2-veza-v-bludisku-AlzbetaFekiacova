package sk.stuba.fei.uim.oop;

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

    public void playerMove(int code) throws GameEnded {
        if (code == KeyEvent.VK_UP) {
            player.moveUp(maze);
            System.out.println("Stlacene hore");
            System.out.println("pozicia je x : " + player.getPosX() + " pozicia y je : " + player.getPosY());
            //canvas.repaint();
        }
        if (code == KeyEvent.VK_RIGHT) {
            player.moveRight(maze);
            System.out.println("Stlacene doprava");
            System.out.println("pozicia je x : " + player.getPosX() + " pozicia y je : " + player.getPosY());
            //canvas.repaint();
        }
        if (code == KeyEvent.VK_DOWN) {
            player.moveDown(maze);
            System.out.println("Slacene dole");
            System.out.println("pozicia je x : " + player.getPosX() + " pozicia y je : " + player.getPosY());
            //canvas.repaint();
        }
        if (code == KeyEvent.VK_LEFT) {
            player.moveLeft(maze);
            System.out.println("Stlacene dolava");
            System.out.println("pozicia je x : " + player.getPosX() + " pozicia y je : " + player.getPosY());
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
