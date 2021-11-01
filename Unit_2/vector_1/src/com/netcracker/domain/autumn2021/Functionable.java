package com.netcracker.domain.autumn2021;

public interface Functionable {
    double vectorLength(Vector vector);
    double scalarMult(Vector vector1, Vector vector2);
    Vector vectorMult(Vector vector1, Vector vector2);
    double Corner(Vector vector1, Vector vector2);
    Vector vectorMinus(Vector vector1, Vector vector2);
    Vector vectorPlus(Vector vector1, Vector vector2);

    static Vector[] vectGen(int n){
        Vector[] vectors = new Vector[n];
        for (int i = 0; i < n; i++) {
            Point3D point1 = new Point3D((Math.random() + 0.5), (Math.random() + 0.5), (Math.random() + 0.5));
            Point3D point2 = new Point3D((Math.random() + 0.5), (Math.random() + 0.5), (Math.random() + 0.5));
            vectors[i] = new Vector(point1, point2);
            System.out.println("Был создан случайный вектор с координатами: " + point1 + "; " + point2);
        }
        System.gc();
        return vectors;
    };
}
