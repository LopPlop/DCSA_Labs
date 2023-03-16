package Controllers;

import Abstractions.PictureObj;
import Models.Chell;
import Models.Freeman;

import java.awt.*;
import java.util.ArrayList;


public class Habitat {
    // Список объектов
    private ArrayList<PictureObj> list = new ArrayList<>();
    private double speedX, speedY;

    Habitat(int countObj, double speed){

        // Генерирует объекты в рандомных координатах
        for(int i = 0; i < countObj; i++)
            if((int) (Math.random() * 101)>50)
                list.add(new Freeman((int) (Math.random() * 500)*((int)Math.pow(-1, (int)(Math.random() * 2))), (int) (Math.random() * 500)*((int)Math.pow(-1, (int)(Math.random() * 2)))));
            else
                list.add(new Chell((int) (Math.random() * 500)*((int)Math.pow(-1, (int)(Math.random() * 2))), (int) (Math.random() * 500)*((int)Math.pow(-1, (int)(Math.random() * 2)))));

        speedX = speed;
        speedY = speedX *0.7;
    }

    public void Action(Graphics g){
        for(int i = 0; i < list.size(); i++)
            list.get(i).Paint(g);
        Move();
    }

    private void Move(){
        for(int i = 0; i < list.size(); i++)
            list.get(i).ChangeCoords(speedX, speedY);
    }
}
