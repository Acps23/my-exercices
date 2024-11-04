package io.codeforall.fanstatics;

public class Main {
    public static void main(String[] args) {
        Machine machine = new Machine();

        int x = 4;
        MonoOperation square = num -> num * num; // Squaring an integer
        System.out.println("Square of " + x + " = " + machine.performMonoOperation(square, x));

        int a = 7;
        int b = 5;
        BiOperation add = (num1, num2) -> num1 + num2; // Adding two integers
        System.out.println("Sum of " + a + " and " + b + " = " + machine.performBiOperation(add, a, b));

    }
}




