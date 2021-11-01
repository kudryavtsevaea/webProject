package com.netcracker.domain.calculator;

public class Calculator implements Calculated{
    float a;
    float b;

    public Calculator(float a, float b) {
        this.a = a;
        this.b = b;
    }

    public float add(float a, float b){
        return a + b;
    }

    public float minus(float a, float b){
        return a - b;
    }

    public float devide(float a, float b){
        return a / b;
    }

    public float multiple(float a, float b){
        return a * b;
    }
}
