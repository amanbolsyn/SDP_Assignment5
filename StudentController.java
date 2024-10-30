import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentViewModel studentViewModel;

    @GetMapping
    public List<Student> getStudents() {
        return studentViewModel.getStudents();
    }

    @PostMapping
    public void addStudent(@RequestBody Student student) {
        studentViewModel.addStudent(student.getName(), student.getAge(), student.getCourse());
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable Long id, @RequestBody Student student) {
        studentViewModel.updateStudent(id, student.getName(), student.getAge(), student.getCourse());
    }
}
