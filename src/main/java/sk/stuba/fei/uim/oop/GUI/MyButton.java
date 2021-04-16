package sk.stuba.fei.uim.oop.GUI;

import sk.stuba.fei.uim.oop.Exceptions.GameEnded;
import sk.stuba.fei.uim.oop.Game.Game;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyButton extends JButton implements ActionListener {

    private int action;
    private Game game;
    private MyCanvas canvas;
    private JLabel games;

    public MyButton(String name, int posX, int posY, int width, int height,  int action, Game game, MyCanvas canvas, JLabel games){

        super(name);
        setBounds(posX, posY, width, height);
        this.action = action;
        this.game = game;
        this.canvas = canvas;
        this.games = games;
        addActionListener(this);
        setFocusable(false);
        setBorderPainted(true);
        setBackground(Color.WHITE);



    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (action != -1) {
                game.oneMove(action);
            } else {
                throw new GameEnded(game, true, games);
            }
        } catch (GameEnded gameEnded) {
        }

        canvas.repaint();
    }
}
