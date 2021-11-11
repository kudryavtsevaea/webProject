import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) {

        VerbsService verbsService = VerbsService.getInstance();
        TreeSet<Verbs> verbs = verbsService.getVerbs();

        List <Verbs> notSorted;
        notSorted = verbs.stream().toList();
//        Collections.shuffle(notSorted);
        notSorted.forEach(System.out::println);

        System.out.println("-----------------------------------");

        TreeSet<Verbs> sortedVerbs = new TreeSet<>(
                (o1, o2) -> o1.getPresentSimple().compareTo(o2.getPresentSimple()));

        sortedVerbs.addAll(verbs);

        Iterator<Verbs> iterator = sortedVerbs.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            Verbs verb = iterator.next();
                System.out.println(++count + " : "
                     + iterator.next());
        }

        System.out.println("-----------------------------------");

        Iterator<Verbs> iterator2 = sortedVerbs.iterator();

        while (iterator2.hasNext()) {
            Verbs verb = iterator2.next();
            if (verb.getRusName().startsWith("ñ")) {
                System.out.println(verbs);
                break;
            }
        }

        System.out.println("-----------------------------------");

        while (iterator2.hasNext()) {
            Verbs verb = iterator2.next();
            if (verb.getRusName().startsWith("ò")) {
                System.out.println(verbs);
                break;
            }
        }

    }
}
