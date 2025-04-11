package com.example.studentapi.demo.mapper;

import com.example.studentapi.demo.entity.Student;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {
    List<Student> findAll();
    Student findById(Integer id);
    int insert(Student student);
    void update(Student student);
    void delete(Integer id);
}
