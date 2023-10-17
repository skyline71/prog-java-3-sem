package Practice10;

import java.util.Scanner;
public class Task13 {
    public static void getOdd() {
        Scanner s = new Scanner(System.in);
        int num, k = 0;
        while(true) {
            num = s.nextInt();
            k++;
            if(num == 0) return;
            else if(k % 2 == 1) {
                System.out.println(num);
            }
        }
    }

    public static void main(String[] args) {
        getOdd();
    }
}
