import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4Factory;
import net.jpountz.lz4.LZ4FastDecompressor;
import net.jpountz.lz4.LZ4SafeDecompressor;

import java.io.*;

public class Test {

    public static final int maxBlockLines = 1000;

    public static void main(String[] args) throws IOException {

//        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("text.txt")));
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

        LZ4Factory factory = LZ4Factory.fastestInstance();

        /* Get the Data Stream from the folder */
        byte[] data = "12345345234572".getBytes("UTF-8");
        final int decompressedLength = data.length;

        /* Get N number of record to compress */

        /* Send these blocks to be compressed */

        /* Enqueue the block in the linked list */

        /* If the queue size exceeds decompress first block and remove */
        // compress data
        LZ4Compressor compressor = factory.fastCompressor();
        int maxCompressedLength = compressor.maxCompressedLength(decompressedLength);
        byte[] compressed = new byte[maxCompressedLength];
        int compressedLength = compressor.compress(data, 0, decompressedLength, compressed, 0, maxCompressedLength);


        // decompress data
        // - method 1: when the decompressed length is known
        LZ4FastDecompressor decompressor = factory.fastDecompressor();
        byte[] restored = new byte[decompressedLength];
        int compressedLength2 = decompressor.decompress(compressed, 0, restored, 0, decompressedLength);
        // compressedLength == compressedLength2

        // - method 2: when the compressed length is known (a little slower)
        // the destination buffer needs to be over-sized
        LZ4SafeDecompressor decompressor2 = factory.safeDecompressor();
        int decompressedLength2 = decompressor2.decompress(compressed, 0, compressedLength, restored, 0);
        // decompressedLength == decompressedLength2

    }
}
