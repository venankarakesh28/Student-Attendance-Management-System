package com.college.attendance.controller;

import com.college.attendance.model.Student;
import com.college.attendance.repository.StudentRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin
public class StudentController {
    private final StudentRepository students;
    public StudentController(StudentRepository students) { this.students = students; }

    @GetMapping public List<Student> all() { return students.findAll(); }
    @GetMapping("/{id}") public Student one(@PathVariable Long id) {
        return students.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
    }
    @PostMapping @ResponseStatus(HttpStatus.CREATED) public Student create(@Valid @RequestBody Student student) {
        if (students.findByRollNumber(student.getRollNumber()).isPresent())
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Roll number already exists");
        return students.save(student);
    }
    @PutMapping("/{id}") public Student update(@PathVariable Long id, @Valid @RequestBody Student input) {
        Student s = one(id);
        s.setRollNumber(input.getRollNumber()); s.setFullName(input.getFullName());
        s.setDepartment(input.getDepartment()); s.setYearOfStudy(input.getYearOfStudy()); s.setEmail(input.getEmail());
        return students.save(s);
    }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id) {
        students.delete(one(id));
    }
}
