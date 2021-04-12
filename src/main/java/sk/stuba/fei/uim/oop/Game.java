package sk.stuba.fei.uim.oop;

public class Game {
    private Player player;
    private Maze maze;

    public Game(){
        player = new Player();
        maze = new Maze(11,11);
        MyWindow window = new MyWindow(maze, player);
        while (true) {


        }
    }


}
