package sk.stuba.fei.uim.oop.Exceptions;

import sk.stuba.fei.uim.oop.Game.Game;
import sk.stuba.fei.uim.oop.Maze.Maze;

import javax.swing.*;

public class GameEnded extends Exception {

    public GameEnded(Game game, Boolean reset, JLabel games) {
        game.getPlayer().setPosX(0);
        game.getPlayer().setPosY(0);
        game.getPlayer().setPosXonCanvas(28);
        game.getPlayer().setPosYonCanvas(28);
        int rows = game.getMaze().getRows();
        int cols = game.getMaze().getCols();
        game.setMaze(new Maze(rows, cols));
        if (!reset) {
            game.incrementSuccessfulGames();
            games.setText("Number of successful games played: " + game.getSuccessfulGames());
        }

    }
}
