import com.netcracker.controller.KeyListener;
import com.netcracker.view.Authentication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import java.sql.SQLException;
import java.util.Scanner;

public class App extends SpringBootServletInitializer {
    public static void main(String[] args) throws SQLException {
        Authentication authentication = new Authentication();
        KeyListener keyListeners = new KeyListener();
        Scanner sc = new Scanner(System.in);
            while (true){
                String option = sc.nextLine();
                keyListeners.keyPressed(option);
            }

    }
}
