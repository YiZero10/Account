package test.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterTest {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a1","a2","a3","b1","b2","b3","c1","c2","c3");
        List<String> filterd = (List<String>) strings.stream().filter(str->str.startsWith("a")).collect(Collectors.toList());
        //filterd 将上面的strings变成了流调用filter进行筛选 括号中为筛选条件可以自己定义最后用collecte在收集起来
        System.out.println(filterd);

    }
}
