package Practice16;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Exception2 e = new Exception2();
        e.exceptionDemo();
    }
}

class Exception2 {
    public void exceptionDemo() {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter an integer ");
        String intString = myScanner.next();
        try {
            int i = Integer.parseInt(intString);
            System.out.println(2/i);
        } catch (NumberFormatException | ArithmeticException e) {
            System.out.println("Wrong number format");
        } finally {
            System.out.println("After try-catch");
        }
    }
}
