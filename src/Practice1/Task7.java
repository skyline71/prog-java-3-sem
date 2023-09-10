package Practice1;

import java.math.BigInteger;
import java.util.Scanner;
public class Task7 {
    static void fac(int n) {
        BigInteger n1 = new BigInteger("1");
        BigInteger n2 = new BigInteger("0");
        BigInteger n3;
        int i = 1;
        while(i < n + 1) {
            n2 = BigInteger.valueOf(i);
            n3 = n1.multiply(n2);
            n1 = n3;
            i++;
        }
        System.out.println("Факториал " + n + " = " + n1);
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = 0;
        while (true) {
            System.out.print("Введите n (нажмите Ctrl+D, чтобы завершить ввод) ");
            if (!s.hasNextInt()) break;
            n = s.nextInt();
            if(n < 0) {
                System.out.println("Число должно быть положительным");
            }
            else if(n > 10000) {
                System.out.println("Число не должно превышать 10000");
            }
            else {
                fac(n);
            }
        }
    }
}
