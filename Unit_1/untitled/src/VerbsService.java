import com.sun.source.tree.Tree;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.TreeSet;

public class VerbsService {
    private TreeSet<Verbs> verbs;
    private static VerbsService INSTANCE;

    private VerbsService(){
    }

    public static VerbsService getInstance(){
        if (INSTANCE == null){
            INSTANCE = new VerbsService();
        }
        return INSTANCE;
    }

    public TreeSet<Verbs> getVerbs(){
        TreeSet<Verbs> verbs = new TreeSet<>();
        Verbs verb;
        try (Scanner sc = new Scanner(new File
                ("E:\\NetCracker2021\\autumn2021\\untitled\\src\\verbs.csv"),
                StandardCharsets.UTF_8)){
           while (sc.hasNextLine()){
               String s = sc.nextLine();
               String[] split = s.split(";");
               verb = new Verbs(split[0], split[1], split[2], split[3]);
               verbs.add(verb);
           }
        }
        catch (IOException ex){
            System.out.println("Файл не найден!");
        }
        for(Verbs v: verbs)
            System.out.println(v);

        return verbs;
    }

}
