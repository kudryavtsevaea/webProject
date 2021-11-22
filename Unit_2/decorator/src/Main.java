import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Бинарная строка: " + Decorator.cryptedOpenText
                (Path.of("E:\\NetCracker2021\\autumn2021\\Unit_2\\decorator\\src\\opentext.txt")));

    }
}