package com.example.studentapi.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentapi.demo.dto.StudentDTO;
import com.example.studentapi.demo.vo.StudentVO;
import com.example.studentapi.demo.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "学生管理", description = "学生管理接口")
@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Operation(summary = "获取所有学生", description = "获取所有学生信息")
    @GetMapping
    public List<StudentVO> getAllStudents() {
        return studentService.getAllStudents();
    }

    @Operation(summary = "获取学生信息", description = "根据学生ID获取学生信息")
    @GetMapping("/{id}")
    public StudentVO getStudentById(@PathVariable Integer id) {
        return studentService.getStudentById(id);
    }

    @Operation(summary = "添加学生", description = "添加学生信息")
    @PostMapping
    public StudentVO addStudent(@RequestBody StudentDTO studentDTO) {
        return studentService.addStudent(studentDTO);
    }

    @Operation(summary = "更新学生", description = "更新学生信息")
    @PutMapping("/{id}")
    public StudentVO updateStudent(@PathVariable Integer id, @RequestBody StudentDTO studentDTO) {
        studentDTO.setId(id);
        return studentService.updateStudent(studentDTO);
    }

    @Operation(summary = "删除学生", description = "根据学生ID删除学生信息")
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
    }
}