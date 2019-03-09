package test.StringBuild;

public class StringBuildTest {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        System.out.println(sb);
        sb.append("Hello");
        System.out.println(sb);
        sb.append("world");
        System.out.println(sb);
        for (int i = 0; i < 10 ; i++) {
            sb.append(i);
        }
        System.out.println(sb);
    }
}
