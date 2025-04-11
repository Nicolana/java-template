package com.example.studentapi.demo.entity;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "学生信息实体")
public class Student {
    @Schema(description = "学生ID", example = "1")
    private Integer id;

    @Schema(description = "学生姓名", example = "张三")
    private String name;

    @Schema(description = "学生年龄", example = "18")
    private Integer age;

    @Schema(description = "学生性别", example = "男")
    private String gender;

    @Schema(description = "创建时间", example = "2024-04-11 10:00:00")
    private String createdAt; // 可以用 String，简单起见

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age; 
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    
}