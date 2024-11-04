package Stream;

import java.io.*;

public class ByteStream {
  public static void read() {
    try (InputStream inputStream = new FileInputStream("src/Stream/example.txt")) {
      // reads a single byte of data
      int data = inputStream.read();
      while (data != -1) {
        System.out.println((char) data);
        data = inputStream.read();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void readByte() {
    byte[] buffer = new byte[10];
    try (InputStream inputStream = new FileInputStream("src/Stream/example.txt")) {
      // reads byte into a byte array
      int bytesRead = inputStream.read(buffer);
      while (bytesRead != -1) {
        System.out.println(new String(buffer, 0, bytesRead));
        bytesRead = inputStream.read(buffer);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void readWithOffSet() {
    byte[] buffer = new byte[20];
    // this try contain close() method of InputStream
    try (InputStream inputStream = new FileInputStream("src/Stream/example.txt")) {
      // reads byte into a part of a byte array start from offset with number of byte is 5
      int bytesRead = inputStream.read(buffer, 4, 5);
      while (bytesRead != -1) {
        System.out.println(new String(buffer, 4, bytesRead));
        bytesRead = inputStream.read(buffer, 4, 5);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void readWithDirectlyClose() {
    byte[] buffer = new byte[20];
    // this try contain close() method of InputStream
    try {
      InputStream inputStream = new FileInputStream("src/Stream/example.txt");
      // reads byte into a part of a byte array start from offset with number of byte is 5
      int bytesRead = inputStream.read(buffer, 4, 5);
      while (bytesRead != -1) {
        System.out.println(new String(buffer, 4, bytesRead));
        bytesRead = inputStream.read(buffer, 4, 5);
      }
      inputStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void write() {
    try (OutputStream outputStream = new FileOutputStream("exampleOut.txt")) {
      // Write a single byte
      outputStream.write(65); // Writes 'A'
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  public static void writeByteArray() {
    byte[] data = "Hello, World!".getBytes();
    try (OutputStream outputStream = new FileOutputStream("exampleOut.txt")) {
      // write an array of bytes
      outputStream.write(data);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void writeWithOffSet() {
    byte[] data = "Hello, World!".getBytes();
    try (OutputStream outputStream = new FileOutputStream("exampleOut.txt")) {
      // write a portion of an array of bytes
      // a bytes is a char in ASCII (default)
      outputStream.write(data, 1, 2); // Writes 'World!'
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  public static void closeOutputStream() {
    try {
      OutputStream outputStream = new FileOutputStream("example.txt");
      outputStream.write(65);
      // Closes the stream and releases any system resources associated with it.
      outputStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  public static void flushOutputStream() {
    try (OutputStream outputStream = new FileOutputStream("example.txt")) {
      outputStream.write(65); // Writes 'A'
      // Flushes the output stream and forces any buffered output bytes to be written out.
      outputStream.flush(); // Flushes the stream
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    read();
    readByte();
    readWithOffSet();
    readWithDirectlyClose();
    write();
    writeByteArray();
    writeWithOffSet();
    closeOutputStream();
  }
}
