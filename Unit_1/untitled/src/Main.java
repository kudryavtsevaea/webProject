import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.lang.*;

public class Main {

    public static void main(String[] args) {
        VerbsService verbsService = VerbsService.getInstance();

        TreeSet<Verbs> verbs = verbsService.getVerbs();


    }
}
