import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4Factory;

import java.io.*;
import java.util.Arrays;

/**
 * Created by niro273 on 11/14/15.
 */
public class Legacy {

    public static final int maxBlockLines = 1000;

    public static void main(String[] args) throws IOException {

        /* Initilizing the sliding window queue implementation */
        WindowQueue<CompressedBlock> slidingWindow = new WindowQueue<CompressedBlock>();

        /* Get the absolute path to load the data file */
        String currentDirectory = new File("").getAbsolutePath();

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(currentDirectory + File.separator + "data.txt")));

        StringBuilder sb = new StringBuilder("");
        String line = reader.readLine();
        String uncompressedData = new String();

        /* Do this continiously in a loop */
        /* Get the first 1000 lines */
        int count = 0;
        while ((line != null) && (count <maxBlockLines)){
            sb.append(line);
            line = reader.readLine();
            line = line.replaceAll(",","");
            uncompressedData += line;
            count ++;
        }

        /* Byte data of 1000 lines */
        byte[] data = uncompressedData.getBytes();
        final int decompressedLength = data.length;

        // compress data
        LZ4Factory factory = LZ4Factory.fastestInstance();
        LZ4Compressor compressor = factory.fastCompressor();
        int maxCompressedLength = compressor.maxCompressedLength(decompressedLength);
        byte[] compressed = new byte[maxCompressedLength];
        int compressedLength = compressor.compress(data, 0, decompressedLength, compressed, 0, maxCompressedLength);

        CompressedBlock firstBlock = new CompressedBlock(compressed , "stream 1");
        slidingWindow.enqueue(firstBlock);


        byte[] truncated = Arrays.copyOf(compressed, compressedLength);

    }
}
