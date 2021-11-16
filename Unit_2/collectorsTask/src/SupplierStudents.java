import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SupplierStudents implements Supplier<List<Student>> {
    private List<Student> students = Stream.of(
            new Student(18, "Коля", Faculty.CSIT),
            new Student(18, "Дима", Faculty.ECONOMICS),
            new Student(18, "Ваня", Faculty.CSIT),
            new Student(18, "Вася", Faculty.BIOLOGY),
            new Student(19, "Лена", Faculty.CSIT),
            new Student(19, "Лера", Faculty.BIOLOGY),
            new Student(19, "Соня", Faculty.CSIT),
            new Student(20, "Денис", Faculty.CSIT),
            new Student(20, "Данила", Faculty.ECONOMICS),
            new Student(21, "Илья", Faculty.CSIT),
            new Student(21, "Юля", Faculty.BIOLOGY)
    ).collect(Collectors.toList());

    @Override
    public List<Student> get() {
        return students;
    }
}
