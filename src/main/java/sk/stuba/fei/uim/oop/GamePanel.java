package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private int sizeX;
    private int sizeY;

    private JButton reset;
    private JButton up;
    private JButton right;
    private JButton down;
    private JButton left;
    private JLabel games;
    private static int numberOfGames;
    public GamePanel(){
        this.sizeX = 300;
        this.sizeY = 300;
        numberOfGames = 0;
        this.setBackground(Color.cyan);
        //this.setLayout(new BorderLayout());
        this.setBounds(300,0,sizeX, sizeY);
        this.setLayout(null);
        reset = new JButton("RESET");
        reset.setBounds(100, 10, 100,25);
        up = new JButton("UP");
        up.setBounds(100,60,100,25);
        right = new JButton("RIGHT");
        right.setBounds(200,90,100,25);

        down= new JButton("DOWN");
        down.setBounds(100,130,100,25);
        left = new JButton("LEFT");
        left.setBounds(0,90,100,25);
        games = new JLabel("Number of games played: " + numberOfGames);
        games.setBounds(80,170,2000,25);

        this.add(reset);

        this.add(up);
        this.add(right);
        this.add(down);
        this.add(left);
        this.add(games);
    }


}
