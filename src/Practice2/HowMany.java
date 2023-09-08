package Practice2;

import java.util.Scanner;
public class HowMany {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int count = 0;
        String line = s.nextLine();
        String[] words = line.split("[,\\s]+");
        for(int i = 0; i < words.length; i++) {
            if(isWord(words[i])) { count++; }
        }
        System.out.println("Количество введеных слов: " + count);
    }

    static boolean isWord(String string) {
        for(int i = 0; i < string.length(); i++) {
            if(Character.isDigit(string.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
