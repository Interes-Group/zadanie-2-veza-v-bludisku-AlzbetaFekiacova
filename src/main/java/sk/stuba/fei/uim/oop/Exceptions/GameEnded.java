package sk.stuba.fei.uim.oop.Exceptions;

import sk.stuba.fei.uim.oop.Game.Game;
import sk.stuba.fei.uim.oop.Maze.Maze;

import javax.swing.*;

public class GameEnded extends Exception {

    public GameEnded(Game game, Boolean reset) {
        game.getPlayer().setPosX(0);
        game.getPlayer().setPosY(0);
        int rows = game.getMaze().getRows();
        int cols = game.getMaze().getCols();
        game.setMaze(new Maze(rows, cols));
        if (!reset) {
            game.incrementSuccessfulGames();
        }
        else {
            game.resetSuccessfulGames();
        }
        game.getNumberOfGamesText().setText("Number of successful games played: " + game.getSuccessfulGames());

    }
}
