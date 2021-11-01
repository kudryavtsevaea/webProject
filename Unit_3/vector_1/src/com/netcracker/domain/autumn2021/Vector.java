package com.netcracker.domain.autumn2021;

public class Vector implements Functionable{
    private Point3D a;
    private Point3D b;

    public void setA(Point3D a) {this.a = a;}

    public void setB(Point3D b) {this.b = b;}

    Vector(Point3D a, Point3D b){
        setA(a);
        setB(b);
        //  System.out.println("������ � ������������ " + a.toString() +
          //      "; " + b.toString() + " ��� ������ �� ������������");
    }

    public double vectorLength(Vector vector){
        Vector vec = new Vector(vector.a, vector.b);

        return Math.sqrt(Math.pow(vec.a.getX() - vec.b.getX(), 2)
                + Math.pow(vec.a.getY() - vec.b.getY(), 2)
                + Math.pow(vec.a.getZ() - vec.b.getZ(), 2));
    };

    public double scalarMult(Vector vector1, Vector vector2){
        return (((vector1.a.getX() * vector2.a.getX()) +
                (vector1.a.getY() * vector2.a.getY()) +
                (vector1.a.getZ() * vector2.a.getZ())) -
                ((vector1.b.getX() * vector2.b.getX()) +
                (vector1.b.getY() * vector2.b.getY()) +
                (vector1.b.getZ() * vector2.b.getZ())));
    };

    public Vector vectorMult(Vector vector1, Vector vector2){
        Point3D point1 = new Point3D(((vector1.a.getY() * vector2.a.getZ()) - (vector1.a.getZ() - vector2.a.getY())),
                ((vector1.a.getZ() - vector2.a.getX()) - (vector1.a.getX() - vector2.a.getZ())),
                ((vector1.a.getX() - vector2.a.getY()) - (vector1.a.getY() - vector2.a.getX())));
        Point3D point2 = new Point3D(((vector1.b.getY() * vector2.b.getZ()) - (vector1.b.getZ() - vector2.b.getY())),
                ((vector1.b.getZ() - vector2.b.getX()) - (vector1.b.getX() - vector2.b.getZ())),
                ((vector1.b.getX() - vector2.b.getY()) - (vector1.b.getY() - vector2.b.getX())));
        System.out.println("������ ������� = " + point1.toString());
        System.out.println("����� ������� = " + point2.toString());
        return new Vector(point1, point2);
    };

    public double Corner(Vector vector1, Vector vector2)
    {
        return scalarMult(vector1, vector2)/(vectorLength(vector1)*vectorLength(vector2))*180/Math.PI;
        //� ��������
    };

    public Vector vectorMinus(Vector vector1, Vector vector2){
        Point3D point1 = new Point3D((vector1.a.getX() - vector2.a.getX()),
                (vector1.a.getY() - vector2.a.getY()),
                (vector1.a.getZ() - vector2.a.getZ()));
        Point3D point2 = new Point3D((vector1.b.getX() - vector2.b.getX()),
                (vector1.b.getY() - vector2.b.getY()),
                (vector1.b.getZ() - vector2.b.getZ()));
        System.out.println("������ ������� = " + point1.toString());
        System.out.println("����� ������� = " + point2.toString());
        return new Vector(point1, point2);
    };

    public Vector vectorPlus(Vector vector1, Vector vector2){
        Point3D point1 = new Point3D((vector1.a.getX() - vector2.a.getX()),
                (vector1.a.getY() + vector2.a.getY()),
                (vector1.a.getZ() + vector2.a.getZ()));
        Point3D point2 = new Point3D((vector1.b.getX() + vector2.b.getX()),
                (vector1.b.getY() + vector2.b.getY()),
                (vector1.b.getZ() + vector2.b.getZ()));
        System.out.println("������ ������� = " + point1.toString());
        System.out.println("����� ������� = " + point2.toString());
        return new Vector(point1, point2);
    };

    @Override
    public String toString(){
      return (a.toString() + "; " + b.toString());
    };
}