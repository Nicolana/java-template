package com.example.studentapi.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.studentapi.demo.dto.StudentDTO;
import com.example.studentapi.demo.entity.Student;
import com.example.studentapi.demo.mapper.StudentMapper;
import com.example.studentapi.demo.vo.StudentVO;

@Service
public class StudentService {
    private final StudentMapper studentMapper;

    public StudentService(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public List<StudentVO> getAllStudents() {
        List<Student> students = studentMapper.findAll();
        return students.stream()
                .map(this::convertToVO)
                .collect(Collectors.toList());
    }

    public StudentVO getStudentById(Integer id) {
        Student student = studentMapper.findById(id);
        return convertToVO(student);
    }

    public StudentVO addStudent(StudentDTO studentDTO) {
        Student student = convertToEntity(studentDTO);
        studentMapper.insert(student);
        return convertToVO(student);
    }

    public StudentVO updateStudent(StudentDTO studentDTO) {
        Student student = convertToEntity(studentDTO);
        studentMapper.update(student);
        return convertToVO(student);
    }

    public void deleteStudent(Integer id) {
        studentMapper.delete(id);
    }

    private Student convertToEntity(StudentDTO dto) {
        Student student = new Student();
        student.setId(dto.getId());
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setGender(dto.getGender());
        student.setCreatedAt(dto.getCreatedAt());
        return student;
    }

    private StudentVO convertToVO(Student student) {
        StudentVO vo = new StudentVO();
        vo.setId(student.getId());
        vo.setName(student.getName());
        vo.setAge(student.getAge());
        vo.setGender(student.getGender());
        vo.setCreatedAt(student.getCreatedAt());
        return vo;
    }
}
