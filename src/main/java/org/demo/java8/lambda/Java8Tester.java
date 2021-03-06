package org.demo.java8.lambda;

/**
 * Created by belong on 2017/3/28.
 */
public class Java8Tester {
    public static void main(String args[]) {
        Java8Tester tester = new Java8Tester();
        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;
        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;
        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> {
            return a * b;
        };
        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        // 不用括号
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        // 用括号
        GreetingService greetService2 = (message) ->
                System.out.println("Hello " + message);

        greetService1.sayMessage("Run oob");
        greetService2.sayMessage("Google");
    }

    /**
     * 定义操作数接口
     */
    interface MathOperation {
        int operation(int a, int b);
    }

    /**
     * 定义问候接口（字符串输出接口）
     */
    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        // 实现了重写操作数的接口
        return mathOperation.operation(a, b);
    }
}
