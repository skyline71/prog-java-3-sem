package Practice10;

import java.util.Scanner;
public class Task15 {
    public static void split(int N) {
        if(N == 0) return;
        System.out.print(N % 10 + " ");
        split(N/10);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Введите N: ");
        split(s.nextInt());
    }
}
