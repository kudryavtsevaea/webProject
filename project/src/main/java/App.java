import com.netcracker.controller.KeyListener;
import com.netcracker.controller.OperationsWithBooks;
import com.netcracker.controller.OperationsWithSpecificBooks;
import com.netcracker.models.Library;
import com.netcracker.view.LibrarySystem;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import java.sql.SQLException;
import java.util.Scanner;

public class App extends SpringBootServletInitializer {
    public static void main(String[] args) throws SQLException {

        LibrarySystem librarySystem = new LibrarySystem();
        KeyListener keyListeners = new KeyListener();
        librarySystem.printMenu();
        Scanner sc = new Scanner(System.in);
            while (true){
                String option = sc.nextLine();
                keyListeners.keyPressed(option);
            }

    }
}
