import java.nio.charset.StandardCharsets;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) {

        VerbsService verbsService = VerbsService.getInstance();
        List<Verb> verbs = verbsService.getVerbs();

        verbs.forEach(System.out::println);

        System.out.println("-----------------------------------");

        Collections.shuffle(verbs);
        verbs.forEach(System.out::println);

        System.out.println("-----------------------------------");


        TreeSet<Verb> sortedVerbs1 = new TreeSet<>((o1,o2) -> o1.
                getRusName().compareTo(o2.getRusName()));

        sortedVerbs1.addAll(verbs);

        sortedVerbs1.forEach(System.out::println);

        System.out.println("-----------------------------------");
        Comparator<Verb>
                rusNameComparator = Comparator.comparing(Verb::getPresentSimple);

        TreeSet<Verb> sortedVerbs2 = new TreeSet<>(rusNameComparator);

        sortedVerbs2.addAll(verbs);

        sortedVerbs2.forEach(System.out::println);

        System.out.println("-----------------------------------");

        System.out.println(VerbsService.printVerbs(sortedVerbs1, "ñ"));


        System.out.println("-----------------------------------");


        System.out.println(VerbsService.printVerbs(sortedVerbs1, "ò"));
//
//        System.out.println("-----------------------------------");
//
//        NavigableSet<Verb> navigableSet = sortedVerbs1;
//
//        navigableSet.subSet(verbsService.printVerbs(sortedVerbs1, "c"),
//                verbsService.printVerbs(sortedVerbs1, "ò"));
//
//        navigableSet.forEach(System.out::println);

    }
}
