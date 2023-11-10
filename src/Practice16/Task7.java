package Practice16;

import java.util.Objects;
import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) throws Exception {
        ThrowsDemo1 th = new ThrowsDemo1();
        try {
            th.getKey();
        } catch (Exception e) {
            System.out.println("Empty key");
        }
    }
}

class ThrowsDemo1 {
    public void getKey() throws Exception {
        Scanner myScanner = new Scanner(System.in);
        String key = myScanner.nextLine();
        printDetails(key);
    }
    public void printDetails(String key) throws Exception {
        try {
            String message = getDetails(key);
            System.out.println(message);
        } catch (Exception e) {
            throw e;
        }
    }
    private String getDetails(String key) throws Exception {
        if(Objects.equals(key, "")) {
            throw new Exception("Key set to empty string");
        }
        return "data for " + key;
    }
}
