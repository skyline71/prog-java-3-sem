package Practice21;

import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Scanner;

public class ClassTest2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Введите размер очереди: ");
        int size = s.nextInt();
        ArrayQueueADT arrayQueue = new ArrayQueueADT(size);
        System.out.println("Queue: " + arrayQueue.getQueue());
        int removedNumber = arrayQueue.dequeue();
        System.out.println("Removed Element: " +  removedNumber);
        System.out.println("Queue after deletion: " + arrayQueue.getQueue());
    }
}

class ArrayQueueADT {
    Queue queue = new ArrayDeque<>();

    public ArrayQueueADT(int size) {
        for(int i = 0; i < size; i++) {
            queue.offer(i);
        }
    }

    public Queue getQueue() {
        return queue;
    }

    public Queue enqueue(int value) {
        queue.offer(value);
        return queue;
    }

    public int element(){
        return (int)queue.element();
    }

    public int dequeue() {
        return (int)queue.poll();
    }

    public int size(){
        return queue.size();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public Queue clear() {
        queue.clear();
        return queue;
    }
}