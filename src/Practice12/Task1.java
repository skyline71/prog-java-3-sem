package Practice12;

import java.util.Random;
import java.util.Stack;

public class Task1 {
    public static void main(String[] args) {
        Stack player1 = new Stack();
        Stack player2 = new Stack();

        for(int i = 0; i < 10; i++) {
            Random rand = new Random();
            player1.add(rand.nextInt(10));
            player2.add(rand.nextInt(10));
        }

        System.out.println(player1);
        System.out.println(player2);
    }
}
