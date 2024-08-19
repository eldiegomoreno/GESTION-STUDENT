import java.util.List;
import java.util.stream.Collectors;

public class StudentManagerImpl implements StudentManager {
    private GenericList<Student> studentList = new GenericList<>();
    @Override
    public void addStudent(Student student) {
        studentList.add(student);
    }
    @Override
    public void removeStudent(int id) throws StudentNotFoundException {
        Student student = findStudent(id);
        studentList.remove(student);
    }
    @Override
    public Student findStudent(int id) throws StudentNotFoundException {
        return studentList.getAll().stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElseThrow(() -> new StudentNotFoundException("Student not found with ID: " + id));
    }
    @Override
    public List<Student> getAllStudents() {
        return studentList.getAll();
    }
}
