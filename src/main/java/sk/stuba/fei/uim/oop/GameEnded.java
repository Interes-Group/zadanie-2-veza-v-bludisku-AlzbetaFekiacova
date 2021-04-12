package sk.stuba.fei.uim.oop;

import javax.swing.*;

public class GameEnded extends Exception {

    public GameEnded(Game game, Boolean reset, JLabel games) {
        game.getPlayer().setPosX(0);
        game.getPlayer().setPosY(0);
        int rows = game.getMaze().getRows();
        int cols = game.getMaze().getCols();
        game.setMaze(new Maze(rows, cols));
        if (!reset) {
            game.incrementSuccessfulGames();
            games.setText("Number of successful games played: " + game.getSuccessfulGames());
        }

    }
}
