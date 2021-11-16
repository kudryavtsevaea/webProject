import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new SupplierStudents().get();

        students.stream().map(Student::getId).collect(Collectors.toList())
                .forEach(System.out::println);


        System.out.println("Самое маленькое значение id");

        System.out.println(students.stream().map(Student::getId).
                collect(new MyCollector()));

    }
}
