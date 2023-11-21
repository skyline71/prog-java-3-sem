package Practice12;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Task1 {
    public static void main(String[] args) {
        SolutionTask1 task1 = new SolutionTask1();
        List<Integer> list = task1.getPlayers();
        task1.pushPlayers(list);
        task1.playGame();
    }
}

class SolutionTask1 {
    private List<Integer> cards1 = new ArrayList<>();
    private List<Integer> cards2 = new ArrayList<>();
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
                cards1.add(players.get(i));
            } else {
                cards2.add(players.get(i));
            }
        }
    }

    public void playGame() {
        Integer val1, val2 = 0;
        for(int i = 0; i < 106; i++) {
            if(cards1.isEmpty() || cards2.isEmpty()) {
                if(cards1.isEmpty()) {
                    System.out.println("second " + count);
                }
                else {
                    System.out.println("first " + count);
                }
                return;
            }
            val1 = cards1.get(0);
            val2 = cards2.get(0);
            cards1.remove(0);
            cards2.remove(0);
            if(val1 < val2 || (val1.equals(9) && val2.equals(0))) {
                cards1.add(val1);
                cards1.add(val2);
            }
            else {
                cards2.add(val1);
                cards2.add(val2);
            }
            count++;
        }
        System.out.println("botva");
    }
}




