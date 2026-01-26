class Box {
    int value;
}

public class PassByReference {
    static void modify(Box b) {
        b.value = 99;
    }

    public static void main(String[] args) {
        Box b1 = new Box();
        b1.value = 10;
        modify(b1);
        System.out.println("After function call: " + b1.value); // 99
    }
}
