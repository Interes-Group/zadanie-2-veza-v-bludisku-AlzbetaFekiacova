package sk.stuba.fei.uim.oop;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseClik extends MouseAdapter {
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse : " + e.getX() + " " + e.getY());
    }
}
