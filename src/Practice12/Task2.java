package Practice12;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.ArrayDeque;

public class Task2 {
    public static void main(String[] args) {
        SolutionTask2 task2 = new SolutionTask2();
        List<Integer> list = task2.getPlayers();
        task2.pushPlayers(list);
        task2.playGame();
    }
}

class SolutionTask2 {
    private ArrayDeque<Integer> cards1 = new ArrayDeque<>();
    private ArrayDeque<Integer> cards2 = new ArrayDeque<>();
    private int count = 0;

    public List<Integer> getPlayers() {
        List<Integer> players = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        System.out.println("Введите 1-ые 5 карт:");
        String player1 = s.nextLine();
        System.out.println("Введите 2-ые 5 карт:");
        String player2 = s.nextLine();
        for(int i = 0; i < player1.length(); i++) {
            players.add(Integer.parseInt(Character.toString(player1.charAt(i))));
        }
        for(int i = 0; i < player2.length(); i++) {
            players.add(Integer.parseInt(Character.toString(player2.charAt(i))));
        }
        return players;
    }

    public void pushPlayers(List<Integer> players) {
        for (int i = 0; i < players.size(); i++) {
            if (i < players.size()/2) {
                cards1.offerFirst((players.get(i)));
            } else {
                cards2.offerFirst((players.get(i)));
            }
        }
    }

    public void playGame() {
        Integer val1, val2 = 0;
        for(int i = 0; i < 106; i++) {
            System.out.println("n: " + count);
            System.out.println(cards1);
            System.out.println(cards2);
            if(cards1.isEmpty() || cards2.isEmpty()) {
                if(cards1.isEmpty()) {
                    System.out.println("second " + count);
                }
                else {
                    System.out.println("first " + count);
                }
                return;
            }
            val1 = cards1.pollLast();
            val2 = cards2.pollLast();
            if(val1 < val2 || (val1 == 9 && val2 == 0)) {
                cards1.offerFirst(val1);
                cards1.offerFirst(val2);
            }
            else {
                cards2.offerFirst(val1);
                cards2.offerFirst(val2);
            }
            count++;
        }
        System.out.println("botva");
    }
}




