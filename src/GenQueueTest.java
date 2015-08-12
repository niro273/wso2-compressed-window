import java.util.LinkedList;

class SlidingWindow<compressedData> {

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

public class GenQueueTest {
    public static void main(String[] args) {
        SlidingWindow<CompressedData> slidingWindow;
        slidingWindow = new SlidingWindow<CompressedData>();

        slidingWindow.enqueue(new CompressedData("Stream 1"));
        slidingWindow.enqueue(new CompressedData("Stream 2"));
        slidingWindow.enqueue(new CompressedData("Stream 3"));

        while (slidingWindow.hasItems()) {
            CompressedData compressedData = slidingWindow.dequeue();
        }

    }
}

class CompressedData {
    public byte[] data;
    public  String streamName;

    public CompressedData(String streamName){
        this.streamName = streamName;
    }
}
