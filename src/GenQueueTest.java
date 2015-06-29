import java.util.LinkedList;

class GenQueue<compressedData> {
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
    public void addItems(GenQueue<? extends compressedData> q) {
        while (q.hasItems())
            list.addLast(q.dequeue());
    }
}

public class GenQueueTest {
    public static void main(String[] args) {
        GenQueue<CompressedData> empList;
        empList = new GenQueue<CompressedData>();
        GenQueue<CompressedData> compressedList;


        compressedList = new GenQueue<CompressedData>();
        compressedList.enqueue(new CompressedData());
        compressedList.enqueue(new CompressedData());
        compressedList.enqueue(new CompressedData());
        empList.addItems(compressedList);
        System.out.println("The employees' names are:");

        while (empList.hasItems()) {
            CompressedData compressedData = empList.dequeue();
//            System.out.println(emp.firstName + " "
//                    + emp.lastName);
        }
    }
}

class CompressedData {
    public byte[] data;
}

//class Employee {
//    public String lastName;
//    public String firstName;
//    public Employee() {
//    }
//    public Employee(String last, String first) {
//        this.lastName = last;
//        this.firstName = first;
//    }
//    public String toString() {
//        return firstName + " " + lastName;
//    }
//}
//
//class HourlyEmployee extends Employee {
//    public double hourlyRate;
//    public HourlyEmployee(String last, String first) {
//        super(last, first);
//    }
//
//
//}