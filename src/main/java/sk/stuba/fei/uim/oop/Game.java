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
        maze = new Maze(5, 5);
        successfulGames = 0;

        numberOfGames = new JLabel("Number of successful games played: " + getSuccessfulGames());
        MyWindow window = new MyWindow(this, numberOfGames);

    }

    public void isValidMoveLeft(Maze maze) {
        if ((player.getPosX() - 1) >= 0) {
            Tile t = maze.getGrid().get(player.getPosX()).get(player.getPosY());
            System.out.println("Stena hore: " + t.isTopWall());
            System.out.println("Stena vpravo: " + t.isRightWall());
            System.out.println("Stena dole: " + t.isBottomWall());
            System.out.println("Stena vlavo: " + t.isLeftWall());
            if (!maze.getGrid().get(player.getPosX()).get(player.getPosY()).isLeftWall()) {
                player.moveLeft();

            }

        }

    }

    public int getSuccessfulGames() {

        return successfulGames;
    }

    public void incrementSuccessfulGames() {
        successfulGames += 1;
    }

    public void playerMove(int code) throws GameEnded {
        if (code == KeyEvent.VK_UP) {
            player.isValidMoveUP(maze);
            System.out.println("Stlacene hore");
            System.out.println("pozicia je x : " + player.getPosX() + " pozicia y je : " + player.getPosY());
            //canvas.repaint();
        }
        if (code == KeyEvent.VK_RIGHT) {
            player.isValidMoveRight(maze);
            System.out.println("Stlacene doprava");
            System.out.println("pozicia je x : " + player.getPosX() + " pozicia y je : " + player.getPosY());
            //canvas.repaint();
        }
        if (code == KeyEvent.VK_DOWN) {
            player.isValidMoveDown(maze);
            System.out.println("Slacene dole");
            System.out.println("pozicia je x : " + player.getPosX() + " pozicia y je : " + player.getPosY());
            //canvas.repaint();
        }
        if (code == KeyEvent.VK_LEFT) {
            isValidMoveLeft(maze);
            System.out.println("Stlacene dolava");
            System.out.println("pozicia je x : " + player.getPosX() + " pozicia y je : " + player.getPosY());
        }

        if (maze.getGrid().get(player.getPosX()).get(player.getPosY()).isEnd()) {
            throw new GameEnded(this, false, numberOfGames);
        }

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
