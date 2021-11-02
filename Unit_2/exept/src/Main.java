public class Main {
    public static void main(String[] args) {
        String password1 = "1234";
        String password2 = "1fg34";
        try{
            Exeptionable.method(password1);
            Exeptionable.method(password2);
        } catch (myExeption myExeption) {
            myExeption.getSolution(password1);
            myExeption.getSolution(password2);
            System.out.println(myExeption);
        }
    }
}
