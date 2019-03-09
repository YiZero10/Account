package test.xunhuan;

import java.awt.*;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        double [] list = {1,2,3,4,5};
        double sum=0;
        for (double index:list
             ) {
            sum+=index;
        }
        System.out.println(sum);
    }
}
