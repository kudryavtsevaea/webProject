import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class VerbsService {
   private static VerbsService INSTANCE;
   private TreeSet<Verbs> verbs = new TreeSet<>();

   private VerbsService(){
       try (Scanner sc = new Scanner(new File
               ("E:\\NetCracker2021\\autumn2021\\Unit_1\\untitled\\src\\verbs.csv"),
               StandardCharsets.UTF_8)){
           while (sc.hasNextLine()){
               String s = sc.nextLine();
               String[] split = s.split(";");
               Verbs verb = new Verbs(split[0], split[1], split[2], split[3]);
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

    public TreeSet<Verbs> getVerbs(){
        return verbs;
    }

    public void getShuffle(List<Verbs> verb){
        Collections.shuffle(verb);

        Iterator<Verbs> iterator = verb.iterator();
        int count = 0;
        System.out.println("Shuffle:");
        while(iterator.hasNext()){
            System.out.println(++count + " : "
                    + iterator.next());
        }
    }

}
