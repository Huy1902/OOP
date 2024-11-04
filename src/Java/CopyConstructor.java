package Java;

public class CopyConstructor {
  private int a = 10;
  private int b = 10;

  private CopyConstructor() {

  }

  private CopyConstructor(int a, int b) {
    this.a = a;
    this.b = b;
  }

  private CopyConstructor(CopyConstructor other) {
    a = other.a;
    b = other.b;
  }

  public int getA() {
    return a;
  }

  public void setA(int a) {
    this.a = a;
  }

  public int getB() {
    return b;
  }

  public void setB(int b) {
    this.b = b;
  }

  public static void main(String[] args) {
    CopyConstructor copy = new CopyConstructor(1, 2);
    CopyConstructor copy2 = new CopyConstructor(copy);
    System.out.println(copy.getA());
    System.out.println(copy2.getA());
  }
}
