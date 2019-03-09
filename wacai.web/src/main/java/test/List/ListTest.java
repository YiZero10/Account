package test.List;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>(); /*<>这是一个泛型 如果没有明确要求是可以的，*/
        list1.add("12345");                     /*但是操作对象的来兴不确定容易出错  */
        list1.add("45678");
        list1.add("abcde");
        list1.add("ghijk");

        System.out.println(list1.size());

        list1.remove("12345"); //根据内容删除
        System.out.println("delete:"+list1.size());

        System.out.println(list1.remove("123"));

        list1.remove(2); //根据下标删除
        System.out.println("delete second:"+list1.size());

        for (String item : list1){
            System.out.println("元素是："+ item);
        }

        System.out.println("NO.2:"+list1.get(1)); //get只能通过下标来找

        if (list1.size()>0){
            System.out.println("这不是空的集合");
        }

        if (!list1.isEmpty()){
            System.out.println("这不是空的集合");
        }

    }
}
