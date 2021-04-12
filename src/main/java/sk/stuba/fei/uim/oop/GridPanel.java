package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GridPanel extends JPanel implements KeyListener {
    private int sizeX;
    private int sizeY;
    private Player player;
    private Maze maze;
    private MyCanvas canvas;

    public GridPanel(Player player, Maze maze){
        sizeX = 300;
        sizeY = 300;
        this.setBackground(Color.white);
        this.setBounds(0,0,sizeX, sizeY);
        this.setLayout(null);

        this.player = player;
        this.maze = maze;
        this.canvas = new MyCanvas(maze, player);
        canvas.setBounds(0,10,300,300);
        this.add(canvas);

    }

    public MyCanvas getCanvas() {
        return canvas;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_UP){
            player.isValidMoveUP(maze);
            System.out.println("Stlacene hore");
            System.out.println("pozicia je x : " + player.getPosX() + " pozicia y je : " + player.getPosY());
            //canvas.repaint();
        }
        if(code == KeyEvent.VK_RIGHT){
            player.isValidMoveRight(maze);
            System.out.println("Stlacene doprava");
            System.out.println("pozicia je x : " + player.getPosX() + " pozicia y je : " + player.getPosY());
            //canvas.repaint();
        }
        if (code == KeyEvent.VK_DOWN){
            player.isValidMoveDown(maze);
            System.out.println("Slacene dole");
            System.out.println("pozicia je x : " + player.getPosX() + " pozicia y je : " + player.getPosY());
            //canvas.repaint();
        }
        if(code == KeyEvent.VK_LEFT){
            player.isValidMoveLeft(maze);
            System.out.println("Stlacene dolava");
            System.out.println("pozicia je x : " + player.getPosX() + " pozicia y je : " + player.getPosY());
            //canvas.repaint();
        }
        canvas.repaint();
        //this.repaint();
        System.out.println("repainted");

    }



    @Override
    public void keyReleased(KeyEvent e) {

    }
}
