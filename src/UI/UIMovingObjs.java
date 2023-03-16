package UI;

import Controllers.Habitat;
import Models.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UIMovingObjs extends JComponent implements MouseListener, ActionListener {

    private JFrame frame;
    Habitat habitat = new Habitat(15, 1);

    public UIMovingObjs(JFrame frame){
        this.frame = frame;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                habitat.Action(frame.getGraphics());
            }
        });
        thread.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point point = new Point();
        point.x = e.getX(); point.y = e.getY();
        habitat.HitsObj(point);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
