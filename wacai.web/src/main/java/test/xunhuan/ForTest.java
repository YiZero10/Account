package test.xunhuan;

import java.util.ArrayList;
import java.util.List;

public class ForTest {
    public static void main(String[] args) {
        List<String> test = new ArrayList<>();
        test.add("abcd");
        test.add("efgh");
        test.add("1234");

        //foreach循环
        for (String item:test) {
            if (item.equals("efgh")){
                break;
            }
            System.out.println("当前的对象是："+item);
        }

        //计数遍历，需要知道索引值的时候就用这个方法
        for (int index =0 ; index<test.size();index++){
            String item = test.get(index);
            System.out.println("当前元素是："+item+",索引值是"+index);
        }
    }
}
