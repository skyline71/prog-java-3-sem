package Practice19;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        File file = new File("src");
        File[] arrayFile = file.listFiles();
        List<File> list = Arrays.asList(arrayFile);
        for (int i = 0; i < 5; i++) {
            System.out.println(list.get(i));
        }
    }
}
