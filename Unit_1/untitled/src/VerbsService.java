import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class VerbsService {
   private static VerbsService INSTANCE;
   private List<Verb> verbs = new ArrayList<>();

   private VerbsService(){
       try (Scanner sc = new Scanner(new File
               ("E:\\NetCracker2021\\autumn2021\\Unit_1\\untitled\\src\\verbs.csv"),
               StandardCharsets.UTF_8)){
           while (sc.hasNextLine()){
               String s = sc.nextLine();
               String[] split = s.split(";");
               Verb verb = new Verb(split[0], split[1], split[2], split[3]);
               verbs.add(verb);
           }
       }
       catch (IOException ex){
           System.out.println("Файл не найден!");
       }
    }

    public static VerbsService getInstance(){
       if(INSTANCE == null){
           INSTANCE = new VerbsService();
       }
           return  INSTANCE;

    }

    public List<Verb> getVerbs(){
        return verbs;
    }


    public static Verb printVerbs(TreeSet<Verb> sortedVerbs, String alp){
        Iterator<Verb> iterator = sortedVerbs.iterator();
        Verb verb;
        while (iterator.hasNext()) {
            verb = iterator.next();
            if (verb.getRusName().startsWith(alp)) {
                return verb;
            }
        }
        return null;
    }

}
