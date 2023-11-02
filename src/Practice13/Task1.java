package Practice13;

import java.io.*;
import java.util.Scanner;

class ClassTask1 {
    public void writeFile(boolean append) {
        try(FileWriter writer = new FileWriter("src/Practice13/file.txt", append)) {
            Scanner s = new Scanner(System.in);
            System.out.println("Введите информацию:");
            String text = s.next();
            writer.write(text);
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void readFile() {
        try(FileReader reader = new FileReader("src/Practice13/file.txt")) {
            int c;
            while((c=reader.read())!=-1) {
                System.out.print((char)c);
            }
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void execApp() {
        Scanner s = new Scanner(System.in);
        while(true) {
            System.out.println("Выберите опцию: (Нажми цифру на клавиатуре)");
            System.out.println("1) Запись в файл");
            System.out.println("2) Чтение из файла");
            System.out.println("3) Добавить в файл");
            System.out.println("4) Закончить работу");
            int action = s.nextInt();
            switch(action) {
                case 1: { writeFile(false); break; }
                case 2: { readFile(); System.out.print("\n"); break; }
                case 3: { writeFile(true); break; }
                case 4: { return; }
            }
        }
    }
}

public class Task1 {
    public static void main(String[] args) {
        ClassTask1 task1 = new ClassTask1();
        task1.execApp();
    }
}
