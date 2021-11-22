import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.Scanner;

import static java.lang.Integer.toBinaryString;

public class Decorator {
        static String cryptedOpenText(Path path) {

            String opentext = "";

            try (Scanner sc = new Scanner(path))
            {
                while (sc.hasNext()) {
                    String s = sc.nextLine();
                    opentext += s;
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }

            System.out.println("Изначальная строка: " + opentext);

            byte[] bytes = opentext.getBytes(Charset.forName("windows-1251"));

            opentext = "";

            for (byte b : bytes)
                opentext += toBinaryString(b);

            String result = "";

            for (int i = 0; i < opentext.length(); i++){
                if (i % 8 == 0){
                    result += " ";
                }
                result +=opentext.charAt(i);
            }

            return result;
        };
}
