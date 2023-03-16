import Models.Freeman;

public class Main {
    // Вариант 5\6

    // 5.Картинка, загружаемая из файла

    // 6.Броуновское движение со случайным
    //   изменением значения скорости и
    //   направления
    public static void main(String[] args) {
        Freeman fr = new Freeman(10,2,100,50);
        fr.WriteObjTXT("src/Bin/TXT/config.txt");
        var a = fr.ReadObjTXT("src/Bin/TXT/config.txt");

        System.out.println(Math.pow(-1, (int)(Math.random() * 2)));
    }
}