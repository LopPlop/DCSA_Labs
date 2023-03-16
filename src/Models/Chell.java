package Models;

import Abstractions.PictureObj;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Chell extends PictureObj {

    // Картинка ♂️FUCKING SLAVE♂️
    Image image = new ImageIcon("src/Bin/Pictures/chell.png").getImage();


    public Chell(){
        super();
        speedDirectionMove.speedX = 1.4;
        speedDirectionMove.speedY = 1.0;
    }

    public Chell(int x, int y){
        super(x, y);
        speedDirectionMove.speedX = 1.4;
        speedDirectionMove.speedY = 1.0;
    }

    public Chell(int x, int y, int height, int width) {
        super(x, y, height, width);
        speedDirectionMove.speedX = 1.4;
        speedDirectionMove.speedY = 1.0;
    }

    // Отрисовка ♂️FUCKING SLAVE♂️
    @Override
    public void Paint(Graphics g) {
        Graphics2D gr = (Graphics2D)g;
        gr.drawImage(image, (int)center.x, (int)center.y, height, width, null);
    }

    // Чтение из TXT
    @Override
    public ArrayList<PictureObj> ReadObjTXT(String path) {
        // В любом случае мы возвращаем список
        // даже если в TXT ничего нет
        ArrayList<PictureObj> list = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = br.readLine();
            while(!line.isEmpty()){
                // Java умеет сама считвать строки,
                // отделяя их от пробелов (жестко)
                String[] opt = line.split(" ");
                list.add(new Chell(Integer.parseInt(opt[0]),Integer.parseInt(opt[1]),Integer.parseInt(opt[2]),Integer.parseInt(opt[3])));
                line = br.readLine();
            }
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
}
