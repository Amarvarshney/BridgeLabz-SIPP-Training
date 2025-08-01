package javaStreams;

import java.io.*;

public class BufferedFileCopy {
    public static void main(String[] args) {
        String sourcePath = "largefile.txt";
        String destPath = "copy_largefile.txt";

        long startTime = System.nanoTime();

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourcePath));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destPath))) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            System.out.println("Buffered file copy completed.");

        } catch (IOException e) {
            System.out.println("I/O error occurred: " + e.getMessage());
        }

        long endTime = System.nanoTime();
        System.out.println("Buffered copy time: " + (endTime - startTime) + " ns");
    }
}

class UnbufferedFileCopy {
    public static void main(String[] args) {
        String sourcePath = "largefile.txt";
        String destPath = "copy_largefile_unbuffered.txt";

        long startTime = System.nanoTime();

        try (FileInputStream fis = new FileInputStream(sourcePath);
             FileOutputStream fos = new FileOutputStream(destPath)) {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
            System.out.println("Unbuffered file copy completed.");

        } catch (IOException e) {
            System.out.println("I/O error occurred: " + e.getMessage());
        }

        long endTime = System.nanoTime();
        System.out.println("Unbuffered copy time: " + (endTime - startTime) + " ns");
    }
}
