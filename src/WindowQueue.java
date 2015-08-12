import java.util.LinkedList;

public class WindowQueue<compressedData> {

    private LinkedList<compressedData> list = new LinkedList<compressedData>();

    public void enqueue(compressedData item) {
        list.addLast(item);
    }

    public compressedData dequeue() {
        return list.poll();
    }
    public boolean hasItems() {
        return !list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public void addItems(SlidingWindow<? extends compressedData> q) {
        while (q.hasItems())
            list.addLast(q.dequeue());
    }
}
