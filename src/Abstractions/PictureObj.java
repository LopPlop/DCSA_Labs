package Abstractions;

import Models.Point;
import Models.SpeedDirectionMove;

import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public abstract class PictureObj implements Serializable {
    // Высота и ширина картинок
    protected int height, width;
    // Координаты нашего объекта
    protected Point center = new Point();
    // Направление и скорость движения
    protected SpeedDirectionMove speedDirectionMove = new SpeedDirectionMove();

    public PictureObj(){
        center.x = 0; center.y = 0; this.height = 50; this.width = 120;
    }

    public PictureObj(int x, int y){
        center.x = x; center.y = y; this.height = 50; this.width = 120;
    }

    public PictureObj(int x, int y, int height, int width){
        center.x = x; center.y = y; this.height = height; this.width = width;
    }

    // Метод отрисовки
    public abstract void Paint(Graphics g);


    // Находлится ли координата внутри объекта (для удаления по наведению мышкой)
    public boolean IsPointDiligence(Point point){
        if(Math.abs(center.x* height) - Math.abs(point.x) < 0 || Math.abs(center.y* width) - Math.abs(point.y) < 0)
            return true;
        return false;
    }

    public abstract void WriteObjTXT(String path);


    // Чтение из TXT
    public abstract ArrayList<PictureObj> ReadObjTXT(String path);

    public void ChangeDirectionX(double x){
        speedDirectionMove.speedX*=x;
    }

    public void ChangeDirectionY(double y){
        speedDirectionMove.speedY*=y;
    }

    public void Move(){
        center.x+= speedDirectionMove.speedX;
        center.y+= speedDirectionMove.speedY;
    }
}
