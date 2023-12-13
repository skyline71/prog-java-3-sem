package Practice21;

import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Scanner;

public class ClassTest1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Введите размер очереди: ");
        int size = s.nextInt();
        ArrayQueueModule arrayQueue = new ArrayQueueModule(size);
        int[] array = arrayQueue.getValues();
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < size; i++) {
            queue.offer(array[i]);
        }
        System.out.println("Queue: " + queue);
        int removedNumber = arrayQueue.dequeue(queue);
        System.out.println("Removed Element: " +   removedNumber);
        System.out.println("Queue after deletion: " + queue);
    }
}

class ArrayQueueModule {
    private int[] elements;
    private int size;

    public ArrayQueueModule(int size) {
        elements = new int[size];
        this.size = size;
        setValues();
    }
    public void setValues() {
        for(int i = 0; i < size; i++) {
            elements[i] = i;
        }
    }
    public int[] getValues() {
        return elements;
    }
    public Queue enqueue(Queue queue, int value) {
        queue.offer(value);
        return queue;
    }
    public int element(Queue queue){
        return (int)queue.element();
    }
    public int dequeue(Queue queue) {
        return (int)queue.poll();
    }
    public int size(Queue queue){
        return queue.size();
    }
    public boolean isEmpty(Queue queue){
        return queue.isEmpty();
    }
    public Queue clear(Queue queue) {
        queue.clear();
        return queue;
    }
}
