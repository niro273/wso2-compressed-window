import java.util.Arrays;

public class Hello {

    public static void main(String[] args) {

        // intializing an array arr1
        byte[] arr1 = new byte[] {5, 62, 15,50,49};
        // copying array arr1 to arr2 with newlength as 5
        byte[] arr2 = Arrays.copyOf(arr1, 3);
    }
}
