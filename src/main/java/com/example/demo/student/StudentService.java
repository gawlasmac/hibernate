package com.example.demo.student;


import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getStudents() {
        return studentRepository.findAll(Sort.by(Sort.DEFAULT_DIRECTION, "name"));
    }

    public void saveStudent(Student student) {
        if (studentRepository.findByEmail(student.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email exists");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new IllegalArgumentException("User dont exists");
        }
        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(Long id, String email, String name) {
        Student student =
                studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No student " + "with " +
                        "id: " + id));

        if (StringUtils.hasLength(email)) {
            student.setEmail(email);
        }
        if (StringUtils.hasLength(name)) {
            student.setName(name);
        }
    }
}
