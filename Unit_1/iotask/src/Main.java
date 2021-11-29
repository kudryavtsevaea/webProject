import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws IOException {
//        try(Scanner sc = new Scanner(new File("E:\\NetCracker2021\\iotask\\src\\input\\inputFile"))) {
//            String binaryString = "";
//            while (sc.hasNext()){
//                String s = sc.next();
//                binaryString += s;
//            }

            byte[] bytes = Base64.getDecoder().decode
                    (Files.readAllBytes(Paths.get("E:\\NetCracker2021\\iotask\\src\\input\\inputFile")));

            BufferedImage picture = ImageIO.read(new ByteArrayInputStream(bytes));

            ImageIO.write(picture, "png",
                    new File("E:\\NetCracker2021\\iotask\\src\\input\\outputFile.png"));


       // } catch (FileNotFoundException e) {
        //    e.printStackTrace();
       // }
        //catch (IOException exception) {
         //   exception.printStackTrace();
        //}
    }
}