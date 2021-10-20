package com.company;

import com.netcracker.domain.calculator.Calculator;

public class Main {

    public static void main(String[] args) {
    float a = 100;
    float b = 5;

    Calculator calculator = new Calculator(a,b);
    System.out.println("Умножение " + calculator.multiple(a, b));
    System.out.println("Деление " + calculator.devide(a, b));
    System.out.println("Вычитание " + calculator.minus(a, b));
    System.out.println("Сложение " + calculator.add(a, b));

    }
}
