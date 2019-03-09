package test.constant;

import test.model.Dog;

public class ConstantTest {
    public static final String DOG_COLOR = "black";//常量写在方法体外，所有单词都是大写中间用_衔接

    public static void main(String[] args) {
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();

        dog1.setName("one");
        dog1.setColor(DOG_COLOR);

        dog2.setName("two");
        dog2.setColor(DOG_COLOR);

        dog1.run();
        dog2.run();

        System.out.println(dog1.getName()+dog1.getColor());
        System.out.println(dog2.getName()+dog2.getColor());

    }
}
