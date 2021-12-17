import com.netcracker.KeyListener;
import com.netcracker.LibrarySystem;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import java.sql.SQLException;

public class App extends SpringBootServletInitializer {
    public static void main(String[] args) throws SQLException {

        LibrarySystem librarySystem = new LibrarySystem();
        KeyListener keyListeners = new KeyListener();
        librarySystem.printMenu();
    }
}
