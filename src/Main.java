import Models.Freeman;

public class Main {
    // Вариант 5\6

    // 5.Картинка, загружаемая из файла

    // 6.Броуновское движение со случайным
    //   изменением значения скорости и
    //   направления
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Freeman fr = new Freeman();
        fr.ReadObjTXT("src/Bin/TXT/config.txt");
    }
}