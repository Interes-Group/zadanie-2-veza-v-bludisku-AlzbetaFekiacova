package sk.stuba.fei.uim.oop;

import java.awt.event.KeyEvent;

public class Game {
    private Player player;
    private Maze maze;

    public Game(){
        player = new Player();
        maze = new Maze(5,5);
        //new GenerateMaze(maze);
        //Game game;
        MyWindow window = new MyWindow(this);
        while (true) {


        }
    }

    public void isValidMoveLeft(Maze maze){
        if((player.getPosX() - 1) >= 0){
            Tile t = maze.getGrid().get(player.getPosX() ).get(player.getPosY() );
            System.out.println("Stena hore: " + t.isTopWall());
            System.out.println("Stena vpravo: " + t.isRightWall());
            System.out.println("Stena dole: " + t.isBottomWall());
            System.out.println("Stena vlavo: " + t.isLeftWall());
            if(!maze.getGrid().get(player.getPosX() ).get(player.getPosY() ).isLeftWall()){
                player.moveLeft();

            }

        }

    }

    public void playerMove(int code) throws GameEnded {
        if(code == KeyEvent.VK_UP){
            player.isValidMoveUP(maze);
            System.out.println("Stlacene hore");
            System.out.println("pozicia je x : " + player.getPosX() + " pozicia y je : " + player.getPosY());
            //canvas.repaint();
        }
        if(code == KeyEvent.VK_RIGHT){
            player.isValidMoveRight(maze);
            System.out.println("Stlacene doprava");
            System.out.println("pozicia je x : " + player.getPosX()  + " pozicia y je : " + player.getPosY() );
            //canvas.repaint();
        }
        if (code == KeyEvent.VK_DOWN){
            player.isValidMoveDown(maze);
            System.out.println("Slacene dole");
            System.out.println("pozicia je x : " + player.getPosX()  + " pozicia y je : " + player.getPosY() );
            //canvas.repaint();
        }
        if(code == KeyEvent.VK_LEFT){
            isValidMoveLeft(maze);
            System.out.println("Stlacene dolava");
            System.out.println("pozicia je x : " +player.getPosX()  + " pozicia y je : " + player.getPosY() );
            //canvas.repaint();
        }

        if(maze.getGrid().get(player.getPosX() ).get(player.getPosY() ).isEnd()){
            throw new GameEnded(this);
        }

    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Maze getMaze() {
        return maze;
    }

    public void setMaze(Maze maze) {
        this.maze = maze;
    }
}
