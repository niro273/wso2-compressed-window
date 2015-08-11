import java.util.LinkedList;

public class WindowQueue<compressedBlock> {

    private LinkedList<compressedBlock> list = new LinkedList<compressedBlock>();

    public void enqueue(compressedBlock item) {
        list.addLast(item);
    }

    public compressedBlock dequeue() {
        return list.poll();
    }
    public boolean hasItems() {
        return !list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public void addItems(SlidingWindow<? extends compressedBlock> q) {
        while (q.hasItems())
            list.addLast(q.dequeue());
    }
}
