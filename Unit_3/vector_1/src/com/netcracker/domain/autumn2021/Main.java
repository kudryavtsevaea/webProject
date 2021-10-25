package com.netcracker.domain.autumn2021;

public class Main {
    public static void main(String[] args) {

        //условимся, что a - начало вектора

        Point3D a = new Point3D(10, 10, 10);
        Point3D b = new Point3D(20, 20, 20);

        Point3D c = new Point3D(6, 4, 2);
        Point3D d = new Point3D(2, 2, 1);

        Vector vector1 = new Vector(a, b);
        Vector vector2 = new Vector(c, d);

        System.out.println("Длина вектора = " + vector1.vectorLength(vector1));
        System.out.println("Скалярное произведение -> " + vector2.scalarMult(vector1, vector2));
        System.out.println("Векторное произведение:");
        vector1.vectorMult(vector1, vector2);
        System.out.println("Угол между векторами -> " + vector1.Corner(vector1, vector2));
        System.out.println("Разница векторов:");
        vector1.vectorMinus(vector1, vector2);
        System.out.println("Сумма векторов:");
        vector1.vectorPlus(vector1, vector2);
        Functionable.vectGen(8);
    }
}
