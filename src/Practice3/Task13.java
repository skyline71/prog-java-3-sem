package Practice3;
import java.util.Random;
public class Task13 {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = new int[4];
        for(int k = 0; k < 5; k++) {
            for(int i = 0; i < arr.length; i++) {
                arr[i] = rand.nextInt(10,100);
            }
            for(int i = 0; i < arr.length - 1; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println(arr[arr.length - 1]);
            if(isSorted(arr)) {
                System.out.println("Массив является строго возрастающей последовательностью");
            }
            else {
                System.out.println("Массив не является строго возрастающей последовательностью");
            }
        }
    }

    static boolean isSorted(int[] array) {
        int n = array.length;
        for(int i = 1; i < n; i++) {
            if(array[i] <= array[i-1]) {
                return false;
            }
        }
        return true;
    }
}


