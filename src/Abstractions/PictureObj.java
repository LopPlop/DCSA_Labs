package Abstractions;

import Models.Point;

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

    public PictureObj(){
        center.x = 0; center.y = 0; this.height = 50; this.width = 120;
    }

    public PictureObj(int x, int y){
        super();
        center.x = x; center.y = y;
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

    // Запись в TXT
    public void WriteObjTXT(String path){
        try {
            Files.write(Paths.get(path), (center.x + " " + center.y + " " + height + " " + width + "\n").getBytes(), StandardOpenOption.APPEND);
        }catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


    // Чтение из TXT
    public abstract ArrayList<PictureObj> ReadObjTXT(String path);

    public void ChangeCoords(double x, double y){
        center.x+=x; center.y+=y;
    }
}
