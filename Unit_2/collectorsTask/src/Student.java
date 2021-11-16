import java.util.concurrent.ThreadLocalRandom;

public class Student {
    private int age;
    private String name;
    private int id = ThreadLocalRandom.current().
            nextInt(0, 20000000);
    private Faculty faculty;

    public int getId() {
        return id;
    }

    public Student(int age, String name, Faculty faculty) {
        this.age = age;
        this.name = name;
        this.faculty = faculty;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", faculty=" + faculty +
                '}';
    }
}
