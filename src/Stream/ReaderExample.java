package Stream;

import java.io.*;

/**
 * Reader like InputStream but instead store and manipulate byte unit,
 * Reader store and manipulate char unit.
 */
public class ReaderExample {
  public static void main(String[] args) {
    ReaderExample example = new ReaderExample();
    example.readSingleChar();
    example.readCharArray();
    example.readCharArrayWithOffset();
  }

  public void readSingleChar() {
    try (Reader reader = new FileReader("example.txt")) {
      int data = reader.read();
      while (data != -1) {
        System.out.println((char) data);
        data = reader.read();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void readCharArray() {
    char[] buffer = new char[10];
    try (Reader reader = new FileReader("example.txt")) {
      int charsRead = reader.read(buffer);
      while (charsRead != -1) {
        System.out.println(new String(buffer, 0, charsRead));
        charsRead = reader.read(buffer);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void readCharArrayWithOffset() {
    char[] buffer = new char[20];
    try (Reader reader = new FileReader("example.txt")) {
      int charsRead = reader.read(buffer, 5, 10);
      while (charsRead != -1) {
        System.out.println(new String(buffer, 5, charsRead));
        charsRead = reader.read(buffer, 5, 10);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void closeReader(Reader reader) {
    try {
      if (reader != null) {
        reader.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
