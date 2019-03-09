package test.constant;

public class Test {
    public static void main(String[] args) {
        String a = "123";
        String b = "123";
        String c = new String("123");

        System.out.println(a == b);
        System.out.println(b == c);
        System.out.println(a.equals(b));
        System.out.println(b.equals(c));

    }
}
