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
        GenQueue<Employee> empList;
        empList = new GenQueue<Employee>();
        GenQueue<HourlyEmployee> hList;
        hList = new GenQueue<HourlyEmployee>();
        hList.enqueue(new HourlyEmployee("T", "D"));
        hList.enqueue(new HourlyEmployee("G", "B"));
        hList.enqueue(new HourlyEmployee("F", "S"));
        empList.addItems(hList);
        System.out.println("The employees' names are:");
        while (empList.hasItems()) {
            Employee emp = empList.dequeue();
            System.out.println(emp.firstName + " "
                    + emp.lastName);
        }
    }
}

class compressedData{
    public byte[] data;
}

class Employee {
    public String lastName;
    public String firstName;
    public Employee() {
    }
    public Employee(String last, String first) {
        this.lastName = last;
        this.firstName = first;
    }
    public String toString() {
        return firstName + " " + lastName;
    }
}

class HourlyEmployee extends Employee {
    public double hourlyRate;
    public HourlyEmployee(String last, String first) {
        super(last, first);
    }


}
