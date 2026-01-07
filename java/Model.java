import java.util.ArrayList;
import java.util.List;

public class Model {
    private static final Model _instance = new Model();
    private List<Student> data = new ArrayList<>();

    public static Model instance() {
        return _instance;
    }

    private Model() {
        // You can add some "dummy" data here to test your list immediately
        for (int i = 0; i < 20; i++) {
            data.add(new Student("Student " + i, "" + i, "050-123456" + i, "Address " + i, false));
        }
    }

    public List<Student> getAllStudents() {
        return data;
    }

    public void addStudent(Student student) {
        data.add(student);
    }
}