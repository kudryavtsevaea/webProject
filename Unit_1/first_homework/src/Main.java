public class Main {
    public static void main(String[] args){
        int a = 3;
        int b = 1;
        int c = -1;
        int e = -5;

        System.out.println("Модуль " + e + " = " + MagicMath.abs(e));
        System.out.println("Факториал " + a + " = " + MagicMath.fact(a));
        System.out.println(c + " в степени " + b + " = " + MagicMath.pow(c,b));
    }
}
