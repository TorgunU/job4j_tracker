package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int number) {
        return number - x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int number) {
        return number / x;
    }

    public int sumAllOperations(int number) {
        return sum(number) + minus(number) + multiply(number) + divide(number);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int result = calculator.sumAllOperations(4);
        System.out.println(result);
        result = Calculator.sum(5);
        System.out.println(result);
        result = Calculator.minus(10);
        System.out.println(result);
        result = calculator.divide(15);
        System.out.println(result);
        result = calculator.multiply(9);
        System.out.println(result);
    }
}