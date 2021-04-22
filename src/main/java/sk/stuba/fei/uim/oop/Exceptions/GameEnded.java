package sk.stuba.fei.uim.oop.Exceptions;

import sk.stuba.fei.uim.oop.Game.Game;
import sk.stuba.fei.uim.oop.Maze.Maze;


public class GameEnded extends Exception {

    public GameEnded(Game game, Boolean reset) {

        int rows = game.getMaze().getRows();
        int cols = game.getMaze().getCols();
        game.setMaze(new Maze(rows, cols));
        game.getPlayer().setPositionTile(game.getMaze().getGrid().get(0).get(0));
        if (!reset) {
            game.incrementSuccessfulGames();
        }
        else {
            game.resetSuccessfulGames();
        }
        game.getNumberOfGamesText().setText("Number of games successfully played: " + game.getSuccessfulGames());

    }
}
