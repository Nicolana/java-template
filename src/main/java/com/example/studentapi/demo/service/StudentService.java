package com.example.studentapi.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.studentapi.demo.entity.Student;
import com.example.studentapi.demo.mapper.StudentMapper;

@Service
public class StudentService {
    private final StudentMapper studentMapper;

    public StudentService(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public List<Student> getAllStudents() {
        return studentMapper.findAll();
    }

    public Student getStudentById(Integer id) {
        return studentMapper.findById(id);
    }

    public Student addStudent(Student student) {
        studentMapper.insert(student);
        return student;
    }

    public void updateStudent(Student student) {
        studentMapper.update(student);
    }

    public void deleteStudent(Integer id) {
        studentMapper.delete(id);
    }
}
