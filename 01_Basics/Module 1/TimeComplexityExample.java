public class TimeComplexityExample {
  public static void main(String[] args) {
    int n = 5;
    // O(n)
    for (int i = 0; i < n; i++) {
      System.out.println("Hello");
    }

    // O(n^2)
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print("* ");
      }
      System.out.println();
    }
  }
}
