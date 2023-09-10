package Practice1;

import java.util.Scanner;
import java.util.Arrays;
public class Task4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Введите размер массива ");
        int n = s.nextInt();
        int[] arr = new int[n]; int sum = 0;
        System.out.print("Введите элементы массива через пробел ");
        int i = 0;
        do {
            arr[i] = s.nextInt();
            sum += arr[i];
            i++;
        } while(i < n);
        //System.out.println("Сумма = " + sum);
        sum = 0; i = 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        while(i < n) {
            if(arr[i] > max) { max = arr[i]; }
            if(arr[i] < min) { min = arr[i]; }
            sum += arr[i];
            i++;
        }
        System.out.println("Сумма = " + sum);
        System.out.println("Max = " + max);
        System.out.println("Min = " + min);
    }
}
