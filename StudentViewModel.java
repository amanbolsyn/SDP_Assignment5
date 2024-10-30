import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentViewModel {
    private List<Student> students = new ArrayList<>();
    private long nextId = 1;

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(String name, int age, String course) {
        Student student = new Student(nextId++, name, age, course);
        students.add(student);
    }

    public void updateStudent(Long id, String name, int age, String course) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                student.setName(name);
                student.setAge(age);
                student.setCourse(course);
                break;
            }
        }
    }

    public Student getStudent(Long id) {
        return students.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
    }
}
