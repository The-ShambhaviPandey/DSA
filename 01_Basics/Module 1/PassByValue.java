public class PassByValue {
  static void changeValue(int a) {
    a = 100;
  }

  public static void main(String[] args) {
    int num = 10;
    changeValue(num);
    System.out.println("After function call: " + num); // Still 10
  }
}
