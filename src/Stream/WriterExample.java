package Stream;
import java.io.*;

/**
 * Similar OutputStream but manipulate char unit
 */
public class WriterExample {
  public static void main(String[] args) {
    WriterExample example = new WriterExample();
    example.writeSingleChar();
    example.writeCharArray();
    example.writeCharArrayWithOffset();
  }

  public void writeSingleChar() {
    try (Writer writer = new FileWriter("example_single.txt")) {
      writer.write(65); // Writes 'A'
      writer.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void writeCharArray() {
    char[] buffer = "Hello, World!".toCharArray();
    try (Writer writer = new FileWriter("example_array.txt")) {
      writer.write(buffer);
      writer.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void writeCharArrayWithOffset() {
    char[] buffer = "Hello, Wonderful World!".toCharArray();
    try (Writer writer = new FileWriter("example_offset.txt")) {
      writer.write(buffer, 7, 9); // Writes 'Wonderful'
      writer.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void closeWriter(Writer writer) {
    try {
      if (writer != null) {
        writer.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

