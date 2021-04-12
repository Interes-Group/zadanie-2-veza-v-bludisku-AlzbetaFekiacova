package sk.stuba.fei.uim.oop;

public class GameEnded extends Exception{

    public GameEnded(Game game){
        game.getPlayer().setPosX(0);
        game.getPlayer().setPosY(0);
        int rows = game.getMaze().getRows();
        int cols = game.getMaze().getCols();
        game.setMaze( new Maze(rows, cols));

        //GenerateMaze generateMaze = new GenerateMaze(maze);
        //maze.setGrid(generateMaze.generate(maze));
    }
}
