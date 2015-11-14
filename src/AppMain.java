import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4Factory;

import java.io.*;
import java.util.Arrays;

public class AppMain {

    public static final int maxBlockLines = 10000;    //the number of records to be processed of the CSV in this programme

    public static void main(String[] args) throws IOException {
        String uncompressedData = new String();
        /* Initilizing the sliding window queue implementation */
        WindowQueue<CompressedBlock> slidingWindow = new WindowQueue<CompressedBlock>();

        //CSVHandler csv=new CSVHandler();			//csv file path initialized with path in the csvHandler.java
        CSVHandler csv=new CSVHandler("F:\\FYP related contents\\Debs_challenge\\sorted100M.csv");	//Overloaded method of previous, set CSV file path
        uncompressedData=csv.returnStringData(8000, true );		//String file with number of lines to read from CSV file, 'true' to print reading & 'false' to avoid printing to console
        csv.closeCSVReader();

        byte[] data = uncompressedData.getBytes();
        final int uncompressedLength = data.length;
        System.out.println("Initial bytes  \t : "+ uncompressedLength);

        // compress data
        LZ4Factory factory = LZ4Factory.fastestInstance();
        LZ4Compressor compressor = factory.fastCompressor();
        int maxCompressedLength = compressor.maxCompressedLength(uncompressedLength);
        byte[] compressed = new byte[maxCompressedLength];
        int compressedLength = compressor.compress(data, 0, uncompressedLength, compressed, 0, maxCompressedLength);

        CompressedBlock firstBlock = new CompressedBlock(compressed , "stream 1");
        slidingWindow.enqueue(firstBlock);
        System.out.println("compressed bytes : "+compressedLength );


        byte[] truncated = Arrays.copyOf(compressed,compressedLength);


    }
}
