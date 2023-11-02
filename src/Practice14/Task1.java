package Practice14;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Task1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            list.add(i);
        }
        WaitList<Integer> waitList1 = new WaitList<>(list);
        BoundedWaitList<Integer> waitList2 = new BoundedWaitList<>(list, 10);
        UnfairWaitList<Integer> waitList3 = new UnfairWaitList<>(list);

        System.out.println(waitList3);
        waitList3.moveToBack(2);
        System.out.println(waitList3);
    }
}

interface IWaitList<E> {
    public void add(E element);
    public E remove();
    public boolean contains(E element);
    public boolean containsAll(Collection<E> c);
    public boolean isEmpty();
}

class WaitList<E> implements IWaitList<E> {
    final protected Deque<E> deque = new ConcurrentLinkedDeque<>();

    public WaitList() {}

    public WaitList(Collection<E> c) {
        deque.addAll(c);
    }

    @Override
    public void add(E element) {
        deque.add(element);
    }

    @Override
    public E remove() {
        return deque.remove();
    }

    @Override
    public boolean contains(E element) {
        return deque.contains(element);
    }

    @Override
    public boolean containsAll(Collection<E> c) {
        Iterator<E> it = c.iterator();
        while(it.hasNext()) {
            if(!deque.contains(it.next()))
                return false;
        }
        return true;
    }

    @Override
    public boolean isEmpty() {
        return deque.isEmpty();
    }

    @Override
    public String toString() {
        String tmp = "";
        Iterator<E> it = deque.iterator();
        while(it.hasNext()) {
            tmp = tmp.concat(it.next() + " ");
        }
        return tmp;
    }
}

class BoundedWaitList<E> extends WaitList<E> {
    final private int capacity;

    public BoundedWaitList(Collection<E> c, int capacity) {
        super(c);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}

class UnfairWaitList<E> extends WaitList<E> {
    public UnfairWaitList(Collection<E> c) {
        super(c);
    }

    public void moveToBack(E element) {
        deque.remove(element);
        deque.add(element);
    }
}
