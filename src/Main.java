import Models.Freeman;
import UI.UIMovingObjs;

import javax.swing.*;
import java.awt.*;

public class Main {
    // Вариант 5\6
    // 5.Картинка, загружаемая из файла
    // 6.Броуновское движение со случайным
    //   изменением значения скорости и
    //   направления

    public static void main(String[] args) {


        /*Freeman fr = new Freeman();
        var list = fr.ReadObjTXT(UIMovingObjs.txtPath);

        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i).getClass());
        }*/


        JFrame frame = new JFrame("Клиент-серверное приложение");
        frame.setSize(1024, 768);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        UIMovingObjs ui = new UIMovingObjs(frame);
        frame.add(ui);
        frame.addMouseListener(ui);
    }
}