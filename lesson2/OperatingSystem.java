import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class OperatingSystem {
    public OperatingSystem() throws IOException {
    }

    private static List<Integer> readByteFromFile(String fileName) throws IOException {
        List<Integer> imgByteToWrite = new ArrayList<>();
        RandomAccessFile aFile = new RandomAccessFile(fileName, "r");
        FileChannel inChannel = aFile.getChannel();
        try {
            ByteBuffer buf = ByteBuffer.allocate(48);
            int bytesRead = inChannel.read(buf);
            while (bytesRead != -1) {
                buf.flip();
                while (buf.hasRemaining()) {
                    imgByteToWrite.add((int) buf.get());
                }
                buf.clear();
                bytesRead = inChannel.read(buf);
            }
        } finally {
            aFile.close();
            inChannel.close();
        }

        return Collections.unmodifiableList(imgByteToWrite);
    }


    public static List<Integer> getSystemImgByteArray(String fileName) throws IOException {
        List<Integer> bootsByte = readByteFromFile(fileName);

        List<Integer> systemImage = new ArrayList<>();
        systemImage.addAll(bootsByte);

        systemImage.add(0x55);
        systemImage.add(0xaa);
        systemImage.add(0xf0);
        systemImage.add(0xff);
        systemImage.add(0xff);

        int len = 0x168000;
        int curSize = systemImage.size();
        for (int l = 0; l < len - curSize; l++) {
            systemImage.add(0);
        }
        return Collections.unmodifiableList(systemImage);

    }

    public static void exportSystemImg(List<Integer> systemImage, String imagePath){
        try {
            DataOutputStream out = new DataOutputStream(new FileOutputStream(imagePath));
            for (int i = 0; i < systemImage.size(); i++) {
                out.writeByte(systemImage.get(i).byteValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        List<Integer> systemImgByteArray = getSystemImgByteArray("boot.bat");
        exportSystemImg(systemImgByteArray, "system.img");
    }
}