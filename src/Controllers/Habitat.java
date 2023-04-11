package Controllers;

import Abstractions.PictureObj;
import Models.Chell;
import Models.Freeman;
import Models.Point;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;



public class Habitat {
    // Список объектов
    private ArrayList<PictureObj> list = new ArrayList<>();
    Image background = new ImageIcon("src/Bin/Pictures/foregrounpicture.jpg").getImage();

    public Habitat(int countObj, double speed){

        // Генерирует объекты в рандомных координатах
        for(int i = 0; i < countObj; i++)
            if((int) (Math.random() * 101)>50)
                list.add(new Freeman((int) (Math.random() * 500), (int) (Math.random() * 500)));
            else
                list.add(new Chell((int) (Math.random() * 500), (int) (Math.random() * 500)));

    }

    public void Action(Graphics g){
        while(true) {
            DrawBG(g);
            for(int i = 0; i < list.size(); i++)
                list.get(i).Paint(g);
            MoveObjts();
            try{
                Thread.sleep(200);
            }catch (Exception ex){

            }
        }

    }

    private void MoveObjts(){

        for(int i = 0; i < list.size(); i++)
        {
            if((int)(Math.random()*100) < 2)
                list.get(i).ChangeDirectionY(-1);


            if((int)(Math.random()*100) > 98)
                list.get(i).ChangeDirectionX(-1);

            list.get(i).Move();
        }
    }

    private void DrawBG(Graphics g){
        Graphics2D gr = (Graphics2D)g;
        gr.drawImage(background, 0, 0, 860, 768, null);
    }

    public void HitsObj(Point point){
        for(int i = 0; i < list.size(); i++)
            if(list.get(i).IsPointDiligence(point))
                list.remove(list.get(i));
    }


    public void SetOBjs(ArrayList<PictureObj> list){
        this.list = list;
    }

    public ArrayList<PictureObj> GetObjs(){
        return this.list;
    }
}
