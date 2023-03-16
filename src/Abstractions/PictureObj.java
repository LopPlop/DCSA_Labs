package Abstractions;

import Models.Point;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class PictureObj implements Serializable {
    protected int height, width;
    protected Point center = new Point();

    public PictureObj(){
        center.x = 0; center.y = 0; this.height = 50; this.width = 120;
    }

    public PictureObj(int x, int y){
        center.x = x; center.y = y; this.height = 50; this.width = 120;
    }

    public PictureObj(int x, int y, int height, int width){
        center.x = x; center.y = y; this.height = height; this.width = width;
    }

    public abstract void Paint(Graphics g);

    public boolean IsPointDiligence(Point point){
        if(Math.abs(center.x* height) - Math.abs(point.x) < 0 || Math.abs(center.y* width) - Math.abs(point.y) < 0)
            return true;
        return false;
    }

    public void WriteObjTXT(String path){
        try{
            File file = new File(path);
            if(!file.exists())
                file.createNewFile();
            PrintWriter pw = new PrintWriter(file);
            pw.println(center.x + " " + center.x + " " + height + " " + width);
            pw.close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

    }

    public abstract ArrayList<PictureObj> ReadObjTXT(String path);
}
