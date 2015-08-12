import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class Processor {

    public static void main(String[] args) throws FileNotFoundException {

        /* Initilizing the sliding window queue implementation */
        SlidingWindow<CompressedData> slidingWindow;
        slidingWindow = new SlidingWindow<CompressedData>();



    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("text.txt")));
//        StringBuilder sb = new StringBuilder("");
//
//        String line = reader.readLine();
//
//        /* Get the first 1000 lines */
//        int count = 0;
//
//        while ((line != null) && (count <maxBlockLines)){
//            sb.append(line);
//            line = reader.readLine();
//            count ++;
//        }

        /* Byte data of 1000 lines */
//        byte[] data = line.getBytes();




    }


}
