package UI;

import Controllers.Habitat;
import Models.Freeman;
import Models.Point;
import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeListener;

public class UIMovingObjs extends JComponent implements MouseListener, ActionListener {

    public static String binPath = "C:\\Users\\Bruh\\IdeaProjects\\CSA_Labs\\src\\Bin\\TXT\\binaryConfig.bin";
    public static String txtPath = "C:\\Users\\Bruh\\IdeaProjects\\CSA_Labs\\src\\Bin\\TXT\\config.txt";
    private JButton loadObjsButton, saveObjsButton;
    private JFrame frame;
    private JPanel controls;
    Habitat habitat = new Habitat(15, 1);

    public UIMovingObjs(JFrame frame){

        loadObjsButton = new JButton("Загрузить");
        saveObjsButton = new JButton("Сохранить");


        loadObjsButton.setBounds(870, 20, 120, 30);
        saveObjsButton.setBounds(870, 60, 120, 30);


        this.frame = frame;
        frame.add(loadObjsButton);
        frame.add(saveObjsButton);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                habitat.Action(frame.getGraphics());
            }
        });
        thread.start();

        loadObjsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Freeman fr = new Freeman();
                var list = fr.ReadObjTXT(txtPath);
                habitat.SetOBjs(list);
            }
        });

        saveObjsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var a = habitat.GetObjs();

                for(int i = 0; i < a.size(); i++){
                    a.get(i).WriteObjTXT(txtPath);
                    a.get(i).WriteObjTXT(binPath);
                }
            }
        });



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
