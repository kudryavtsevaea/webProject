import com.netcracker.controller.KeyListener;
import com.netcracker.view.Authentication;

import java.sql.SQLException;
import java.util.Scanner;

public class App{
    public static void main(String[] args) throws SQLException {
        KeyListener keyListeners = new KeyListener();
        Scanner sc = new Scanner(System.in);
            while (true){
                String option = sc.nextLine();
                keyListeners.keyPressed(option);
            }

    }
}
