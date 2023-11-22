package Practice21;

import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Scanner;

public class ClassTest3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Введите размер очереди: ");
        int size = s.nextInt();
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.setValues(arrayQueue, size);
        System.out.println("Queue: " + arrayQueue.getQueue(arrayQueue));
        int removedNumber = arrayQueue.dequeue(arrayQueue);
        System.out.println("Removed Element: " +  removedNumber);
        System.out.println("Queue after deletion: " + arrayQueue.getQueue(arrayQueue));
    }
}

class ArrayQueue {
    Queue queue = new ArrayDeque<>();

    public ArrayQueue() {}

    public void setValues(ArrayQueue arrayQueue, int size) {
        for(int i = 0; i < size; i++) {
            arrayQueue.getQueue(arrayQueue).offer(i);
        }
    }

    public Queue getQueue(ArrayQueue arrayQueue) {
        return arrayQueue.queue;
    }

    public Queue enqueue(ArrayQueue arrayQueue, int value) {
        getQueue(arrayQueue).offer(value);
        return getQueue(arrayQueue);
    }

    public int element(ArrayQueue arrayQueue){
        return (int)getQueue(arrayQueue).element();
    }

    public int dequeue(ArrayQueue arrayQueue) {
        return (int)getQueue(arrayQueue).poll();
    }

    public int size(ArrayQueue arrayQueue){
        return getQueue(arrayQueue).size();
    }

    public boolean isEmpty(ArrayQueue arrayQueue){
        return getQueue(arrayQueue).isEmpty();
    }

    public Queue clear(ArrayQueue arrayQueue) {
        getQueue(arrayQueue).clear();
        return getQueue(arrayQueue);
    }
}