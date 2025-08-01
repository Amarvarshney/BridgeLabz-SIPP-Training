package javaStreams;

import java.io.*;
 class ImageToByteArray {
    public static void main(String[] args) {
        String sourceImage = "image.jpg";
        String destImage = "image_copy.jpg";

        try (FileInputStream fis = new FileInputStream(sourceImage);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            byte[] imageData = baos.toByteArray();

            try (FileOutputStream fos = new FileOutputStream(destImage)) {
                fos.write(imageData);
                System.out.println("Image copied successfully.");
            }

        } catch (IOException e) {
            System.out.println("Error processing image: " + e.getMessage());
        }
    }
}

