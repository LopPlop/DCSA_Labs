package Models;
import Abstractions.PictureObj;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


// Описание в классе Chell
// ты, даун?
public class Freeman extends PictureObj {
    Image image = new ImageIcon("src/Bin/Pictures/freeman.png").getImage();
    public Freeman(){
        super();
    }

    public Freeman(int x, int y, int height, int width) {
        super(x,y,height,width);
    }

    @Override
    public void Paint(Graphics g) {
        Graphics2D gr = (Graphics2D)g;
        gr.drawImage(image, (int)center.x, (int)center.y, height, width, null);
    }

    public Freeman(int x, int y){
        super(x,y);
    }

    @Override
    public ArrayList<PictureObj> ReadObjTXT(String path) {
        ArrayList<PictureObj> list = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = br.readLine();
            while(!line.isEmpty()){
                String[] opt = line.split(" ");
                list.add(new Freeman(Integer.parseInt(opt[0]),Integer.parseInt(opt[1]),Integer.parseInt(opt[2]),Integer.parseInt(opt[3])));
                line = br.readLine();
            }
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
}
