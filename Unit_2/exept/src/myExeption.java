import java.nio.charset.Charset;

public class myExeption extends Exception {

    public myExeption(String message) {
        super(message);
    }

    public void  getSolution(String str){
        String str1 = "";
        for (int i = 0; i < str.length(); i++){
           if(Character.isLetter(str.charAt(i))){
               str1 += '0';
               System.out.println(str.charAt(i) + " был заменен на 0");
           }
           else
               str1 += str.charAt(i);

        }
        System.out.println("Новый пароль: " + str1);
    }

}
