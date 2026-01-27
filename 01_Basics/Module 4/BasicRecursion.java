import java.util.*;

public class BasicRecursion {

  public static void main(String[] args) {

    System.out.println("Enter your name:");
    Scanner scanner = new Scanner(System.in);

    String name = scanner.nextLine();

    System.out.println("How many times would you like to print your name?");
    int times = scanner.nextInt();

    printName(name, times);
    scanner.close();
  }

  public static void printName(String name, int times) {
    if (times <= 0) {
      return;
    }
    System.out.println(name);
    printName(name, times - 1);
  }
}
