package Practice19;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Task3 {
    public static void main(String[] args) {
        Integer[] numbers = new Integer[] {1, 2, 3, 4, 5};
        String[] strings = new String[] {"Test1", "Test2", "Test3"};

        ClassTask3<Integer> class1 = new ClassTask3<>(numbers);
        Integer element1 = class1.getAt(2);
        System.out.println(element1);

        ClassTask3<String> class2 = new ClassTask3<>(strings);
        String element2 = class2.getAt(0);
        System.out.println(element2);
    }
}

class ClassTask3<T> {
    private List<T> list;

    public ClassTask3(T[] array) {
        list = new ArrayList<>();
        Collections.addAll(list, array);
    }

    public T getAt(int index) {
        try {
            return list.get(index);
        }
        catch (Exception e) {
            System.out.println("Array index out of bounds");
        }
        return null;
    }
}
