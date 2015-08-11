import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4Factory;

import java.io.*;

public class AppMain {

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

        /* Get the first 1000 lines */
        int count = 0;

        while ((line != null) && (count <maxBlockLines)){
            sb.append(line);
            line = reader.readLine();
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
//        int compressedLength = compressor.compress(data, 0, decompressedLength, compressed, 0, maxCompressedLength);

        CompressedBlock firstBlock = new CompressedBlock(compressed , "stream 1");
        slidingWindow.enqueue(firstBlock);

    }
}
