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
        SlidingWindow<CompressedData> compressedDataSlidingWindow;
        compressedDataSlidingWindow = new SlidingWindow<CompressedData>();


        SlidingWindow<CompressedData> compressedList;
        compressedList = new SlidingWindow<CompressedData>();

        compressedList.enqueue(new CompressedData("stream1"));
        compressedList.enqueue(new CompressedData("stream2"));
        compressedList.enqueue(new CompressedData("stream3"));

        compressedDataSlidingWindow.addItems(compressedList);
        compressedDataSlidingWindow.enqueue(new CompressedData("Stream 4"));
        System.out.println("The employees' names are:");

        while (compressedDataSlidingWindow.hasItems()) {
            CompressedData compressedData = compressedDataSlidingWindow.dequeue();
            System.out.println(compressedData.streamName);
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
