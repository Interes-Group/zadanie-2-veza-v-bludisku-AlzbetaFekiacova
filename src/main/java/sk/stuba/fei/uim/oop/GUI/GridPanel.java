package sk.stuba.fei.uim.oop.GUI;

import javax.swing.*;
import java.awt.*;

public class GridPanel extends JPanel {

    public GridPanel(MyCanvas myCanvas) {
        super();
        this.setBackground(Color.white);
        this.setBounds(0, 0, 300, 300);
        this.setLayout(null);

        myCanvas.setBounds(0, 0, 300, 300);
        this.add(myCanvas);


    }

}